/*
    Aufgabe 1) Überladen von Methoden
*/
public class Aufgabe1 {

    private static void addChar(String text, char character) {
        if (text.isEmpty())
            return;

        String result = "";

        // If true insert [character] two times else once.
        boolean toggle = true;

        for (int i = 0; i < text.length(); i++) {
            result += text.charAt(i);

            if (i >= text.length() - 1)
                continue;

            result += character + (toggle ? character : "").toString();

            toggle = !toggle;
        }

        System.out.println(result);
    }

    private static void addChar(int number, char character) {
        addChar(Integer.toString(number), character);
    }

    private static void addChar(String text, String characters) {
        for (int i = 0; i < characters.length(); i++) {
            addChar(text, characters.charAt(i));
        }
    }

    private static void addChar(String text) {
        addChar(text, '=');
    }

    public static void main(String[] args) {
        String text0 = "";
        String text1 = "A";
        String text2 = "CW";
        String text3 = "EP1";
        String text4 = "Index";

        addChar(text0, '&');
        addChar(text1, '+');
        addChar(text2, '*');
        addChar(text3, '-');
        addChar(text4, '#');
        System.out.println();

        addChar(1, '.');
        addChar(42, ':');
        addChar(148, '$');
        addChar(2048, ')');
        addChar(131719, '%');
        System.out.println();

        addChar(text2, "!O(");
        addChar(text4, "T1#+");
        System.out.println();

        addChar(text0);
        addChar(text2);
        addChar(text3);
    }
}
