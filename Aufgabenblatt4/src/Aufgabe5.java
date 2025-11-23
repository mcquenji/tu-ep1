/*
    Aufgabe 5) Zweidimensionale Arrays
*/

import java.util.Arrays;

public class Aufgabe5 {

    private static int[][] generateReformattedArray(int[][] inputArray) {
        int numElements = 0;

        for (int i = 0; i < inputArray.length; i++) {
            final var row = inputArray[i];

            numElements += row.length;
        }

        int[] flattend = new int[numElements];

        int idx = 0;
        for (int i = 0; i < inputArray.length; i++) {
            final var row = inputArray[i];

            for (int j = 0; j < row.length; j++) {
                flattend[idx++] = row[j];
            }
        }

        int[][] arr = new int[(int) Math.ceil((double) numElements / inputArray.length)][inputArray.length];
        idx = 0;
        for (int i = 0; i < arr.length; i++) {
            final var row = arr[i];

            for (int j = 0; j < row.length; j++) {
                row[j] = idx >= flattend.length ? 0 : flattend[idx++];
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

        int[][] array = new int[][] { { 1 } };
        System.out.println("Before:");
        printArray(array);
        int[][] arrayRes = generateReformattedArray(array);
        System.out.println("-----");
        System.out.println("After:");
        printArray(arrayRes);
        assert (Arrays.deepEquals(arrayRes, new int[][] { { 1 } }));
        System.out.println("-----");

        array = new int[][] { { 1 }, { 2, 3, 4, 5, 6, 7 }, { 8, 9 } };
        System.out.println("Before:");
        printArray(array);
        arrayRes = generateReformattedArray(array);
        System.out.println("After:");
        printArray(arrayRes);
        assert (Arrays.deepEquals(arrayRes, new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
        System.out.println("-----");

        array = new int[][] { { 1 }, { 3 }, { 8, 5 }, { 6, 5, 9 }, { 10, 4, 7, 11 } };
        System.out.println("Before:");
        printArray(array);
        arrayRes = generateReformattedArray(array);
        System.out.println("-----");
        System.out.println("After:");
        printArray(arrayRes);
        assert (Arrays.deepEquals(arrayRes, new int[][] { { 1, 3, 8, 5, 6 }, { 5, 9, 10, 4, 7 }, { 11, 0, 0, 0, 0 } }));
        System.out.println("-----");

        array = new int[][] { { 1, 2, 3, 4, 5, 6, 7, 8 }, { 9, 10, 11 } };
        System.out.println("Before:");
        printArray(array);
        arrayRes = generateReformattedArray(array);
        System.out.println("-----");
        System.out.println("After:");
        printArray(arrayRes);
        assert (Arrays.deepEquals(arrayRes,
                new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 }, { 9, 10 }, { 11, 0 } }));
        System.out.println("-----");
    }
}
