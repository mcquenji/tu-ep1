/*
    Aufgabe 3) Zweidimensionale Arrays - Sortieren und Filtern
*/
public class Aufgabe3 {

    private static double[][] genCircleFilter(int n, double radius) {
        if (n % 2 == 0) // no need to check for n >= 1 as 0 mod 2 is 0
            return null;

        final var result = new double[n][n];
        final int center = n / 2;

        for (int y = 0; y < result.length; y++) {
            final var row = result[y];

            final var deltaY = y - center;

            for (int x = 0; x < row.length; x++) {
                final var deltaX = x - center;
                final var dist = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
                result[y][x] = dist < radius ? 1 : 0;
            }
        }

        return result;
    }

    private static double[][] applyFilter(double[][] workArray, double[][] filterArray) {
        final var canvasHeight = workArray.length;
        final var canvasWidth = workArray[0].length;
        final var resilt = new double[canvasHeight][canvasWidth];
        final var filterHeight = filterArray.length;
        final var filterWidth = filterArray[0].length;

        final var deltaY = filterHeight / 2;
        final var deltaX = filterWidth / 2;

        for (int y = 0; y < resilt.length; y++) {
            final var startY = y - deltaY;
            final var endY = y + deltaY;

            if (startY < 0)
                continue;
            if (endY >= canvasHeight)
                continue;

            final var row = resilt[y];

            for (int x = 0; x < row.length; x++) {
                final var startX = x - deltaX;
                final var endX = x + deltaX;

                if (startX < 0)
                    continue;

                if (endX >= canvasWidth)
                    continue;

                double value = 0;

                for (int i = 0; i < filterHeight; i++) {

                    for (int j = 0; j < filterWidth; j++) {
                        value += workArray[startY + i][startX + j] * filterArray[i][j];
                    }
                }

                resilt[y][x] = value;
            }
        }

        return resilt;
    }

    private static void print(double[][] workArray) {
        if (workArray != null) {
            for (int y = 0; y < workArray.length; y++) {
                for (int x = 0; x < workArray[y].length; x++) {
                    System.out.printf("%.2f", workArray[y][x]);
                    System.out.print("\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double[][] myResultArray;

        double[][] myFilter1 = genCircleFilter(3, 1.2);
        System.out.println("Output -> myFilter1 (genCircleFilter mit size = 3 und radius = 1.2):");
        print(myFilter1);

        double[][] myFilter2 = genCircleFilter(7, 2.5);
        System.out.println("Output -> myFilter2 (genCircleFilter mit size = 7 und radius = 2.5):");
        print(myFilter2);

        double[][] myArray1 = { { 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 0 }, { 0, 2, 2, 2, 0 }, { 0, 3, 3, 3, 0 },
                { 0, 0, 0, 0, 0 } };
        System.out.println("Output -> myArray1:");
        print(myArray1);

        myResultArray = applyFilter(myArray1, myFilter1);
        System.out.println("Output -> myFilter1 applied to myArray1:");
        print(myResultArray);

        myResultArray = applyFilter(myArray1, myFilter2);
        System.out.println("Output -> myFilter2 applied to myArray1:");
        print(myResultArray);

        // Beispiel aus Aufgabenblatt
        double[][] myArray3 = { { 0, 1, 2, 3 }, { 4, 5, 6, 7 }, { 8, 9, 10, 11 } };
        double[][] myFilter3 = { { 1, 0, 0 }, { 1, 2, 0 }, { 0, 0, 3 } };
        System.out.println("Output -> myArray3:");
        print(myArray3);
        System.out.println("Output -> myFilter3:");
        print(myFilter3);
        myResultArray = applyFilter(myArray3, myFilter3);
        System.out.println("Output -> myFilter3 applied to myArray3:");
        print(myResultArray);

        double[][] myArray4 = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 1, 2, 3, 0 }, { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 } };
        System.out.println("Output -> myArray4:");
        print(myArray4);
        myResultArray = applyFilter(myArray4, new double[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0.5, 0 } });
        print(myResultArray);
    }
}
