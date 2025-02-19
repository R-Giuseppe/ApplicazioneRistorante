public class Main {
    public static void main(String[] args) { 

        System.out.println("APPLICAZIONE RISTORANTE\n");
     
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

        System.out.println("\u001B[33m"+ "### Antipasti\n");

        for (int i = 0; i < elencoAntipasti.length; i++) {
            System.out.println(elencoAntipasti[i]);
        }
      
        System.out.println("\u001B[34m " + "### Primi Piatti:\n "+

        SecondiPiatti[] secondiPiatti =  {
                new SecondiPiatti("Pollo alla cacciatora", "Pollo cotto in un sugo di pomodoro, cipolla, aglio, olive nere, capperi, vino rosso, rosmarino.", 15.00, new String[]{"pollo", "pomodoro", "cipolla", "aglio", "olive nere", "capperi", "vino rosso", "rosmarino"};, true),
                new SecondiPiatti("Arrosto di vitello", "Vitello cotto con rosmarino, salvia, vino bianco e brodo.", 12.00, new String[]{"vitello", "salvia", "vino bianco", "brodo", "rosmarino"};, true),
                new SecondiPiatti("Spezzatino di manzo", "Manzo cotto in un sugo di pomodoro, cipolla, vino rosso, brodo, rosmarino e alloro.", 18.00, new String[]{"manzo", "pomodoro", "cipolla", "vino rosso", "brodo", "rosmarino", "alloro"};, true),
                new SecondiPiatti("Scaloppine al limone", "Vitello in padella con burro, succo di limone, vino bianco e prezzemolo.", 14.00, new String[]{"vitello", "burro", "succo di limone", "vino bianco", "prezzemolo"};, false),
                new SecondiPiatti("Bistecca alla fiorentina", "Bistecca di manzo cotta sulla griglia, servita con olio d'oliva e pepe nero.", 22.00, new String[]{"manzo", "olio d'oliva", "pepe nero"};, false)
        };

        System.out.println("SECONDI PIATTI:\n");

        for (int i = 0; i < secondiPiatti.length; i++) {
            System.out.println(secondiPiatti[i] + "\n");
        }


    }
}


 /*System.out.println("\033[35m " +
                "### Secondi Piatti\n" +
                "\n" +
                "- Pollo alla cacciatora\n" +
                "Pollo cotto in un sugo di pomodoro, cipolla, aglio, olive nere, capperi, vino rosso, rosmarino. \n" + "\n" +
                "- Arrosto di vitello\n" +
                "Vitello cotto con rosmarino, salvia, vino bianco e brodo.\n" + "\n" +
                "- Spezzatino di manzo\n" +
                "Manzo cotto in un sugo di pomodoro, cipolla, vino rosso, brodo, rosmarino e alloro.\n" + "\n" +
                "- Scaloppine al limone\n" +
                "Vitello in padella con burro, succo di limone, vino bianco e prezzemolo.\n" + "\n" +
                "- Bistecca alla fiorentina\n" +
                "Bistecca di manzo cotta sulla griglia, servita con olio d'oliva e pepe nero.\n"); */