public interface IInputHandler {
    int leggiIntero(String messaggio);
    double leggiDouble(String messaggio);
    String leggiStringa(String messaggio);
    String[] leggiArrayStringa(String messaggio);
    boolean leggiBooleano(String messaggio);
    void scannerNextLine();
}