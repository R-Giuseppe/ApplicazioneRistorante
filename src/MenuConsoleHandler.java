import java.util.List;

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

                // Mostra il menu corrente:
                case 1:
                    menu.stampaMenu();
                    break;

                // Aggiungi una nuova portata al menu:
                case 2:
                    String tipo = menuInputHandler.leggiStringa("Inserisci il tipo della nuova portata (antipasto, primo_piatto, secondo_piatto, dessert, bevanda): ");
                    String nome = menuInputHandler.leggiStringa("Inserisci il nome della portata: ");
                    String descrizione = menuInputHandler.leggiStringa("Inserisci la descrizione della portata: ");
                    double prezzo = menuInputHandler.leggiDouble("Inserisci il prezzo della portata: ");
                    String[] ingredienti = menuInputHandler.leggiArrayStringa("Inserisci gli ingredienti della nuova portata (separati da virgola e spazio): ");

                    switch (tipo) {
                        case "antipasto" -> {
                            boolean vegetariano = menuInputHandler.leggiBooleano("L'antipasto è per vegetariani? (true / false): ");
                            menu.aggiungiPortate(new Antipasti(nome, descrizione, prezzo, ingredienti, vegetariano));
                            menu.stampaMenuPerTipo("antipasto");
                        }
                        case "primo_piatto" -> {
                            boolean contieneGlutine = menuInputHandler.leggiBooleano("Il piatto contiene glutine? (true / false): ");
                            menu.aggiungiPortate(new PrimiPiatti(nome, descrizione, prezzo, ingredienti, contieneGlutine));
                            menu.stampaMenuPerTipo("primo_piatto");
                        }
                        case "secondo_piatto" -> {
                            boolean tipoCottura = menuInputHandler.leggiBooleano("Il piatto è ben cotto o al sangue? (true = ben cotto / false = al sangue): ");
                            menu.aggiungiPortate(new SecondiPiatti(nome, descrizione, prezzo, ingredienti, tipoCottura));
                            menu.stampaMenuPerTipo("secondo_piatto");
                        }
                        case "dessert" -> {
                            boolean contieneLattosio = menuInputHandler.leggiBooleano("Il dessert contiene lattosio? (true / false): ");
                            menu.aggiungiPortate(new Dessert(nome, descrizione, prezzo, ingredienti, contieneLattosio));
                            menu.stampaMenuPerTipo("dessert");
                        }
                        case "bevanda" -> {
                            boolean temperatura = menuInputHandler.leggiBooleano("La bevanda è calda o fredda? (true = fredda / false = calda):");
                            menu.aggiungiPortate(new Bevande(nome, descrizione, prezzo, temperatura));
                            menu.stampaMenuPerTipo("bevanda");
                        }
                    }
                    break;

                // Rimuovi una portata dal menu:
                case 3:
                    Portate portataDaRimuovere = menu.getPortataPerNome(menuInputHandler.leggiStringa("Inserisci il nome della portata da rimuovere: "));

                    if (portataDaRimuovere != null) {
                        menu.rimuoviPortate(portataDaRimuovere);
                        System.out.println("Portata rimossa correttamente.");
                        menu.stampaMenuPerTipo(portataDaRimuovere.getTipologia());
                    } else {
                        System.err.println("Portata non trovata nel menu.");
                    }

                    System.out.print("\n");
                    break;

                // Modifica una portata:
                case 4:
                    Portate portataDaModificare = menu.getPortataPerNome(menuInputHandler.leggiStringa("Inserisci il nome della portata da modificare: "));
                    String nuovoNomePortata = menuInputHandler.leggiStringa("Inserisci il nuovo nome della portata: ");
                    String nuovaDescrizionePortata = menuInputHandler.leggiStringa("Inserisci la nuova descrizione della portata: ");
                    double nuovoPrezzoPortata = menuInputHandler.leggiDouble("Inserisci il nuovo prezzo della portata: ");
                    String[] nuoviIngredientiPortata = menuInputHandler.leggiArrayStringa("Inserisci i nuovi ingredienti della portata (separati da virgola e spazio): ");

                    switch (portataDaModificare.getTipologia()) {
                        case "antipasto" -> {
                            boolean isVegetariano = menuInputHandler.leggiBooleano("L'antipasto è per vegetariani? (true / false): ");
                            menu.modificaPortata(portataDaModificare, new Antipasti(nuovoNomePortata, nuovaDescrizionePortata, nuovoPrezzoPortata, nuoviIngredientiPortata, isVegetariano));
                            menu.stampaMenuPerTipo("antipasto");
                        }
                        case "primo_piatto" -> {
                            boolean contieneGlutine = menuInputHandler.leggiBooleano("Il piatto contiene glutine? (true / false): ");
                            menu.modificaPortata(portataDaModificare, new PrimiPiatti(nuovoNomePortata, nuovaDescrizionePortata, nuovoPrezzoPortata, nuoviIngredientiPortata, contieneGlutine));
                            menu.stampaMenuPerTipo("primo_piatto");
                        }
                        case "secondo_piatto" -> {
                            boolean tipoCottura = menuInputHandler.leggiBooleano("Il piatto è ben cotto o al sangue? (true = ben cotto / false = al sangue): ");
                            menu.modificaPortata(portataDaModificare, new SecondiPiatti(nuovoNomePortata, nuovaDescrizionePortata, nuovoPrezzoPortata, nuoviIngredientiPortata, tipoCottura));
                            menu.stampaMenuPerTipo("secondo_piatto");
                        }
                        case "dessert" -> {
                            boolean contieneLattosio = menuInputHandler.leggiBooleano("Il dessert contiene lattosio? (true / false): ");
                            menu.modificaPortata(portataDaModificare, new Dessert(nuovoNomePortata, nuovaDescrizionePortata, nuovoPrezzoPortata, nuoviIngredientiPortata, contieneLattosio));
                            menu.stampaMenuPerTipo("dessert");
                        }
                        case "bevanda" -> {
                            boolean caldoFreddo = menuInputHandler.leggiBooleano("La bevanda è calda o fredda? (true = fredda / false = calda): ");
                            menu.modificaPortata(portataDaModificare, new Bevande(nuovoNomePortata, nuovaDescrizionePortata, nuovoPrezzoPortata, caldoFreddo));
                            menu.stampaMenuPerTipo("bevanda");
                        }
                    }
                    break;

                // Salva il menu:
                case 5:
                    menu.scriviMenuJson();
                    break;

                // Esci:
                case 0:
                    System.out.println("\u001B[36m" + "Arrivederci!" + "\u001B[0m");
                    System.exit(0);
                    break;

                // Default:
                default:
                    System.out.println("\u001B[36m" + "Scelta non valida. Riprova." + "\u001B[0m");
                    break;
            }
        }
    }
}

