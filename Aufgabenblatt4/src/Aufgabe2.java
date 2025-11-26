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
        int[] solution1 = { 0, 0, 0, 0, 0 };
        test(array1, 10, solution1);

        int[] array2 = { 12, 12, 12 };
        int[] solution2 = { 12, 12, 12 };
        test(array2, 10, solution2);

        int[] array3 = { 0, 20, 100, 100 };
        int[] solution3 = { 0, 0, 55, 55 };
        test(array3, 50, solution3);

        // Warum auch immer die methode [replaceValues] werte die exakt 1 größer als
        // [threshhold] sind mit 0 ersetzt.
        int[] array4 = { 0, 50, 100, 100 };
        int[] solution4 = { 0, 62, 62, 62 };
        test(array4, 49, solution4);

        // Der durchschnitt wird falsch berechnet wegen dem +1 im summe und dem starten
        // der sum bei 1.
        // ebenso wird der erste wert im array nie ersetzt da die for schleife bei 1
        // startet
        int[] array5 = { 5, 15 };
        int[] solution5 = { 0, 10 };
        test(array5, 10, solution5);

    }

    private static void test(int[] input, int threshhold, int[] solution) {
        int[] copy = Arrays.copyOf(input, input.length);
        System.out.println("Testing: " + Arrays.toString(input) + "; Threshold: " + threshhold);

        replaceValues(input, threshhold);
        saneSolution(copy, threshhold);

        final boolean insane = Arrays.equals(input, solution);
        final boolean sane = Arrays.equals(copy, solution);

        final String soluString = Arrays.toString(solution);
        System.out.println("Insane result: " + Arrays.toString(input) + (insane ? " == " : " != ") + soluString);
        System.out.println("Sane result: " + Arrays.toString(copy) + (sane ? " == " : " != ") + soluString);

        assert insane;
        assert sane;
    }
}
