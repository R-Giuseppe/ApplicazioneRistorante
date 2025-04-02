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

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    // Funzione toString() specifica per la classe:
    @Override
    public String toString() {
        // Variabile per il glutine
        String conGlutine;

        if (glutine) {
            conGlutine = "\u001B[33m" + "con glutine" + "\u001B[0m";
        } else {
            conGlutine = "\u001B[33m" + "senza glutine" + "\u001B[0m";
        }

        return super.toString() +  "\u001B[33m" + "Glutine: " + "\u001B[0m" + conGlutine + "\n";
    }
}