/*
    Aufgabe 1) Zweidimensionale Arrays
*/

import java.util.Arrays;

public class Aufgabe1 {

    private static void changeRows(int[][] workArray) {
        int[] row1 = workArray[0];
        int[] row2 = workArray[1];
        int[] row3 = workArray[2];
        int[][] copy = new int[3][];
        copy[0] = workArray[0];
        copy[1] = workArray[1];
        copy[2] = workArray[2];

        final boolean row1SameLengthRow2 = row1.length == row2.length;
        final boolean row1SameLengthRow3 = row1.length == row3.length;
        final boolean row2SameLengthRow3 = row2.length == row3.length;

        if (row1SameLengthRow2 && row1SameLengthRow3 && row2SameLengthRow3)
            return;

        int longestIdx = 0;
        int longest = workArray[longestIdx].length;
        int shortestIdx = 0;
        int shortest = workArray[shortestIdx].length;

        if (row1SameLengthRow2 && !row1SameLengthRow3 && !row2SameLengthRow3) {
            longestIdx = row1.length > row3.length ? 0 : 2;
            longest = workArray[longestIdx].length;
            shortestIdx = row1.length < row3.length ? 0 : 2;
            shortest = workArray[shortestIdx].length;
        } else if (row1SameLengthRow3 && !row1SameLengthRow2 && !row2SameLengthRow3) {
            longestIdx = row1.length > row2.length ? 0 : 1;
            longest = workArray[longestIdx].length;
            shortestIdx = row1.length < row2.length ? 0 : 1;
            shortest = workArray[shortestIdx].length;
        } else if (row2SameLengthRow3 && !row1SameLengthRow2 && !row1SameLengthRow3) {
            longestIdx = row2.length > row1.length ? 1 : 0;
            longest = workArray[longestIdx].length;
            shortestIdx = row2.length < row1.length ? 1 : 0;
            shortest = workArray[shortestIdx].length;
        } else {

            for (int i = 0; i < workArray.length; i++) {
                final var row = workArray[i];

                if (row.length > longest) {
                    longest = row.length;
                    longestIdx = i;
                    continue;
                }

                if (row.length > shortest)
                    continue;

                shortest = row.length;
                shortestIdx = i;
            }
        }

        workArray[0] = copy[shortestIdx];
        workArray[1] = new int[shortest + longest];
        workArray[2] = copy[longestIdx];

        for (int i = 0; i < shortest + longest; i++) {
            final boolean useLong = i >= shortest;
            final int arrayIdx = useLong ? longestIdx : shortestIdx;
            final int idx = useLong ? i - shortest : i;
            workArray[1][i] = copy[arrayIdx][idx];
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

        System.out.println("Test changeRows:");
        System.out.println("-----");
        int[][] array1 = new int[][] { { 1, 6, 9, 5 }, { 7, 3, 2 }, { 4, 8 } };
        System.out.println("Before:");
        printArray(array1);
        int[] referenceCheck = array1[0];
        changeRows(array1);
        assert referenceCheck == array1[2] : "No reference copy!";
        assert (Arrays.deepEquals(array1, new int[][] { { 4, 8 }, { 4, 8, 1, 6, 9, 5 }, { 1, 6, 9, 5 } }));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array1);
        System.out.println("-----");

        System.out.println("-----");
        array1 = new int[][] { { 7, 8 }, { 2, 4, 6 }, { 1, 2, 3, 4 } };
        System.out.println("Before:");
        printArray(array1);
        changeRows(array1);
        assert (Arrays.deepEquals(array1, new int[][] { { 7, 8 }, { 7, 8, 1, 2, 3, 4 }, { 1, 2, 3, 4 } }));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array1);
        System.out.println("-----");

        array1 = new int[][] { { 1, 3, 5 }, { 2 }, { 2, 4 } };
        System.out.println("Before:");
        printArray(array1);
        changeRows(array1);
        assert (Arrays.deepEquals(array1, new int[][] { { 2 }, { 2, 1, 3, 5 }, { 1, 3, 5 } }));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array1);
        System.out.println("-----");

        array1 = new int[][] { { 1, 2, 3 }, { 1, 1 }, { 2, 1, 2, 1 } };
        System.out.println("Before:");
        printArray(array1);
        changeRows(array1);
        assert (Arrays.deepEquals(array1, new int[][] { { 1, 1 }, { 1, 1, 2, 1, 2, 1 }, { 2, 1, 2, 1 } }));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array1);
        System.out.println("-----");

        array1 = new int[][] { { 3, 4, 1 }, { 2, 3, 3 }, { 1, 2, 5 } };
        System.out.println("Before:");
        printArray(array1);
        changeRows(array1);
        assert (Arrays.deepEquals(array1, new int[][] { { 3, 4, 1 }, { 2, 3, 3 }, { 1, 2, 5 } }));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array1);
        System.out.println("-----");

        array1 = new int[][] { { 3, 4, 5 }, { 6, 7, 8 }, { 1, 2 } };
        System.out.println("Before:");
        printArray(array1);
        changeRows(array1);
        assert (Arrays.deepEquals(array1, new int[][] { { 1, 2 }, { 1, 2, 3, 4, 5 }, { 3, 4, 5 } }));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array1);
        System.out.println("-----");

    }
}
