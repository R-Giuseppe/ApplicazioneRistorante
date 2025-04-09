import java.io.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.google.gson.*;

public class Menu {

    private final ArrayList<Portate> portate;

    public Menu() {
        this.portate = new ArrayList<>();
    }

    // Funzione per aggiungere una portata al menu:
    public void aggiungiPortate(Portate portata) {
        portate.add(portata);
    }

    // Funzione per rimuovere una portata dal menu:
    public void rimuoviPortate(Portate portata) {
        portate.remove(portata);
    }

    // Funzione per modificare una portata del menu:
    public void modificaPortata(Portate vecchiaPortata, Portate nuovaPortata) {
        int index = portate.indexOf(vecchiaPortata);
        if (index != -1) {
            portate.set(index, nuovaPortata);
        }
    }

    // Funzione per ordinare le portate del menu in base alla tipologia:
    public void ordinamentoPortate() {
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

    // Funzione per la stampa del menu:
    public void stampaMenu() {
        ordinamentoPortate();
        for (Object piatto : portate) {
            System.out.println(piatto);
        }
    }

    // Funzione per la stampa del menu in base alla tipologia della portata:
    public void stampaMenuPerTipo(String tipologia) {
        int contatore = 0;
        ordinamentoPortate();
        System.out.println("\nMenu aggiornato per la tipologia " + tipologia + ": \n");
        for (Portate portata : portate) {
            if (portata.getTipologia().equals(tipologia)) {
                System.out.println(portata);
                contatore++;
            }
        }
        if (contatore == 0) {
            System.out.println("Non sono state trovate portate della tipologia " + tipologia + " all'interno del menu");
        }
    }

    // Funzione per ottenere una portata in base al nome:
    public Portate getPortataPerNome(String nome) {
        for (Portate portata : portate) {
            if (portata.getNome().equals(nome)) {
                return portata;
            }
        }
        return null;
    }

    // Funzione per salvare il menu su file:
    public void scriviMenuJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ordinamentoPortate();
        try (Writer writer = new FileWriter("res/portate.json")) {
            gson.toJson(portate, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Funzione per caricare il menu da file:
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
