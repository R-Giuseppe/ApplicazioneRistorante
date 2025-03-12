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
                if (portata instanceof Antipasti) return 1;
                // if (portata instanceof PrimiPiatti) return 2;
                if (portata instanceof SecondiPiatti) return 3;
                if (portata instanceof Bevande) return 4;
                // if (portata instanceof Dessert) return 5;
                return 6;
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
                if (jsonObject.has("vegetariano")) {
                    // È un Antipasto
                    Antipasti antipasto = gson.fromJson(jsonObject, Antipasti.class);
                    portate.add(antipasto);
                } else if (jsonObject.has("tipoCottura")) {
                    // È un SecondoPiatti
                    SecondiPiatti secondoPiatto = gson.fromJson(jsonObject, SecondiPiatti.class);
                    portate.add(secondoPiatto);
                } else if (jsonObject.has("temperatura")) {
                    // È una Bevanda
                    Bevande bevanda = gson.fromJson(jsonObject, Bevande.class);
                    portate.add(bevanda);
                }
                // Potresti aggiungere un else per gestire altri tipi di portate
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public void leggiMenuJson() {
        Gson gson = new Gson();
        // Read JSON from a file
        try (Reader reader = new FileReader("src/portate.json")) {

            // convert the JSON data to a Java object
            Portate portata = gson.fromJson(reader, Portate.class);
            System.out.println(portata);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
}
