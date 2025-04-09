import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner = new Scanner(System.in);

    public InputHandler() {}

    public int leggiIntero(String messaggio) {
        System.out.print(messaggio);
        while (!scanner.hasNextInt()) {
            System.out.println("Input non valido. Inserisci un numero intero.");
            System.out.print(messaggio);
            scanner.next();
        }
        return scanner.nextInt();
    }

    public double leggiDouble(String messaggio) {
        System.out.print(messaggio);
        while (!scanner.hasNextDouble()) {
            System.out.println("Input non valido. Inserisci un numero.");
            System.out.print(messaggio);
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public String leggiStringa(String messaggio) {
        System.out.print(messaggio);
        return scanner.nextLine();
    }

    public String[] leggiArrayStringa(String messaggio) {
        System.out.print(messaggio);
        scannerNextLine();
        return scanner.nextLine().split(", ");
    }

    public boolean leggiBooleano(String messaggio) {
        System.out.print(messaggio);
        while (!scanner.hasNextBoolean()) {
            System.out.println("Input non valido. Inserisci 'true' o 'false'.");
            System.out.print(messaggio);
            scanner.next();
        }
        return scanner.nextBoolean();
    }

    public void scannerNextLine() {
        scanner.nextLine();
    }
}




