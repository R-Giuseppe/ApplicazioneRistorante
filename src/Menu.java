import java.util.ArrayList;

public class Menu {
    private ArrayList<Portate> portate;

    public Menu() {
        this.portate = new ArrayList<>();
    }

    public void aggiungiPortate(Portate portata) {
        portate.add(portata);
    }

    public void rimuoviPortate(Portate portata) {
        portate.remove(portata);
    }

    public void modificaPortata(Portate vecchiaPortata, Portate nuovaPortata) {
        int index = portate.indexOf(vecchiaPortata);
        if (index != -1) {
            portate.set(index, nuovaPortata);
        }
    }

    public void stampaMenu() {

        // Stampa le portate divise per categoria:

        System.out.println("Menu del Ristorante:\n");

        // Stampa degli antipasti:
        System.out.println("Antipasti:\n");
        for (Object piatto : portate) {
            if (piatto instanceof Antipasti) {
                System.out.println(((Antipasti) piatto));
            }
        }

        // Stampa dei primi piatti:
        System.out.println("Primi Piatti:\n");
        for (Object piatto : portate) {
            if (piatto instanceof PrimiPiatti) {
                System.out.println(((PrimiPiatti) piatto));
            }
        }

        // Stampa dei secondi piatti:
        System.out.println("Secondi Piatti:\n");
        for (Object piatto : portate) {
            if (piatto instanceof SecondiPiatti) {
                System.out.println(((SecondiPiatti) piatto));
            }
        }

        // Stampa dei dessert:
        System.out.println("Dessert:\n");
        for (Object piatto : portate) {
            if (piatto instanceof Dessert) {
                System.out.println(((Dessert) piatto));
            }
        }

        // Stampa delle bevande:
        System.out.println("Bevande:\n");
        for (Object piatto : portate) {
            if (piatto instanceof Bevande) {
                System.out.println(((Bevande) piatto));
            }
        }
    }
}
