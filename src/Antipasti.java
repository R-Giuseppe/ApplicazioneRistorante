public class Antipasti extends Portate {

    // Attributo specifico:
    private boolean vegetariano; // true = vegetariano; false = non vegetariano

    // Costruttore
    public Antipasti(String nome, String descrizione, double prezzo, String[] ingredienti, boolean vegetariano) {
        super(nome, descrizione, prezzo, ingredienti);
        this.vegetariano = vegetariano;
        this.tipologia = "antipasto";
    }

    // Getter e Setter
    public boolean getVegetariano() {
        return vegetariano;
    }

    public void setVegetariano(boolean vegetariano) {
        this.vegetariano = vegetariano;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    // Funzione toString() specifica per la classe:
    @Override
    public String toString() {
        // Variabile per il tipo vegetariano
        String eVegetariano;

        if (vegetariano) {
            eVegetariano = "\u001B[33m" + "sì" + "\u001B[0m";
        } else {
            eVegetariano = "\u001B[33m" + "no" + "\u001B[0m";
        }

        return super.toString() +  "\u001B[33m" + "Vegetariano: " + "\u001B[0m" + eVegetariano + "\n";
    }
}