/*
    Aufgabe 2) Rekursion
*/
public class Aufgabe2 {

    private static void printEvenNumbersDescending(int end) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
    }

    private static int countEqualNeighbors(String text) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
        return -1; //Zeile kann geändert oder entfernt werden.
    }

    public static void main(String[] args) {
        printEvenNumbersDescending(14);
        System.out.println();

        System.out.println(countEqualNeighbors("AA"));
        System.out.println(countEqualNeighbors("ABBBCCDDDE"));
        System.out.println(countEqualNeighbors("matt"));
        System.out.println(countEqualNeighbors("Schifffahrt"));
        System.out.println();

        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODE.
        //**********************************************************************
        assert (countEqualNeighbors("AA") == 1);
        assert (countEqualNeighbors("ABBBCCDDDE") == 5);
        assert (countEqualNeighbors("matt") == 1);
        assert (countEqualNeighbors("Schifffahrt") == 2);
        //**********************************************************************
    }
}

