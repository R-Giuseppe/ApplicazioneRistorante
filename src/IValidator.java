public interface IValidator {
    boolean validateNome(Portate portata);
    boolean validateDescrizione(Portate portata);
    boolean validatePrezzo(Portate portata);
    boolean validateIngredienti(Portate portata);
    boolean validatePortata(Portate portata);
    boolean conteggioCifreNumeriche(String stringa);
    boolean conteggioCifreNumeriche(String[] stringhe);
    boolean verificaSpaziVuoti(String stringa);
    boolean verificaSpaziVuoti(String[] stringhe);
}