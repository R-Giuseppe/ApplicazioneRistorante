import java.io.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.google.gson.*;

public class Menu {
    // Attributo:
    private ArrayList<Portate> portate;

    // Costruttore:
    public Menu() {
        this.portate = new ArrayList<>();
    }

    // Funzione per aggiungere una portata al menu:
    private void aggiungiPortate(Portate portata) {
        portate.add(portata);
    }

    // Funzione per rimuovere una portata dal menu:
    private void rimuoviPortate(Portate portata) {
        portate.remove(portata);
    }

    // Funzione per modificare una portata del menu:
    private void modificaPortata(Portate vecchiaPortata, Portate nuovaPortata) {
        int index = portate.indexOf(vecchiaPortata);
        if (index != -1) {
            portate.set(index, nuovaPortata);
        }
    }

    // Funzione per ordinare le portate del menu in base alla tipologia:
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

    // Funzione per la stampa del menu:
    private void stampaMenu() {
        ordinamentoPortate();
        for (Object piatto : portate) {
            System.out.println(piatto);
        }
    }

    // Funzione per la stampa degli antipasti:
    private void stampaAntipasti() {
        ordinamentoPortate();
        for (Object piatto : portate) {
            if (piatto instanceof Antipasti) {
                System.out.println(piatto);
            }
        }
    }

    // Funzione per la stampa dei primi piatti:
    private void stampaPrimiPiatti() {
        ordinamentoPortate();
        for (Object piatto : portate) {
            if (piatto instanceof PrimiPiatti) {
                System.out.println(piatto);
            }
        }
    }

    // Funzione per la stampa dei secondi piatti:
    private void stampaSecondiPiatti() {
        ordinamentoPortate();
        for (Object piatto : portate) {
            if (piatto instanceof SecondiPiatti) {
                System.out.println(piatto);
            }
        }
    }

    // Funzione per la stampa dei dessert:
    private void stampaDessert() {
        ordinamentoPortate();
        for (Object piatto : portate) {
            if (piatto instanceof Dessert) {
                System.out.println(piatto);
            }
        }
    }

    // Funzione per la stampa delle bevande:
    private void stampaBevande() {
        ordinamentoPortate();
        for (Object piatto : portate) {
            if (piatto instanceof Bevande) {
                System.out.println(piatto);
            }
        }
    }

    // Funzione per ottenere una portata in base al nome:
    private Portate getPortataPerNome(String nome) {
        for (Portate portata : portate) {
            if (portata.getNome().equals(nome)) {
                return portata;
            }
        }
        return null;
    }

