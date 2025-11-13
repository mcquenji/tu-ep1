/*
    Aufgabe 3) Rekursion
*/
public class Aufgabe3 {

    private static String checkBrackets(String text) {
        if (text.length() <= 1)
            return "";

        final var firstCharIsBracket = text.charAt(0) == '[';

        final var lastCharIsBracket = text.charAt(text.length() - 1) == ']';

        if (firstCharIsBracket && lastCharIsBracket)
            return text.substring(1, text.length() - 1);

        final var startIdx = firstCharIsBracket ? 0 : 1;
        final var stopIdx = text.length() - (lastCharIsBracket ? 0 : 1);

        return checkBrackets(text.substring(startIdx, stopIdx));
    }

    public static void main(String[] args) {

        System.out.println(checkBrackets("HGT[CDE]HJH"));
        System.out.println(checkBrackets("aa[[b]"));
        System.out.println(checkBrackets(""));
        System.out.println(checkBrackets("[a"));
        System.out.println(checkBrackets("]b["));
        // DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODE.
        // **********************************************************************
        assert (checkBrackets("HGT[CDE]HJH").equals("CDE"));
        assert (checkBrackets("aa[[b]").equals("[b"));
        assert (checkBrackets("abc").equals(""));
        assert (checkBrackets("[a").equals(""));
        assert (checkBrackets("]b[").equals(""));
        // **********************************************************************
    }
}
