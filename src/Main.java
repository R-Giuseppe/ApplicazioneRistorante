public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();

        System.out.println("MENU DEL RISTORANTE\n");

        menu.leggiJsonMenu("res/portate.json");
        menu.stampaMenu();
    }
}

