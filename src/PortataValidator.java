import java.util.Objects;

public class PortataValidator implements IValidator {

    public PortataValidator() {}

    // Metodo per la validazione del nome della portata
    @Override
    public boolean validateNome(Portate portata) {
        if (portata.getNome().length() > 50) {
            System.out.println("\u001B[38;5;208m" + "\n" + "Il nome della portata è troppo lungo." + "\u001B[0m");
            return false;
        }

        if (portata.getNome().length() == 1) {
            System.out.println("\u001B[38;5;208m" + "\n" + "Il nome della portata è troppo corto." + "\u001B[0m");
            return false;
        }

        if (portata.getNome().isEmpty()) {
            System.out.println("\u001B[38;5;208m" + "\n" + "Il nome della portata non è stato inserito." + "\u001B[0m");
            return false;
        }

        if (verificaSpaziVuoti(portata.getNome())) {
            System.out.println("\u001B[38;5;208m" + "\n" + "Il nome della portata contiene solo spazi vuoti." + "\u001B[0m");
            return false;
        }

        if (conteggioCifreNumeriche(portata.getNome())) {
            System.out.println("\u001B[38;5;208m" + "\n" + "Il nome della portata contiene troppi numeri." + "\u001B[0m");
            return false;
        }

        return true;
    }

    // Metodo per la validazione della descrizione della portata
    @Override
    public boolean validateDescrizione(Portate portata) {
        if (portata.getDescrizione().length() > 200) {
            System.out.println("\u001B[38;5;208m" + "\n" + "La descrizione della portata è troppo lunga." + "\u001B[0m");
            return false;
        }

        if (portata.getDescrizione().length() < 10) {
            System.out.println("\u001B[38;5;208m" + "\n" + "La descrizione della portata è troppo corta." + "\u001B[0m");
            return false;
        }

        if (portata.getDescrizione().isEmpty()) {
            System.out.println("\u001B[38;5;208m" + "\n" + "La descrizione della portata non è stata inserita." + "\u001B[0m");
            return false;
        }

        if (verificaSpaziVuoti(portata.getDescrizione())) {
            System.out.println("\u001B[38;5;208m" + "\n" + "La descrizione della portata contiene solo spazi vuoti." + "\u001B[0m");
            return false;
        }

        if (conteggioCifreNumeriche(portata.getDescrizione())) {
            System.out.println("\u001B[38;5;208m" + "\n" + "La descrizione della portata contiene troppi numeri." + "\u001B[0m");
            return false;
        }

        return true;
    }

    // Metodo per la validazione del prezzo della portata
    @Override
    public boolean validatePrezzo(Portate portata) {
        if (portata.getPrezzo() <= 0) {
            System.out.println("\u001B[38;5;208m" + "\n" + "Il prezzo inserito non è valido (prezzo negativo o nullo)." + "\u001B[0m");
            return false;
        }

        if (portata.getPrezzo() >= 5000) {
            System.out.println("\u001B[38;5;208m" + "\n" + "Il prezzo inserito non è valido (prezzo troppo alto)." + "\u001B[0m");
            return false;
        }

        if (Double.isNaN(portata.getPrezzo())) {
            System.out.println("\u001B[38;5;208m" + "\n" + "Il prezzo della portata non è stato inserito." + "\u001B[0m");
            return false;
        }

        return true;
    }

    // Metodo per la validazione degli ingredienti della portata
    @Override
    public boolean validateIngredienti(Portate portata) {
        if (Objects.equals(portata.getTipologia(), "bevanda")) {
            return true;
        }

        if (portata.getIngredienti() == null || portata.getIngredienti().length == 0) {
            System.out.println("\u001B[38;5;208m" + "\n" + "La portata deve contenere almeno un ingrediente." + "\u001B[0m");
            return false;
        }

        if (verificaSpaziVuoti(portata.getIngredienti())) {
            System.out.println("\u001B[38;5;208m" + "\n" + "La lista degli ingredienti contiene uno o più elementi vuoti." + "\u001B[0m");
            return false;
        }

        if (conteggioCifreNumeriche(portata.getIngredienti())) {
            System.out.println("\u001B[38;5;208m" + "\n" + "La lista degli ingredienti contiene uno o più elementi con più di due cifre numeriche." + "\u001B[0m");
            return false;
        }

        return true;
    }

    //=======================================================================================================

    // Metodo per la validazione della portata
    @Override
    public boolean validatePortata(Portate portata) {
        if (validateNome(portata) && validateDescrizione(portata) && validatePrezzo(portata) && validateIngredienti(portata)) {
            return true;
        }

        System.out.println("\u001B[38;5;208m" + "\n" + "ATTENZIONE: la portata non è stata aggiunta al menu a causa di errori di validazione." + "\u001B[0m");
        return false;
    }

    //=======================================================================================================

    // Metodo per il conteggio di caratteri numerici all'interno di una stringa di caratteri
    @Override
    public boolean conteggioCifreNumeriche(String stringa) {
        int conteggioCifreNumeriche = 0;
        int limiteCifreNumeriche = 2;

        for (int i = 0; i < stringa.length(); i++) {
            if (Character.isDigit(stringa.charAt(i))) {
                conteggioCifreNumeriche++;
            }
        }

        return conteggioCifreNumeriche > limiteCifreNumeriche;
    }

    // Metodo per il conteggio di caratteri numerici all'interno di un array di stringhe
    @Override
    public boolean conteggioCifreNumeriche(String[] stringhe) {
        for (String stringa : stringhe) {
            if (conteggioCifreNumeriche(stringa)) {
                return true;
            }
        }

        return false;
    }

    // Metodo che verifica se una stringa contiene solo spazi
    @Override
    public boolean verificaSpaziVuoti(String stringa) {
        return stringa.trim().isEmpty();
    }

    // Metodo che verifica se un array di stringhe contiene elementi vuoti con solo spazi
    @Override
    public boolean verificaSpaziVuoti(String[] stringhe) {
        for (String stringa : stringhe) {
            if (stringa.trim().isEmpty()) {
                return true;
            }
        }

        return false;
    }
}
