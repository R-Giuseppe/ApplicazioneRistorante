public interface IInputHandler {
    public int leggiIntero(String messaggio);
    public double leggiDouble(String messaggio);
    public String leggiStringa(String messaggio);
    public String[] leggiArrayStringa(String messaggio);
    public boolean leggiBooleano(String messaggio);
    public void scannerNextLine();
}