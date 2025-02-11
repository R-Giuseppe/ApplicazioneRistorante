class Antipasti {
    // Attributi
    private String nome, descrizione;
    private double prezzo;
    private String[] ingredienti;
    private boolean vegetariano;

    public Antipasti() {}

    // Costruttore
    public Antipasti(String nome, String descrizione, double prezzo, String[] ingredienti, boolean vegetariano) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.ingredienti = ingredienti;
        this.vegetariano = vegetariano;
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

    public boolean getVegetariano() {
        return vegetariano;
    }

    public void setVegetariano(boolean vegetariano) {
        this.vegetariano = vegetariano;
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

    // Metodo toString
    @Override
    public String toString() {
        return nome + ": " + descrizione + "\n" +
                "\nIngredienti: " + elencoIngredienti() + ".\n" +
                "\nPrezzo: " + prezzo + "€";
    }
}