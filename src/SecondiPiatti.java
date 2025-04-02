public class SecondiPiatti extends Portate {

    // Attributo specifico:
    private boolean tipoCottura; // true = ben cotto; false = al sangue

    // Costruttore
    public SecondiPiatti(String nome, String descrizione, double prezzo, String[] ingredienti, boolean tipoCottura) {
        super(nome, descrizione, prezzo, ingredienti);
        this.tipoCottura = tipoCottura;
        this.tipologia = "secondo_piatto";
    }

    // Getter e Setter
    public boolean getTipoCottura() {
        return tipoCottura;
    }

    public void setTipoCottura(boolean tipoCottura) {
        this.tipoCottura = tipoCottura;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    // Funzione toString() specifica per la classe:
    @Override
    public String toString() {
        // Variabile per il tipo di cottura
        String cottura;

        if (tipoCottura) {
            cottura = "\u001B[33m" + "ben cotto" + "\u001B[0m";
        } else {
            cottura = "\u001B[33m" + "al sangue" + "\u001B[0m";
        }

        return super.toString() +  "\u001B[33m" + "Cottura: " + "\u001B[0m" + cottura + "\n";

    }
}