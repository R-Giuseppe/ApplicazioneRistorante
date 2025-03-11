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

    public String getTipologia() {
        return tipologia;
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
            cottura = "ben cotto";
        } else {
            cottura = "al sangue";
        }

        return super.toString() + "Cottura: " + cottura + "\n";
    }
}