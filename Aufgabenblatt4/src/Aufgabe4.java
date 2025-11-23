/*
    Aufgabe 4) Zweidimensionale Arrays
*/

import java.util.Arrays;

public class Aufgabe4 {

    private static int[][] generateExtendedArray(int[] inputArray) {
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

        int[] array1 = new int[]{2, 1, 1};
        int[][] array1res = generateExtendedArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{1}, {2}}));
        System.out.println("-----");

        array1 = new int[]{4, 3, 0};
        array1res = generateExtendedArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{1, 3, 5}, {}, {2, 4, 6}, {}}));
        System.out.println("-----");

        array1 = new int[]{3, 4, 7};
        array1res = generateExtendedArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{1, 4, 7, 10}, {2, 5, 8, 11, 13, 14, 15}, {3, 6, 9, 12}}));
        System.out.println("-----");

        array1 = new int[]{7, 4, 2};
        array1res = generateExtendedArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{1, 8, 15, 19}, {2, 9}, {3, 10, 16, 20}, {4, 11},
                                                         {5, 12, 17, 21}, {6, 13}, {7, 14, 18, 22}}));
        System.out.println("-----");
        System.out.println();
    }
}
