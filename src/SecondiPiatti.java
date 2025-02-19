public class SecondiPiatti extends Portate {

    // Attributi
    private boolean tipoCottura; // true = ben cotto; false = al sangue

    // Costruttore
    public SecondiPiatti(String nome, String descrizione, double prezzo, String[] ingredienti, boolean tipoCottura) {
        super(nome, descrizione, prezzo, ingredienti);
        this.tipoCottura = tipoCottura;
    }


    // Setter and Getter
    public boolean isTipoCottura() {
        return tipoCottura;
    }

    public void setTipoCottura(boolean tipoCottura) {
        this.tipoCottura = tipoCottura;
    }


    //Funzione che restituisce una stringa contenente l'elenco degli ingredienti dell'istanza
    public String elencoIngredienti() {
        String list = "";
        for (int i = 0; i < ingredienti.length - 1; i++) {
            list += ingredienti[i] + ", ";
        }
        list += ingredienti[ingredienti.length - 1];
        return list;
    }

    @Override
    public String toString() {
        // Variabile per il tipo di cottura
        String cottura;

        if (tipoCottura) {
            cottura = "Ben cotto.";
        } else {
            cottura = "Al sangue";
        }

        return nome + ": " + descrizione +
                "\nIngredienti: " + elencoIngredienti() +
                "\nPrezzo: " + prezzo + " euro" +
                "\nTipo di cottura: " + cottura;
    }
}
