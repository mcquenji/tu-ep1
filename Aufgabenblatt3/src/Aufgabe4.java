/*
    Aufgabe 4) Rekursion
*/
public class Aufgabe4 {

    private static String appendAllSignsLeft(String text, char character) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        return null; //Zeile kann geändert oder entfernt werden.
    }

    public static void main(String[] args) {

        System.out.println(appendAllSignsLeft("az3kj", 'z'));
        System.out.println(appendAllSignsLeft("kjdn{nd8xngs+d#k", 'n'));
        System.out.println(appendAllSignsLeft("", 'e'));
        System.out.println(appendAllSignsLeft("4", '4'));
        System.out.println(appendAllSignsLeft("ji)o3ie6pk(2i", 'i'));
        System.out.println(appendAllSignsLeft("nothing", 'x'));

        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODE.
        //**********************************************************************
        assert (appendAllSignsLeft("az3kj", 'z').equals("zaz3kj"));
        assert (appendAllSignsLeft("kjdn{nd8xngs+d#k",'n').equals("nnnkjdn{nd8xngs+d#k"));
        assert (appendAllSignsLeft("", 'e').equals(""));
        assert (appendAllSignsLeft("4", '4').equals("44"));
        assert (appendAllSignsLeft("ji)o3ie6pk(2i", 'i').equals("iiiji)o3ie6pk(2i"));
        assert (appendAllSignsLeft("nothing", 'x').equals("nothing"));
        //**********************************************************************
    }
}
