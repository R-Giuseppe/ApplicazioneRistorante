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

        "\n" +
        "-Pappardelle\n"+
        "Pasta all'uovo con sugo al Cinghiale\n"+"\n"+
        "-Lasagna\n" +
        "Pasta all'uovo con carne macinata, uovo e mozzarella\n"+"\n"+
        "-Gnocchi\n" +
        "Pasta all'uovo con sugo al Ragu'\n"+"\n"+
        "-Paccheri\n"+
        "Pasta secca con Tartufo e Funghi Porcini\n"+"\n"+
        "-Spaghetti\n"+
        "Pasta secca con condimento alla Carbonara\n");
   
         System.out.println("\033[35m "+
                "### Secondi Piatti\n" +
                "\n" +
                "- Pollo alla cacciatora\n" +
                "Pollo cotto in un sugo di pomodoro, cipolla, aglio, olive nere, capperi, vino rosso, rosmarino. \n" + "\n"+
                "- Arrosto di vitello\n" +
                "Vitello cotto con rosmarino, salvia, vino bianco e brodo.\n" + "\n"+
                "- Spezzatino di manzo\n" +
                "Manzo cotto in un sugo di pomodoro, cipolla, vino rosso, brodo, rosmarino e alloro.\n" + "\n"+
                "- Scaloppine al limone\n" +
                "Vitello in padella con burro, succo di limone, vino bianco e prezzemolo.\n" + "\n"+
                "- Bistecca alla fiorentina\n" +
                "Bistecca di manzo cotta sulla griglia, servita con olio d'oliva e pepe nero.\n");
      
          System.out.println("\033[31mDessert\n"+ "\n" +
                "- Tiramisù classico\n"+
                "Mascarpone, uova, zucchero, savoiardi, caffè\n"+ "\n"+
                "- Millefoglie alle fragole\n"+
                "Pasta Sfoglia, Zucchero, Fragole, Panna fresca liquida, Zeccheri a velo, Estratto di vaniglia, zucchero a velo\n"+ "\n"+
                "- Babà al rum\n"+
                "Farina Manitoba, Burro, Zucchero, Uova, Lievito di birra fresco, sale fino\n"+ "\n"+
                "- Strudel di mele\n"+
                "Mele Golden, Zucchero, Pangrattato, Burro, Uvetta, Pinoli tostati, Cannella in polvere, Rum, Scorza di limone\n"+ "\n" +
                "- Cannoli siciliani\n"+
                "Ricotta di pecora,  Zucchero, Gocce di cioccolato fondente");
         

          System.out.println("\u001B[34m " +
                "\n" +
                "### Bevande alcoliche:\n" +
                "- Vino rosso \n" +
                "- Vino bianco\n" +
                "- Vino rosato\n" +
                "- Prosecco\n" +
                "- Birra\n" +
                "\n" +
                "### Bevande analcoliche:\n" +
                "- Acqua naturale\n" +
                "- Acqua frizzante\n" +
                "- Coca-Cola\n" +
                "- Fanta\n" +
                "- Sprite\n" +
                "\n" +
                "### Caffè e amari:\n" +
                "- Espresso\n" +
                "- Macchiato\n" +
                "- Ginseng\n" +
                "- Amaro del capo\n" +
                "- Jefferson\n" +
                "- Numero uno");

    }
}