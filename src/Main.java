public class Main {
    public static void main(String[] args) {
        Bevande[] bevandeAlcoliche = {
                new Bevande("Vino rosso", "Vino rosso", 20.0, false),
                new Bevande("Vino bianco", "Vino bianco", 30.0, true),
                new Bevande("Vino rosato", "Vino rosato", 25.0, true),
                new Bevande("Prosecco", "Prosecco di uva", 15.0, true),
                new Bevande("Birra", "Birra", 6.0, true)
        };
        System.out.println("BEVANDE ALCOLICHE:");
        for (Bevande bevanda : bevandeAlcoliche) {
            System.out.println(bevanda);
        }

        Bevande[] bevandeAnalcoliche = {
                new Bevande("Acqua naturale", "Acqua naturale", 3.0, true),
                new Bevande("Acqua frizzante", "Acqua frizzante", 3.5, true),
                new Bevande("Coca-Cola", "Coca-Cola", 4.0, true),
                new Bevande("Fanta", "Fanta", 4.0, true),
                new Bevande("Sprite", "Sprite", 4.0, true)
        };
        System.out.println("BEVANDE ANALCOLICHE:");
        for (Bevande bevanda : bevandeAnalcoliche) {
            System.out.println(bevanda);
        }
        Bevande[] caffeEAmari = {
                new Bevande("Espresso", "Espresso", 0.5, false),
                new Bevande("Macchiato", "Macchiato", 1.0, false),
                new Bevande("Ginseng", "Ginseng", 1.5, false),
                new Bevande("Amaro del capo", "Amaro calabrese", 6.0, true),
                new Bevande("Jefferson", "Amaro calabrese", 6.0, true)
        };
        System.out.println("CAFFE' E AMARI:");
        for (Bevande bevanda : caffeEAmari) {
            System.out.println(bevanda);
        }
    }
}