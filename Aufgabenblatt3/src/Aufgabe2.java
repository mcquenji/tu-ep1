/*
    Aufgabe 2) Rekursion
*/
public class Aufgabe2 {

    private static void printEvenNumbersDescending(int end) {
        if (end <= 0) {
            System.out.println(0);
            return;
        }

        end = end % 2 == 0 ? end : end - 1;

        System.out.print(end + " ");

        printEvenNumbersDescending(end - 2);
    }

    private static int countEqualNeighbors(String text) {
        if (text.length() <= 1)
            return 0;

        final var firstChar = text.charAt(0);
        final var nextChar = text.charAt(1);

        return (firstChar == nextChar ? 1 : 0) + countEqualNeighbors(text.substring(1));
    }

    public static void main(String[] args) {
        printEvenNumbersDescending(14);
        System.out.println();

        System.out.println(countEqualNeighbors("AA"));
        System.out.println(countEqualNeighbors("ABBBCCDDDE"));
        System.out.println(countEqualNeighbors("matt"));
        System.out.println(countEqualNeighbors("Schifffahrt"));
        System.out.println();

        // DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODE.
        // **********************************************************************
        assert (countEqualNeighbors("AA") == 1);
        assert (countEqualNeighbors("ABBBCCDDDE") == 5);
        assert (countEqualNeighbors("matt") == 1);
        assert (countEqualNeighbors("Schifffahrt") == 2);
        // **********************************************************************
    }
}
