/*
    Aufgabe 3) Rekursion
*/
public class Aufgabe3 {

    private static String checkBrackets(String text) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
        return null; //Zeile kann geändert oder entfernt werden.
    }

    public static void main(String[] args) {

        System.out.println(checkBrackets("HGT[CDE]HJH"));
        System.out.println(checkBrackets("aa[[b]"));
        System.out.println(checkBrackets(""));
        System.out.println(checkBrackets("[a"));
        System.out.println(checkBrackets("]b["));
        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODE.
        //**********************************************************************
        assert (checkBrackets("HGT[CDE]HJH").equals("CDE"));
        assert (checkBrackets("aa[[b]").equals("[b"));
        assert (checkBrackets("abc").equals(""));
        assert (checkBrackets("[a").equals(""));
        assert (checkBrackets("]b[").equals(""));
        //**********************************************************************
    }
}
