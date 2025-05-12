public class MenuConsoleHandler {

    private final Menu menu;
    private final InputHandler menuInputHandler;

    public MenuConsoleHandler(Menu menu, InputHandler menuInputHandler) {
        this.menu = menu;
        this.menuInputHandler = menuInputHandler;
    }

    public void menuInterattivo() {
        menu.leggiJsonMenu("res/portate.json");

        while (true) {
            try {
                System.out.println("\u001B[36m=====================================");
                System.out.println("""
                        APPLICAZIONE RISTORANTE
                        Cosa vuoi fare?
                        """);
                System.out.println("1. Mostra il menu corrente");
                System.out.println("2. Aggiungi una nuova portata al menu");
                System.out.println("3. Rimuovi una portata dal menu");
                System.out.println("4. Modifica una portata");
                System.out.println("5. Salva il menu");
                System.out.println("0. Esci");
                System.out.println("=====================================");

                int scelta = menuInputHandler.leggiIntero("\nScelta: " + "\u001B[0m");
                menuInputHandler.scannerNextLine();

                System.out.print("\n");

                switch (scelta) {
                    case 1: // Mostra il menu corrente
                        menu.stampaMenu();
                        break;

                    case 2: // Aggiungi una nuova portata al menu
                        String tipo;

                        // ripetizione della richiesta del tipo finché non è valido
                        while (true) {
                            tipo = menuInputHandler.leggiStringa("Inserisci il tipo della nuova portata (antipasto, primo_piatto, secondo_piatto, dessert, bevanda): ");

                            if (tipo.equals("antipasto") || tipo.equals("primo_piatto") || tipo.equals("secondo_piatto") || tipo.equals("dessert") || tipo.equals("bevanda")) {
                                break;
                            } else {
                                System.err.println("\u001B[31mErrore: Tipo di portata non valido. Riprova con uno dei seguenti: antipasto, primo_piatto, secondo_piatto, dessert, bevanda.\u001B[0m");
                            }
                        }

                        String nome = menuInputHandler.leggiStringa("Inserisci il nome della portata: ");
                        String descrizione = menuInputHandler.leggiStringa("Inserisci la descrizione della portata: ");
                        double prezzo = menuInputHandler.leggiDouble("Inserisci il prezzo della portata: ");
                        String[] ingredienti = menuInputHandler.leggiArrayStringa("Inserisci gli ingredienti della nuova portata (separati da virgola e spazio): ");

                        switch (tipo) {
                            case "antipasto" -> {
                                boolean vegetariano = menuInputHandler.leggiBooleano("L'antipasto è per vegetariani? (true / false): ");
                                Antipasti portata = new Antipasti(nome, descrizione, prezzo, ingredienti, vegetariano);
                                menu.aggiungiPortataValidata(portata);
                            }
                            case "primo_piatto" -> {
                                boolean contieneGlutine = menuInputHandler.leggiBooleano("Il piatto contiene glutine? (true / false): ");
                                PrimiPiatti portata = new PrimiPiatti(nome, descrizione, prezzo, ingredienti, contieneGlutine);
                                menu.aggiungiPortataValidata(portata);
                            }
                            case "secondo_piatto" -> {
                                boolean tipoCottura = menuInputHandler.leggiBooleano("Il piatto è ben cotto o al sangue? (true = ben cotto / false = al sangue): ");
                                SecondiPiatti portata = new SecondiPiatti(nome, descrizione, prezzo, ingredienti, tipoCottura);
                                menu.aggiungiPortataValidata(portata);
                            }
                            case "dessert" -> {
                                boolean contieneLattosio = menuInputHandler.leggiBooleano("Il dessert contiene lattosio? (true / false): ");
                                Dessert portata = new Dessert(nome, descrizione, prezzo, ingredienti, contieneLattosio);
                                menu.aggiungiPortataValidata(portata);
                            }
                            case "bevanda" -> {
                                boolean temperatura = menuInputHandler.leggiBooleano("La bevanda è calda o fredda? (true = fredda / false = calda):");
                                Bevande portata = new Bevande(nome, descrizione, prezzo, temperatura);
                                menu.aggiungiPortataValidata(portata);
                            }
                        }
                        menuInputHandler.scannerNextLine(); // pulisce lo scanner in modo che l'input errato non interferisca con ulteriori letture.
                        break;

                    case 3: // Rimuovi una portata dal menu
                        while (true) {
                            try {
                                String nomePortata = menuInputHandler.leggiStringa("Inserisci il nome della portata da rimuovere: ");
                                Portate portataDaRimuovere = menu.getPortataPerNome(nomePortata);

                                // lancia un'eccezione se la portata è null (non esiste)
                                if (portataDaRimuovere == null) {
                                    throw new IllegalArgumentException("Portata non trovata nel menu. Riprova.");
                                }

                                menu.rimuoviPortate(portataDaRimuovere);
                                System.out.println("Portata rimossa correttamente.");
                                menu.stampaMenuPerTipo(portataDaRimuovere.getTipologia());
                                break;

                            } catch (IllegalArgumentException e) { // gestisce l'errore relativo a un argomento non valido
                                System.err.println("\u001B[31mErrore: " + e.getMessage() + "\u001B[0m");
                            }
                        }
                        break;

                    case 4: // Modifica una portata
                        while (true) {
                            try {
                                String nomePortataDaModificare = menuInputHandler.leggiStringa("Inserisci il nome della portata da modificare: ");
                                Portate portataDaModificare = menu.getPortataPerNome(nomePortataDaModificare);

                                // lancia un'eccezione se la portata è null (non esiste)
                                if (portataDaModificare == null) {
                                    throw new IllegalArgumentException("Portata non trovata nel menu. Riprova.");
                                }

                                String nuovoNomePortata = menuInputHandler.leggiStringa("Inserisci il nuovo nome della portata: ");
                                String nuovaDescrizionePortata = menuInputHandler.leggiStringa("Inserisci la nuova descrizione della portata: ");
                                double nuovoPrezzoPortata = menuInputHandler.leggiDouble("Inserisci il nuovo prezzo della portata: ");
                                String[] nuoviIngredientiPortata = menuInputHandler.leggiArrayStringa("Inserisci i nuovi ingredienti della portata (separati da virgola e spazio): ");

                                switch (portataDaModificare.getTipologia()) {
                                    case "antipasto" -> {
                                        boolean isVegetariano = menuInputHandler.leggiBooleano("L'antipasto è per vegetariani? (true / false): ");
                                        Antipasti portataModificata = new Antipasti(nuovoNomePortata, nuovaDescrizionePortata, nuovoPrezzoPortata, nuoviIngredientiPortata, isVegetariano);
                                        menu.modificaPortataValidata(portataDaModificare, portataModificata);
                                    }
                                    case "primo_piatto" -> {
                                        boolean contieneGlutine = menuInputHandler.leggiBooleano("Il piatto contiene glutine? (true / false): ");
                                        PrimiPiatti portataModificata = new PrimiPiatti(nuovoNomePortata, nuovaDescrizionePortata, nuovoPrezzoPortata, nuoviIngredientiPortata, contieneGlutine);
                                        menu.modificaPortataValidata(portataDaModificare, portataModificata);
                                    }
                                    case "secondo_piatto" -> {
                                        boolean tipoCottura = menuInputHandler.leggiBooleano("Il piatto è ben cotto o al sangue? (true = ben cotto / false = al sangue): ");
                                        SecondiPiatti portataModificata = new SecondiPiatti(nuovoNomePortata, nuovaDescrizionePortata, nuovoPrezzoPortata, nuoviIngredientiPortata, tipoCottura);
                                        menu.modificaPortataValidata(portataDaModificare, portataModificata);
                                    }
                                    case "dessert" -> {
                                        boolean contieneLattosio = menuInputHandler.leggiBooleano("Il dessert contiene lattosio? (true / false): ");
                                        Dessert portataModificata = new Dessert(nuovoNomePortata, nuovaDescrizionePortata, nuovoPrezzoPortata, nuoviIngredientiPortata, contieneLattosio);
                                        menu.modificaPortataValidata(portataDaModificare, portataModificata);
                                    }
                                    case "bevanda" -> {
                                        boolean caldoFreddo = menuInputHandler.leggiBooleano("La bevanda è calda o fredda? (true = fredda / false = calda): ");
                                        Bevande portataModificata = new Bevande(nuovoNomePortata, nuovaDescrizionePortata, nuovoPrezzoPortata, caldoFreddo);
                                        menu.modificaPortataValidata(portataDaModificare, portataModificata);
                                    }
                                }
                                break;

                            } catch (IllegalArgumentException e) {
                                System.err.println("\u001B[31mErrore: " + e.getMessage() + "\u001B[0m");
                            }
                        }
                        break;

                    case 5: // Salva il menu
                        menu.scriviMenuJson();
                        break;

                    case 0: // Esci
                        System.out.println("\u001B[36m" + "Arrivederci!" + "\u001B[0m");
                        System.exit(0);
                        break;

                    default: // Scelta non valida
                        System.out.println("\u001B[36m" + "Scelta non valida. Riprova." + "\u001B[0m");
                        break;
                }
            } catch (Exception e) {
                System.err.println("\u001B[31mErrore inatteso: " + e.getMessage() + "\u001B[0m");
            }
        }
    }
}