import java.util.Scanner;

public class InputHandler implements IInputHandler {

    private final Scanner scanner = new Scanner(System.in);

    public InputHandler() {}

    @Override
    public int leggiIntero(String messaggio) {
        System.out.print(messaggio);
        while (!scanner.hasNextInt()) {
            System.out.println("Input non valido. Inserisci un numero intero.");
            System.out.print(messaggio);
            scanner.next();
        }
        return scanner.nextInt();
    }

    @Override
    public double leggiDouble(String messaggio) {
        System.out.print(messaggio);
        while (!scanner.hasNextDouble()) {
            System.out.println("Input non valido. Inserisci un numero.");
            System.out.print(messaggio);
            scanner.next();
        }
        return scanner.nextDouble();
    }

    @Override
    public String leggiStringa(String messaggio) {
        System.out.print(messaggio);
        return scanner.nextLine();
    }

    @Override
    public String[] leggiArrayStringa(String messaggio) {
        System.out.print(messaggio);
        scannerNextLine();
        return scanner.nextLine().split(", ");
    }

    @Override
    public boolean leggiBooleano(String messaggio) {
        System.out.print(messaggio);
        while (!scanner.hasNextBoolean()) {
            System.out.println("Input non valido. Inserisci 'true' o 'false'.");
            System.out.print(messaggio);
            scanner.next();
        }
        return scanner.nextBoolean();
    }

    @Override
    public void scannerNextLine() {
        scanner.nextLine();
    }
}




