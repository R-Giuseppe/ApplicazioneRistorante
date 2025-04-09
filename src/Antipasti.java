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

    public String getTipologia() {
        return tipologia;
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
            eVegetariano = "sì";
        } else {
            eVegetariano = "no";
        }

        return super.toString() + "Vegetariano: " + eVegetariano + "\n";
    }
}