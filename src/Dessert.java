public class Dessert extends Portate {

    // Attributo specifico:
    private boolean lattosio; // true = con lattosio; false = senza lattosio

    // Costruttore
    public Dessert(String nome, String descrizione, double prezzo, String[] ingredienti, boolean lattosio) {
        super(nome, descrizione, prezzo, ingredienti);
        this.lattosio = lattosio;
        this.tipologia = "dessert";
    }

    // Getter e Setter
    public boolean getLattosio() {
        return lattosio;
    }

    public void setLattosio(boolean lattosio) {
        this.lattosio = lattosio;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    // Funzione toString() specifica per la classe:
    @Override
    public String toString() {
        // Variabile per il lattosio
        String conLattosio;

        if (lattosio) {
            conLattosio = "\u001B[33m" + "con lattosio" + "\u001B[0m";
        } else {
            conLattosio = "\u001B[33m" + "senza lattosio" + "\u001B[0m";
        }

        return super.toString() +  "\u001B[33m" + "Lattosio: " + "\u001B[0m" + conLattosio + "\n";
    }
}