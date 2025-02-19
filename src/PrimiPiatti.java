public class PrimiPiatti {
    private String Nome;
    private String Descrizione;
    private double Prezzo;
    boolean Glutine;

    public PrimiPiatti(String nome, String descrizione, double prezzo, boolean glutine){

        this.Nome = Nome;
        this.Descrizione = descrizione;
        this.Prezzo = prezzo;
        this.Glutine = glutine;

    }
    // Setter and Getter
    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.Descrizione = descrizione;
    }

    public double getPrezzo() {
        return Prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.Prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Il Piatto " +
                " " + Nome + '\'' +
                "con" + Descrizione + '\'' +
                ", al costo di € " + Prezzo +
                "Presenza Glutine -  " + Glutine ;
    }
}
