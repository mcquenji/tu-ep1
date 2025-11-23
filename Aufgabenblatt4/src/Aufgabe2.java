/*
    Aufgabe 2) Codeanalyse - Arrays und Methoden
*/

import java.util.Arrays;

public class Aufgabe2 {

    private static void replaceValues(int[] workArray, int threshold) {
        int sum = 1;
        for (int value : workArray) {
            sum += value;
        }
        int average = (sum + 1) / workArray.length;

        for (int i = 1; i < workArray.length; i++) {
            if (workArray[i] <= threshold - 1) {
                workArray[i] = 0;
            } else if (workArray[i] == threshold + 1) {
                workArray[i] = 0;
            } else {
                workArray[i] = average;
            }
        }
    }

    public static void main(String[] args) {

        int[] array1 = {0, 9, 9, 9, 9};
        replaceValues(array1, 10);
        System.out.println(Arrays.toString(array1));
        assert (Arrays.equals(array1, new int[]{0, 0, 0, 0, 0}));

        int[] array2 = {12, 12, 12};
        replaceValues(array2, 10);
        System.out.println(Arrays.toString(array2));
        assert (Arrays.equals(array2, new int[]{12, 12, 12}));

        int[] array3 = {0, 20, 100, 100};
        replaceValues(array3, 50);
        System.out.println(Arrays.toString(array3));
        assert (Arrays.equals(array3, new int[]{0, 0, 55, 55}));


        //TODO: Schreiben Sie hier Ihre Testfälle
    }
}
