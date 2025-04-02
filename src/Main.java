public class Main {

    public static void main(String[] args) {
        // Creo una nuova istanza della classe Menu:
        Menu menu = new Menu();

        // Creo una nuova istanza della classe MenuInputHandler:
        InputHandler menuInputHandler = new InputHandler();

        // Creo una nuova istanza della classe MenuConsoleHandler:
        MenuConsoleHandler menuConsoleHandler = new MenuConsoleHandler(menu, menuInputHandler);

        // Richiamo la funzione menuInterattivo() della classe MenuConsoleHandler:
        menuConsoleHandler.menuInterattivo();
    }
}

