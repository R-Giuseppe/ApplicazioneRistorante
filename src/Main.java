public class Main {

    public static void main(String[] args) {
        String[] ingredientiSecondiPiatti1 = {"pollo", "pomodoro", "cipolla", "aglio", "olive nere", "capperi", "vino rosso", "rosmarino"};
        String[] ingredientiSecondiPiatti2 = {"vitello", "salvia", "vino bianco", "brodo", "rosmarino"};
        String[] ingredientiSecondiPiatti3 = {"manzo", "pomodoro", "cipolla", "vino rosso", "brodo", "rosmarino", "alloro"};
        String[] ingredientiSecondiPiatti4 = {"vitello", "burro", "succo di limone", "vino bianco", "prezzemolo"};
        String[] ingredientiSecondiPiatti5 = {"manzo", "olio d'oliva", "pepe nero"};


        SecondiPiatti[] secondiPiatti =  {
                new SecondiPiatti("Pollo alla cacciatora", "Pollo cotto in un sugo di pomodoro, cipolla, aglio, olive nere, capperi, vino rosso, rosmarino.", 15.00, ingredientiSecondiPiatti1, true),
                new SecondiPiatti("Arrosto di vitello", "Vitello cotto con rosmarino, salvia, vino bianco e brodo.", 12.00, ingredientiSecondiPiatti2, true),
                new SecondiPiatti("Spezzatino di manzo", "Manzo cotto in un sugo di pomodoro, cipolla, vino rosso, brodo, rosmarino e alloro.", 18.00, ingredientiSecondiPiatti3, true),
                new SecondiPiatti("Scaloppine al limone", "Vitello in padella con burro, succo di limone, vino bianco e prezzemolo.", 14.00, ingredientiSecondiPiatti4, false),
                new SecondiPiatti("Bistecca alla fiorentina", "Bistecca di manzo cotta sulla griglia, servita con olio d'oliva e pepe nero.", 22.00, ingredientiSecondiPiatti5, false)
        };

        System.out.println("SECONDI PIATTI:");
        System.out.println();

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