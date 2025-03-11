public class PrimiPiatti extends Portate {

    // Attributo specifico:
    private boolean glutine; // true = con glutine; false = senza glutine

    // Costruttore
    public PrimiPiatti(String nome, String descrizione, double prezzo, String[] ingredienti, boolean glutine){
        super(nome, descrizione, prezzo, ingredienti);
        this.glutine = glutine;
        this.tipologia = "primo_piatto";
    }

    // Getter e Setter
    public boolean getGlutine() {
        return glutine;
    }

    public void setGlutine(boolean glutine) {
        this.glutine = glutine;
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
        // Variabile per il glutine
        String conGlutine;

        if (glutine) {
            conGlutine = "con glutine";
        } else {
            conGlutine = "senza glutine";
        }

        return super.toString() + "Glutine: " + conGlutine + "\n";
    }
}