public abstract class Portate {
    protected String nome, descrizione;
    protected double prezzo;
    protected String[] ingredienti;
    protected String tipologia;

    public Portate(String nome, String descrizione, double prezzo, String[] ingredienti) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.ingredienti = ingredienti;
        //this.tipo = this.getClass().getSimpleName();
    }

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

    public String elencoIngredienti() {
        String list = "";
        for (int i = 0; i < ingredienti.length - 1; i++) {
            list += ingredienti[i] + ", ";
        }
        list += ingredienti[ingredienti.length - 1];
        return list;
    }

    public String toString() {
        return nome + ": " + descrizione + "\n" +
                "\nIngredienti: " + ingredienti + ".\n" +
                "\nPrezzo: " + prezzo + "€";
    }
}
