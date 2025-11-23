/*
    Aufgabe 3) Zweidimensionale Arrays
*/

import java.util.Arrays;

public class Aufgabe3 {

    private static int[][] generateFilledArray(int n) {
        int[][] arr = new int[n][n];

        int counter = 1;

        for (int i = 0; i < arr.length; i++) {
            final boolean reverseOrder = i % 2 == 1;

            int j = reverseOrder ? arr.length - 1 : 0;

            for (; reverseOrder ? j >= 0 : j < arr.length; j += (reverseOrder ? -1 : 1)) {
                arr[i][j] = counter++;
            }
        }

        return arr;
    }

    // Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[][] inputArray) {
        if (inputArray != null) {
            for (int[] arr : inputArray) {
                for (int val : arr) {
                    System.out.print(val + "\t");
                }
                System.out.println();
            }
        }
    }

    // Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[] inputArray) {
        if (inputArray != null) {
            for (int val : inputArray) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] array = generateFilledArray(1);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][] { { 1 } }));
        System.out.println("-----");

        array = generateFilledArray(2);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][] { { 1, 2 }, { 4, 3 } }));
        System.out.println("-----");

        array = generateFilledArray(3);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][] { { 1, 2, 3 }, { 6, 5, 4 }, { 7, 8, 9 } }));
        System.out.println("-----");

        array = generateFilledArray(5);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][] { { 1, 2, 3, 4, 5 }, { 10, 9, 8, 7, 6 }, { 11, 12, 13, 14, 15 },
                { 20, 19, 18, 17, 16 }, { 21, 22, 23, 24, 25 } }));
        System.out.println("-----");

        array = generateFilledArray(7);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][] { { 1, 2, 3, 4, 5, 6, 7 }, { 14, 13, 12, 11, 10, 9, 8 },
                { 15, 16, 17, 18, 19, 20, 21 }, { 28, 27, 26, 25, 24, 23, 22 },
                { 29, 30, 31, 32, 33, 34, 35 }, { 42, 41, 40, 39, 38, 37, 36 },
                { 43, 44, 45, 46, 47, 48, 49 } }));
        System.out.println("-----");
        System.out.println();
    }
}
