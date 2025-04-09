import java.util.Arrays;

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

    public String getTipologia() {
        return tipologia;
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
            temp = "fredda";
        } else {
            temp = "calda";
        }

        return "Tipologia: " + tipologia + "\nNome: " + nome + "\nDescrizione: " + descrizione +
                "\nPrezzo: " + prezzo + " euro" + "\nTemperatura: " + temp + "\n";
    }
}