    // Funzione per salvare il menu su file:
    private void scriviMenuJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ordinamentoPortate();
        try (Writer writer = new FileWriter("res/portate.json")) {
            gson.toJson(portate, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Funzione per caricare il menu da file:
    private void leggiJsonMenu(String filePath) {
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

    // Funzione del menu interattivo:
    public void menuInterattivo() {
        Scanner scanner = new Scanner(System.in);
        leggiJsonMenu("res/portate.json");

        while (true) {
            System.out.println("APPLICAZIONE RISTORANTE\n" + "Cosa vuoi fare?\n");
            System.out.println("1. Mostra il menu corrente");
            System.out.println("2. Aggiungi una nuova portata al menu");
            System.out.println("3. Rimuovi una portata dal menu");
            System.out.println("4. Modifica una portata");
            System.out.println("5. Salva il menu");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                // Stampa del menu:
                case 1:
                    stampaMenu();
                    break;

                // Aggiunta di una portata:
                case 2:
                    System.out.println("Scegli il tipo di portata da aggiungere: ");
                    System.out.println("1. Antipasto");
                    System.out.println("2. Primo piatto");
                    System.out.println("3. Secondo piatto");
                    System.out.println("4. Dessert");
                    System.out.println("5. Bevanda");
                    System.out.print("Scelta: ");
                    int sceltaTipo = scanner.nextInt();
                    scanner.nextLine();

                    switch (sceltaTipo) {
                        case 1:
                            System.out.println("Inserisci il nome dell'antipasto: ");
                            String nomeAntipasto = scanner.nextLine();
                            System.out.println("Inserisci la descrizione: ");
                            String descrizioneAntipasto = scanner.nextLine();
                            System.out.println("Inserisci il prezzo:");
                            int prezzoAntipasto = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Inserisci gli ingredienti (separati da virgola e spazio):");
                            String[] ingredientiAntipasto = scanner.nextLine().split(", ");
                            System.out.println("L'antipasto è per vegetariani? (true / false): ");
                            boolean vegetariano = scanner.nextBoolean();
                            aggiungiPortate(new Antipasti(nomeAntipasto, descrizioneAntipasto, prezzoAntipasto, ingredientiAntipasto, vegetariano));
                            stampaAntipasti();
                            System.out.println("Antipasto aggiunto correttamente");
                            break;
                        case 2:
                            System.out.println("Inserisci il nome del primo piatto: ");
                            String nuovoPrimoPiatto = scanner.nextLine();
                            System.out.println("Inserisci la descrizione: ");
                            String descrizionePrimoPiatto = scanner.nextLine();
                            System.out.println("Inserisci il prezzo: ");
                            int prezzoPrimoPiatto = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Inserisci gli ingredienti (separati da virgola e spazio):");
                            String[] ingredientiPrimoPiatto = scanner.nextLine().split(", ");
                            System.out.println("Il piatto contiene glutine? (true / false): ");
                            boolean contieneGlutine = scanner.nextBoolean();
                            aggiungiPortate(new PrimiPiatti(nuovoPrimoPiatto, descrizionePrimoPiatto, prezzoPrimoPiatto, ingredientiPrimoPiatto, contieneGlutine));
                            stampaPrimiPiatti();
                            System.out.println("Primo piatto aggiunto correttamente");
                            break;
                        case 3:
                            System.out.println("Inserisci il nome del secondo piatto: ");
                            String nuovoSecondoPiatto = scanner.nextLine();
                            System.out.println("Inserisci la descrizione: ");
                            String descrizioneSecondoPiatto = scanner.nextLine();
                            System.out.println("Inserisci il prezzo: ");
                            int prezzoSecondoPiatto = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Inserisci gli ingredienti (separati da virgola e spazio):");
                            String[] ingredientiSecondoPiatto = scanner.nextLine().split(", ");
                            System.out.println("Il piatto è ben cotto o al sangue? (true = ben cotto / false = al sangue): ");
                            boolean tipoCottura = scanner.nextBoolean();
                            aggiungiPortate(new SecondiPiatti(nuovoSecondoPiatto, descrizioneSecondoPiatto, prezzoSecondoPiatto, ingredientiSecondoPiatto, tipoCottura));
                            stampaSecondiPiatti();
                            System.out.println("Secondo piatto aggiunto correttamente");
                            break;
                        case 4:
                            System.out.println("Inserisci il nome del dessert: ");
                            String nuovoDessert = scanner.nextLine();
                            System.out.println("Inserisci la descrizione: ");
                            String descrizioneDessert = scanner.nextLine();
                            System.out.println("Inserisci il prezzo: ");
                            int prezzoDessert = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Inserisci gli ingredienti (separati da virgola e spazio):");
                            String[] ingredientiDessert = scanner.nextLine().split(", ");
                            System.out.println("Il dessert contiene lattosio? (true / false): ");
                            boolean contieneLattosio = scanner.nextBoolean();
                            aggiungiPortate(new Dessert(nuovoDessert, descrizioneDessert, prezzoDessert, ingredientiDessert, contieneLattosio));
                            stampaDessert();
                            System.out.println("Dessert aggiunto correttamente");
                            break;
                        case 5:
                            System.out.println("Inserisci il nome della bevanda da aggiungere: ");
                            String nuovaBevanda = scanner.nextLine();
                            System.out.println("Inserisci la descrizione: ");
                            String descrizioneBevanda = scanner.nextLine();
                            System.out.println("Inserisci il prezzo: ");
                            int prezzoBevanda = scanner.nextInt();
                            System.out.println("La bevanda è calda o fredda? (true = fredda / false = calda):");
                            boolean temperatura = scanner.nextBoolean();
                            aggiungiPortate(new Bevande(nuovaBevanda, descrizioneBevanda, prezzoBevanda, temperatura));
                            stampaBevande();
                            System.out.println("Bevanda aggiunta correttamente");
                            break;
                        default:
                            System.err.println("Scelta non valida. Riprova.");
                            break;

                    }
                    break;

                    // Rimozione di una portata:
                case 3:
                    System.out.println("Scegli il tipo di portata da rimuovere: ");
                    System.out.println("1. Antipasto");
                    System.out.println("2. Primo piatto");
                    System.out.println("3. Secondo piatto");
                    System.out.println("4. Dessert");
                    System.out.println("5. Bevanda");
                    System.out.print("Scelta: ");
                    int tipoRimozione = scanner.nextInt();
                    scanner.nextLine();

                    switch (tipoRimozione) {
                        case 1:
                            stampaAntipasti();
                            System.out.println("Inserisci il nome dell'antipasto da rimuovere: ");
                            String nomeAntipastoDaRimuovere = scanner.nextLine();
                            Portate antipastoDaRimuovere = getPortataPerNome(nomeAntipastoDaRimuovere);
                            if (antipastoDaRimuovere != null) {
                                rimuoviPortate(antipastoDaRimuovere);
                                stampaAntipasti();
                                System.out.println("Antipasto rimosso correttamente.");
                            } else {
                                System.err.println("Antipasto non trovato nel menu.");
                            }
                            break;
                        case 2:
                            stampaPrimiPiatti();
                            System.out.println("Inserisci il nome del primo piatto da rimuovere: ");
                            String nomePrimoPiattoDaRimuovere = scanner.nextLine();
                            Portate primoPiattoDaRimuovere = getPortataPerNome(nomePrimoPiattoDaRimuovere);
                            if (primoPiattoDaRimuovere != null) {
                                rimuoviPortate(primoPiattoDaRimuovere);
                                stampaPrimiPiatti();
                                System.out.println("Primo piatto rimosso correttamente.");
                            } else {
                                System.err.println("Primo piatto non trovato nel menu.");
                            }
                            break;
                        case 3:
                            stampaSecondiPiatti();
                            System.out.println("Inserisci il nome del secondo piatto da rimuovere: ");
                            String nomeSecondoPiattoDaRimuovere = scanner.nextLine();
                            Portate secondoPiattoDaRimuovere = getPortataPerNome(nomeSecondoPiattoDaRimuovere);
                            if (secondoPiattoDaRimuovere != null) {
                                rimuoviPortate(secondoPiattoDaRimuovere);
                                stampaSecondiPiatti();
                                System.out.println("Secondo piatto rimosso correttamente.");
                            } else {
                                System.err.println("Secondo piatto non trovato nel menu.");
                            }
                            break;
                        case 4:
                            stampaDessert();
                            System.out.println("Inserisci il nome del dessert da rimuovere: ");
                            String nomeDessertDaRimuovere = scanner.nextLine();
                            Portate dessertDaRimuovere = getPortataPerNome(nomeDessertDaRimuovere);
                            if (dessertDaRimuovere != null) {
                                rimuoviPortate(dessertDaRimuovere);
                                stampaDessert();
                                System.out.println("Dessert rimosso correttamente.");
                            } else {
                                System.err.println("Dessert non trovato nel menu.");
                            }
                            break;
                        case 5:
                            stampaBevande();
                            System.out.println("Inserisci il nome della bevanda da rimuovere: ");
                            String nomeBevandaDaRimuovere = scanner.nextLine();
                            Portate bevandaDaRimuovere = getPortataPerNome(nomeBevandaDaRimuovere);
                            if (bevandaDaRimuovere != null) {
                                rimuoviPortate(bevandaDaRimuovere);
                                stampaBevande();
                                System.out.println("Bevanda rimossa correttamente.");
                            } else {
                                System.err.println("Bevanda non trovata nel menu.");
                            }
                            break;
                        default:
                            System.err.println("Scelta non valida. Riprova.");
                            break;
                    }
                    break;

                // Modifica di una portata:
                case 4:
                    System.out.println("Scegli il tipo di portata da modificare:");
                    System.out.println("1. Antipasto");
                    System.out.println("2. Primo piatto");
                    System.out.println("3. Secondo piatto");
                    System.out.println("4. Dessert");
                    System.out.println("5. Bevanda");
                    System.out.print("Scelta: ");
                    int tipoModifica = scanner.nextInt();
                    scanner.nextLine();

                    switch(tipoModifica) {
                        case 1:
                            stampaAntipasti();
                            System.out.println("Inserisci il nome dell'antipasto da modificare: ");
                            String nomeAntipastoDaModificare = scanner.nextLine();
                            Portate antipastoDaModificare = getPortataPerNome(nomeAntipastoDaModificare);
                            if (antipastoDaModificare != null) {
                                System.out.println("Inserisci il nuovo nome dell'antipasto: ");
                                String nuovoNomeAntipasto = scanner.nextLine();
                                System.out.println("Inserisci la nuova descrizione dell'antipasto: ");
                                String nuovaDescrizioneAntipasto = scanner.nextLine();
                                System.out.println("Inserisci il nuovo prezzo dell'antipasto: ");
                                double nuovoPrezzoAntipasto = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println("Inserisci i nuovi ingredienti dell'antipasto (separati da virgola e spazio): ");
                                String[] nuoviIngredientiAntipasto = scanner.nextLine().split(", ");
                                System.out.println("L'antipasto è per vegetariani? (true / false): ");
                                boolean vegetariano = scanner.nextBoolean();
                                Antipasti antipastoModificato = new Antipasti(nuovoNomeAntipasto, nuovaDescrizioneAntipasto, nuovoPrezzoAntipasto, nuoviIngredientiAntipasto, vegetariano);
                                modificaPortata(antipastoDaModificare, antipastoModificato);
                                stampaAntipasti();
                                System.out.println("Antipasto modificato correttamente.");
                            } else {
                                System.err.println("Antipasto non trovato nel menu.");
                            }
                            break;
                        case 2:
                            stampaPrimiPiatti();
                            System.out.println("Inserisci il nome del primo piatto da modificare: ");
                            String nomePrimoPiattoDaModificare = scanner.nextLine();
                            Portate primoPiattoDaModificare = getPortataPerNome(nomePrimoPiattoDaModificare);
                            if (primoPiattoDaModificare != null) {
                                System.out.println("Inserisci il nuovo nome del primo piatto: ");
                                String nuovoNomePrimoPiatto = scanner.nextLine();
                                System.out.println("Inserisci la nuova descrizione del primo piatto: ");
                                String nuovaDescrizionePrimoPiatto = scanner.nextLine();
                                System.out.println("Inserisci il nuovo prezzo del primo piatto: ");
                                double nuovoPrezzoPrimoPiatto = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println("Inserisci i nuovi ingredienti del primo piatto (separati da virgola e spazio): ");
                                String[] nuoviIngredientiPrimoPiatto = scanner.nextLine().split(", ");
                                System.out.println("Il piatto contiene glutine? (true / false): ");
                                boolean contieneGlutine = scanner.nextBoolean();
                                PrimiPiatti primoPiattoModificato = new PrimiPiatti(nuovoNomePrimoPiatto, nuovaDescrizionePrimoPiatto, nuovoPrezzoPrimoPiatto, nuoviIngredientiPrimoPiatto, contieneGlutine);
                                modificaPortata(primoPiattoDaModificare, primoPiattoModificato);
                                stampaPrimiPiatti();
                                System.out.println("Primo piatto modificato correttamente.");
                            } else {
                                System.err.println("Primo piatto non trovato nel menu.");
                            }
                            break;
                        case 3:
                            stampaSecondiPiatti();
                            System.out.println("Inserisci il nome del secondo piatto da modificare: ");
                            String nomeSecondoPiattoDaModificare = scanner.nextLine();
                            Portate secondoPiattoDaModificare = getPortataPerNome(nomeSecondoPiattoDaModificare);
                            if (secondoPiattoDaModificare != null) {
                                System.out.println("Inserisci il nuovo nome del secondo piatto: ");
                                String nuovoNomeSecondoPiatto = scanner.nextLine();
                                System.out.println("Inserisci la nuova descrizione del secondo piatto: ");
                                String nuovaDescrizioneSecondoPiatto = scanner.nextLine();
                                System.out.println("Inserisci il nuovo prezzo del secondo piatto: ");
                                double nuovoPrezzoSecondoPiatto = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println("Inserisci i nuovi ingredienti del secondo piatto (separati da virgola e spazio): ");
                                String[] nuoviIngredientiSecondoPiatto = scanner.nextLine().split(", ");
                                System.out.println("Qual è la cottura del piatto? (true = ben cotto / false = al sangue): ");
                                boolean tipoCotturaPiatto = scanner.nextBoolean();
                                SecondiPiatti secondoPiattoModificato = new SecondiPiatti(nuovoNomeSecondoPiatto, nuovaDescrizioneSecondoPiatto, nuovoPrezzoSecondoPiatto, nuoviIngredientiSecondoPiatto, tipoCotturaPiatto);
                                modificaPortata(secondoPiattoDaModificare, secondoPiattoModificato);
                                stampaSecondiPiatti();
                                System.out.println("Secondo piatto modificato correttamente.");
                            } else {
                                System.err.println("Secondo piatto non trovato nel menu.");
                            }
                            break;
                        case 4:
                            stampaDessert();
                            System.out.println("Inserisci il nome del dessert da modificare: ");
                            String nomeDessertDaModificare = scanner.nextLine();
                            Portate dessertDaModificare = getPortataPerNome(nomeDessertDaModificare);
                            if (dessertDaModificare != null) {
                                System.out.println("Inserisci il nuovo nome del dessert: ");
                                String nuovoNomeDessert = scanner.nextLine();
                                System.out.println("Inserisci la nuova descrizione del dessert: ");
                                String nuovaDescrizioneDessert = scanner.nextLine();
                                System.out.println("Inserisci il nuovo prezzo del dessert: ");
                                double nuovoPrezzoDessert = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println("Inserisci i nuovi ingredienti del dessert (separati da virgola e spazio): ");
                                String[] nuoviIngredientiDessert = scanner.nextLine().split(", ");
                                System.out.println("Il dessert contiene lattosio? (true / false): ");
                                boolean contieneLattosio = scanner.nextBoolean();
                                Dessert dessertModificato = new Dessert(nuovoNomeDessert, nuovaDescrizioneDessert, nuovoPrezzoDessert, nuoviIngredientiDessert, contieneLattosio);
                                modificaPortata(dessertDaModificare, dessertModificato);
                                stampaDessert();
                                System.out.println("Dessert modificato correttamente.");
                            } else {
                                System.err.println("Dessert non trovato nel menu.");
                            }
                            break;
                        case 5:
                            stampaBevande();
                            System.out.println("Inserisci il nome della bevanda da modificare: ");
                            String nomeBevandaDaModificare = scanner.nextLine();
                            Portate bevandaDaModificare = getPortataPerNome(nomeBevandaDaModificare);
                            if (bevandaDaModificare != null) {
                                System.out.println("Inserisci il nuovo nome della bevanda: ");
                                String nuovoNomeBevanda = scanner.nextLine();
                                System.out.println("Inserisci la nuova descrizione della bevanda: ");
                                String nuovaDescrizioneBevanda = scanner.nextLine();
                                System.out.println("Inserisci il nuovo prezzo della bevanda: ");
                                double nuovoPrezzoBevanda = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println("La bevanda è calda o fredda? (true = fredda / false = calda): ");
                                boolean temperaturaBevanda = scanner.nextBoolean();
                                Bevande bevandaModificata = new Bevande(nuovoNomeBevanda, nuovaDescrizioneBevanda, nuovoPrezzoBevanda, temperaturaBevanda);
                                modificaPortata(bevandaDaModificare, bevandaModificata);
                                stampaBevande();
                                System.out.println("Bevanda modificata correttamente.");
                            } else {
                                System.err.println("Bevanda non trovata nel menu.");
                            }
                            break;
                        default:
                            System.err.println("Tipologia non riconosciuta");
                            break;
                    }
                    break;

                    // Salvataggio del menu:
                case 5:
                    scriviMenuJson();
                    break;

                // Uscita:
                case 0:
                    System.out.println("Arrivederci!");
                    scanner.close();
                    System.exit(0);
                    break;

                // Caso default:
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }
        }
    }
}
