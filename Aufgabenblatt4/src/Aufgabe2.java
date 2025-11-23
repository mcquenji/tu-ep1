/*
    Aufgabe 2) Codeanalyse - Arrays und Methoden
*/

import java.util.Arrays;

public class Aufgabe2 {

    private static void replaceValues(int[] workArray, int threshold) {
        // summe kan auch 0 sein
        int sum = 1;
        for (int value : workArray) {
            sum += value;
        }
        // huh why tf? das verzerrt den durchschnitt
        int average = (sum + 1) / workArray.length;

        // die schleife startet bei 1, der erste wert wird nie ersetzt
        for (int i = 1; i < workArray.length; i++) {
            // what the fuck are you doing? das catched nur zahlen die eins unter dem
            // threshold sind
            if (workArray[i] <= threshold - 1) {
                workArray[i] = 0;
            } else if (workArray[i] == threshold + 1) { // why? das catched zahlen die nicht replaced werden sollten
                workArray[i] = 0;
            } else {
                workArray[i] = average;
            }
        }
    }

    private static void saneSolution(int[] workArray, int threshold) {
        int sum = 0;

        for (int i : workArray) {
            sum += i;
        }
        final int avg = sum / workArray.length;

        for (int i = 0; i < workArray.length; i++) {
            if (workArray[i] <= threshold) {
                workArray[i] = 0;
                continue;
            }

            workArray[i] = avg;
        }

    }

    public static void main(String[] args) {

        int[] array1 = { 0, 9, 9, 9, 9 };
        int[] saneArray1 = Arrays.copyOf(array1, array1.length);
        int[] solution1 = { 0, 0, 0, 0, 0 };

        replaceValues(array1, 10);
        System.out.println(Arrays.toString(array1));
        assert (Arrays.equals(array1, solution1));

        int[] array2 = { 12, 12, 12 };
        int[] saneArray2 = Arrays.copyOf(array2, array2.length);
        int[] solution2 = { 12, 12, 12 };
        replaceValues(array2, 10);
        System.out.println(Arrays.toString(array2));
        assert (Arrays.equals(array2, solution2));

        int[] array3 = { 0, 20, 100, 100 };
        int[] saneArray3 = Arrays.copyOf(array3, array3.length);
        int[] solution3 = { 0, 0, 55, 55 };
        replaceValues(array3, 50);
        System.out.println(Arrays.toString(array3));
        assert (Arrays.equals(array3, solution3));

        // Warum auch immer die methode [replaceValues] werte die exakt 1 größer als
        // [threshhold] sind mit 0 ersetzt.
        int[] array4 = { 0, 50, 100, 100 };
        int[] saneArray4 = Arrays.copyOf(array4, array4.length);
        int[] solution4 = { 0, 62, 62, 62 };
        replaceValues(array4, 49);
        System.out.println(Arrays.toString(array4));
        assert (Arrays.equals(array4, solution4));

        // Der durchschnitt wird falsch berechnet wegen dem +1 im summe und dem starten
        // der sum bei 1.
        // ebenso wird der erste wert im array nie ersetzt da die for schleife bei 1
        // startet
        int[] array5 = { 5, 15 };
        int[] saneArray5 = Arrays.copyOf(array5, array5.length);
        int[] solution5 = { 0, 10 };
        replaceValues(array5, 10);
        System.out.println(Arrays.toString(array5));
        assert (Arrays.equals(array5, solution5));

        System.out.println("/// SANE SOLUTION");

        saneSolution(saneArray1, 10);
        System.out.println(Arrays.toString(saneArray1));
        assert (Arrays.equals(saneArray1, solution1));

        saneSolution(saneArray2, 10);
        System.out.println(Arrays.toString(saneArray2));
        assert (Arrays.equals(saneArray2, solution2));

        saneSolution(saneArray3, 50);
        System.out.println(Arrays.toString(saneArray3));
        assert (Arrays.equals(saneArray3, solution3));

        saneSolution(saneArray4, 49);
        System.out.println(Arrays.toString(saneArray4));
        assert (Arrays.equals(saneArray4, solution4));

        saneSolution(saneArray5, 10);
        System.out.println(Arrays.toString(saneArray5));
        assert (Arrays.equals(saneArray5, solution5));

    }
}
