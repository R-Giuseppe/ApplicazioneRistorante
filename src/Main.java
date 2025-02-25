public class Main {

    public static void main(String[] args) {

        //System.out.println("APPLICAZIONE RISTORANTE\n");
     
        Antipasti[] elencoAntipasti = {
            // Crostini:
            new Antipasti("Crostini", "Crostini con senape, prosciutto cotto e formaggio", 3, new String[]{"prosciutto cotto", "parmigiano reggiano dop", "fetta di pane", "uova", "senape rustica", "birra trappista triple ale", "amido di mais", "olio extravergine di oliva"}, false),
            // Quesadilla:
            new Antipasti("Quesadilla", "Quesadilla all'italiana con Asiago", 5, new String[]{"asiago dop", "farina messicana di mais bianco precotto", "avocado", "tabasco", "olio extravergine di oliva", "sale"}, true),
            // Omeletta:
            new Antipasti("Omeletta", "Omeletta di patate, Trentino-Alto Adige", 8, new String[]{"patate", "uova", "farina", "olio di arachide", "sale"}, true),
            // Canederli:
            new Antipasti("Canederli", "Mini canederli con sugo alla puttanesca", 10, new String[]{"pane multicereali", "latte", "uova", "prezzemolo", "maggiorana", "erba cipollina", "olio di arachide", "sale", "pepe"}, false),
            // Montanarine:
            new Antipasti("Montanarine", "Montanarine con burrata e salmone affumicato", 15, new String[]{"Farina 0", "latte intero", "olio extravergine d'oliva", "lievito di birra", "sale fino", "burrata", "salmone affumicato", "prezzemolo", "pepe rosa in grani"}, false),
            // Gamberi:
            new Antipasti("Gamberi", "Gamberi al miele e pan di spezie abbrustolito", 20, new String[]{"code di gambero", "pan di spezie", "scalogno", "lime", "zenzero", "peperoncino", "semi di sesamo bianco", "vino bianco secco", "miele di acacia", "olio extravergine di oliva", "misticanza", "sale"}, false)
        };

        //System.out.println("\u001B[33m"+ "### Antipasti\n");

        for (int i = 0; i < elencoAntipasti.length; i++) {
            //System.out.println(elencoAntipasti[i]);
        }
      
        //System.out.println("\u001B[34m " + "### Primi Piatti:\n ");

        SecondiPiatti[] secondiPiatti =  {
                new SecondiPiatti("Pollo alla cacciatora", "Pollo cotto in un sugo di pomodoro, cipolla, aglio, olive nere, capperi, vino rosso, rosmarino.", 15.00, new String[]{"pollo", "pomodoro", "cipolla", "aglio", "olive nere", "capperi", "vino rosso", "rosmarino"}, true),
                new SecondiPiatti("Arrosto di vitello", "Vitello cotto con rosmarino, salvia, vino bianco e brodo.", 12.00, new String[]{"vitello", "salvia", "vino bianco", "brodo", "rosmarino"}, true),
                new SecondiPiatti("Spezzatino di manzo", "Manzo cotto in un sugo di pomodoro, cipolla, vino rosso, brodo, rosmarino e alloro.", 18.00, new String[]{"manzo", "pomodoro", "cipolla", "vino rosso", "brodo", "rosmarino", "alloro"}, true),
                new SecondiPiatti("Scaloppine al limone", "Vitello in padella con burro, succo di limone, vino bianco e prezzemolo.", 14.00, new String[]{"vitello", "burro", "succo di limone", "vino bianco", "prezzemolo"}, false),
                new SecondiPiatti("Bistecca alla fiorentina", "Bistecca di manzo cotta sulla griglia, servita con olio d'oliva e pepe nero.", 22.00, new String[]{"manzo", "olio d'oliva", "pepe nero"}, false)
        };

        //System.out.println("SECONDI PIATTI:\n");

        for (int i = 0; i < secondiPiatti.length; i++) {
            //System.out.println(secondiPiatti[i] + "\n");
        }

        
        Bevande[] bevandeAlcoliche = {
                new Bevande("Vino rosso", "Vino rosso", 20.0, false),
                new Bevande("Vino bianco", "Vino bianco", 30.0, true),
                new Bevande("Vino rosato", "Vino rosato", 25.0, true),
                new Bevande("Prosecco", "Prosecco di uva", 15.0, true),
                new Bevande("Birra", "Birra", 6.0, true)
        };
        //System.out.println("BEVANDE ALCOLICHE:");
        for (Bevande bevanda : bevandeAlcoliche) {
            //System.out.println(bevanda);
        }

        Bevande[] bevandeAnalcoliche = {
                new Bevande("Acqua naturale", "Acqua naturale", 3.0, true),
                new Bevande("Acqua frizzante", "Acqua frizzante", 3.5, true),
                new Bevande("Coca-Cola", "Coca-Cola", 4.0, true),
                new Bevande("Fanta", "Fanta", 4.0, true),
                new Bevande("Sprite", "Sprite", 4.0, true)
        };
        //System.out.println("BEVANDE ANALCOLICHE:");
        for (Bevande bevanda : bevandeAnalcoliche) {
            //System.out.println(bevanda);
        }
        Bevande[] caffeEAmari = {
                new Bevande("Espresso", "Espresso", 0.5, false),
                new Bevande("Macchiato", "Macchiato", 1.0, false),
                new Bevande("Ginseng", "Ginseng", 1.5, false),
                new Bevande("Amaro del capo", "Amaro calabrese", 6.0, true),
                new Bevande("Jefferson", "Amaro calabrese", 6.0, true)
        };
        //System.out.println("CAFFE' E AMARI:");
        for (Bevande bevanda : caffeEAmari) {
            //System.out.println(bevanda);
        }

        Menu menu = new Menu();
        menu.aggiungiPortate(elencoAntipasti[0]);
        menu.aggiungiPortate(elencoAntipasti[1]);
        menu.aggiungiPortate(elencoAntipasti[2]);
        menu.aggiungiPortate(elencoAntipasti[3]);
        menu.aggiungiPortate(elencoAntipasti[4]);
        menu.aggiungiPortate(elencoAntipasti[5]);
        menu.aggiungiPortate(secondiPiatti[0]);
        menu.aggiungiPortate(secondiPiatti[1]);
        menu.aggiungiPortate(secondiPiatti[2]);
        menu.aggiungiPortate(secondiPiatti[3]);
        menu.aggiungiPortate(secondiPiatti[4]);
        menu.aggiungiPortate(bevandeAlcoliche[0]);
        menu.aggiungiPortate(bevandeAlcoliche[1]);
        menu.aggiungiPortate(bevandeAlcoliche[2]);
        menu.aggiungiPortate(bevandeAlcoliche[3]);
        menu.aggiungiPortate(bevandeAlcoliche[4]);
        menu.aggiungiPortate(bevandeAnalcoliche[0]);
        menu.aggiungiPortate(bevandeAnalcoliche[1]);
        menu.aggiungiPortate(bevandeAnalcoliche[2]);
        menu.aggiungiPortate(bevandeAnalcoliche[3]);
        menu.aggiungiPortate(bevandeAnalcoliche[4]);
        menu.aggiungiPortate(caffeEAmari[0]);
        menu.aggiungiPortate(caffeEAmari[1]);
        menu.aggiungiPortate(caffeEAmari[2]);
        menu.aggiungiPortate(caffeEAmari[3]);
        menu.aggiungiPortate(caffeEAmari[4]);

        menu.stampaMenu();
    }
}

