/*
    Aufgabe 2) Zweidimensionale Arrays
*/

import java.util.Arrays;

public class Aufgabe2 {

    private static void reformatArray(int[][] workArray) {
        if (workArray.length <= 1)
            return;

        for (int i = 0; i < workArray.length - 1; i++) {

            int largestIdx = 0;
            int largest = workArray[i][largestIdx];

            for (int j = 0; j < workArray[i].length; j++) {
                final var x = workArray[i][j];

                if (x <= largest)
                    continue;

                largest = x;
                largestIdx = j;

            }

            final var row = new int[workArray[i + 1].length + 1];
            row[row.length - 1] = largest;

            for (int j = 0; j < row.length - 1; j++) {
                row[j] = workArray[i + 1][j];
            }

            workArray[i + 1] = row;
        }
    }

    // Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[][] inputArray) {
        if (inputArray != null) {
            for (int i = 0; i < inputArray.length; i++) {
                for (int j = 0; j < inputArray[i].length; j++) {
                    System.out.print(inputArray[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Test: reformatArray");
        System.out.println("-----");
        int[][] array1 = new int[][] { { 5, 4, 6, 9 }, { 1, 10, 5, 7 }, { 3 }, { 2, 8 }, { 11, 8, 10 }, { 9 } };
        System.out.println("Before:");
        printArray(array1);
        reformatArray(array1);
        assert (Arrays.deepEquals(array1, new int[][] { { 5, 4, 6, 9 }, { 1, 10, 5, 7, 9 }, { 3, 10 }, { 2, 8, 10 },
                { 11, 8, 10, 10 }, { 9, 11 } }));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array1);
        System.out.println("-----");

        array1 = new int[][] { { 6 }, { 5 }, { 2, 1 }, { 3, 4, 5 }, { 1, 2, 3, 5 } };
        System.out.println("Before:");
        printArray(array1);
        reformatArray(array1);
        assert (Arrays.deepEquals(array1,
                new int[][] { { 6 }, { 5, 6 }, { 2, 1, 6 }, { 3, 4, 5, 6 }, { 1, 2, 3, 5, 6 } }));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array1);
        System.out.println("-----");

        array1 = new int[][] { { 6, 3, 4, 1 }, { 8, 1, 2 }, { 9, 10 }, { 14 }, { 13, 10 } };
        System.out.println("Before:");
        printArray(array1);
        reformatArray(array1);
        assert (Arrays.deepEquals(array1,
                new int[][] { { 6, 3, 4, 1 }, { 8, 1, 2, 6 }, { 9, 10, 8 }, { 14, 10 }, { 13, 10, 14 } }));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array1);
        System.out.println("-----");

        array1 = new int[][] { { 5, 3, 4, 1, 8 } };
        System.out.println("Before:");
        printArray(array1);
        reformatArray(array1);
        assert (Arrays.deepEquals(array1, new int[][] { { 5, 3, 4, 1, 8 } }));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array1);
        System.out.println("-----");
    }
}
