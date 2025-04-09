public class Bevande extends Portate {

    // Attributo specifico:
    private boolean temperatura; // true = freddo; false = caldo

    // Costruttore
    public Bevande(String nome, String descrizione, double prezzo,  boolean temperatura) {
        super(nome, descrizione, prezzo, null);
        this.temperatura = temperatura;
        this.tipologia = "bevanda";
    }

    // Getter e Setter
    public boolean getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(boolean temperatura) {
        this.temperatura = temperatura;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    // Funzione toString() specifica per la classe:
    @Override
    public String toString() {
        // Variabile della temperatura
        String temp;

        if (temperatura) {
            temp = "\u001B[33m" + "fredda" + "\u001B[0m";
        } else {
            temp = "\u001B[33m" + "calda" + "\u001B[0m";
        }

        return "\u001B[33m" + "Tipologia: " + tipologia + "\nNome: " + nome + "\nDescrizione: " + descrizione +
                "\nPrezzo: " + prezzo + " euro" + "\nTemperatura: " + temp + "\n" + "\u001B[0m";
    }
}