public class Bevande extends Portate {
    // Attributi

    private boolean temperatura; // true = freddo; false = caldo

    // Costruttore
    public Bevande(String nome, String descrizione, double prezzo, boolean temperatura) {
        super(nome, descrizione, prezzo, new String[0]);
        this.temperatura = temperatura;
    }


    // Setter and Getter
    public boolean isTemperatura() {
        return temperatura;
    }

    public void setTemperatura(boolean temperatura) {
        this.temperatura = temperatura;
    }


    @Override
    public String toString() {
        // Variabile della temperatura
        String temp;

        if (temperatura) {
            temp = "Freddo";
        } else {
            temp = "Caldo";
        }

        return nome + ": " + descrizione +
                "\nPrezzo: " + prezzo + " euro" +
                "\nTemperatura: " + temp + "\n";
    }
}
