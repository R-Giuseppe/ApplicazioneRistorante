public class SecondiPiatti {

    // Attributi
    private String nome, descrizione;
    private double prezzo;
    private String[] ingredienti;
    private boolean tipoCottura; // true = ben cotto; false = al sangue

    // Costruttore
    public SecondiPiatti(String nome, String descrizione, double prezzo, String[] ingredienti, boolean tipoCottura) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.ingredienti = ingredienti;
        this.tipoCottura = tipoCottura;
    }


    // Setter and Getter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String[] getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(String[] ingredienti) {
        this.ingredienti = ingredienti;
    }

    public boolean isTipoCottura() {
        return tipoCottura;
    }
    public void setTipoCottura(boolean tipoCottura) {
        this.tipoCottura = tipoCottura;
    }


    //Funzione che restituisce una stringa contenente l'elenco degli ingredienti dell'istanza
    private String elencoIngredienti() {
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

        return nome + ": " + descrizione + "\n" +
                "\nIngredienti: " + elencoIngredienti() + ".\n" +
                "\nPrezzo: " + prezzo + "€\n" +
                "\nTipo di cottura: " + cottura;
    }
}
