public class Antipasti extends Portate {

    // Attributi specifici:
    private boolean vegetariano;

    // Costruttore semplice:
    // public Antipasti() {}

    // Costruttore
    public Antipasti(String nome, String descrizione, double prezzo, String[] ingredienti, boolean vegetariano) {
        super(nome, descrizione, prezzo, ingredienti);
        this.vegetariano = vegetariano;
    }

    // Metodo getter specifico:
    public boolean getVegetariano() {
        return vegetariano;
    }

    // Metodo setter specifico:
    public void setVegetariano(boolean vegetariano) {
        this.vegetariano = vegetariano;
    }

    // Funzione toString() specifica per la classe:
    @Override
    public String toString() {
        return nome + ": " + descrizione + "\n" +
                "\nIngredienti: " + elencoIngredienti() + ".\n" +
                "\nPrezzo: " + prezzo + "€" + ".\n" + "Vegetariano: " + vegetariano;
    }
}