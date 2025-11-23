/*
    Aufgabe 5) Zweidimensionale Arrays
*/

import java.util.Arrays;

public class Aufgabe5 {

    private static int[][] generateReformattedArray(int[][] inputArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        return null; //Zeile kann geändert oder entfernt werden.
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
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

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[] inputArray) {
        if (inputArray != null) {
            for (int val : inputArray) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] array = new int[][]{{1}};
        System.out.println("Before:");
        printArray(array);
        int[][] arrayRes = generateReformattedArray(array);
        System.out.println("-----");
        System.out.println("After:");
        printArray(arrayRes);
        assert (Arrays.deepEquals(arrayRes, new int[][]{{1}}));
        System.out.println("-----");

        array = new int[][]{{1}, {2, 3, 4, 5, 6, 7}, {8, 9}};
        System.out.println("Before:");
        printArray(array);
        arrayRes = generateReformattedArray(array);
        System.out.println("After:");
        printArray(arrayRes);
        assert (Arrays.deepEquals(arrayRes, new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println("-----");

        array = new int[][]{{1}, {3}, {8, 5}, {6, 5, 9}, {10, 4, 7, 11}};
        System.out.println("Before:");
        printArray(array);
        arrayRes = generateReformattedArray(array);
        System.out.println("-----");
        System.out.println("After:");
        printArray(arrayRes);
        assert (Arrays.deepEquals(arrayRes, new int[][]{{1, 3, 8, 5, 6}, {5, 9, 10, 4, 7}, {11, 0, 0, 0, 0}}));
        System.out.println("-----");

        array = new int[][]{{1, 2, 3, 4, 5, 6, 7, 8}, {9, 10, 11}};
        System.out.println("Before:");
        printArray(array);
        arrayRes = generateReformattedArray(array);
        System.out.println("-----");
        System.out.println("After:");
        printArray(arrayRes);
        assert (Arrays.deepEquals(arrayRes, new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8},{9, 10}, {11, 0}}));
        System.out.println("-----");
    }
}
