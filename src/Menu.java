import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import javax.sound.sampled.Port;

public class Menu {
    private ArrayList<Portate> portate;

    public Menu() {
        this.portate = new ArrayList<>();
    }

    public void aggiungiPortate(Portate portata) {
        portate.add(portata);
    }

    public void rimuoviPortate(Portate portata) {
        portate.remove(portata);
    }

    public void modificaPortata(Portate vecchiaPortata, Portate nuovaPortata) {
        int index = portate.indexOf(vecchiaPortata);
        if (index != -1) {
            portate.set(index, nuovaPortata);
        }
    }

    private void ordinamentoPortate() {
        Collections.sort(this.portate, new Comparator<Portate>() {
            @Override
            public int compare(Portate p1, Portate p2) {
                int ordineP1 = getOrdine(p1);
                int ordineP2 = getOrdine(p2);
                return Integer.compare(ordineP1, ordineP2);
            }

            private int getOrdine(Portate portata) {
                return switch (portata.tipologia) {
                    case "antipasto" -> 1;
                    case "primo_piatto" -> 2;
                    case "secondo_piatto" -> 3;
                    case "dessert" -> 4;
                    case "bevanda" -> 5;
                    default -> 6;
                };
            }
        });
    }

    public void stampaMenu() {
        ordinamentoPortate();
        for (Object piatto : portate) {
            System.out.println(piatto);
        }
    }

    public void scriviMenuJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ordinamentoPortate();
        try (Writer writer = new FileWriter("res/portate.json")) {
            gson.toJson(portate, writer); // Scrive l'intera lista come un array JSON
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leggiJsonMenu(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            for (JsonElement element : jsonArray) {
                JsonObject jsonObject = element.getAsJsonObject();
                if (jsonObject.has("tipologia")) {
                    String tipologia = jsonObject.get("tipologia").getAsString();
                    switch (tipologia) {
                        case "antipasto":
                            Antipasti antipasto = gson.fromJson(jsonObject, Antipasti.class);
                            portate.add(antipasto);
                            break;
                        case "primo_piatto":
                            PrimiPiatti primoPiatto = gson.fromJson(jsonObject, PrimiPiatti.class);
                            portate.add(primoPiatto);
                            break;
                        case "secondo_piatto":
                            SecondiPiatti secondoPiatto = gson.fromJson(jsonObject, SecondiPiatti.class);
                            portate.add(secondoPiatto);
                            break;
                        case "bevanda":
                            Bevande bevanda = gson.fromJson(jsonObject, Bevande.class);
                            portate.add(bevanda);
                            break;
                        case "dessert":
                            Dessert dessert = gson.fromJson(jsonObject, Dessert.class);
                            portate.add(dessert);
                            break;
                        default:
                            System.out.println("Tipologia non riconosciuta: " + tipologia);
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
