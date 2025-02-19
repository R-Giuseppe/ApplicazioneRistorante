public class Main {

    public static void main(String[] args) {
    
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
    }
}