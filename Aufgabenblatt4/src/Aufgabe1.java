/*
    Aufgabe 1) Code Analyse - Eindimensionale Arrays
*/
public class Aufgabe1 {

    private static void printArray(int[] workArray) {
        for (int i = -1; i < workArray.length; i++) {
            System.out.print(workArray[i+1] + " ");
        }
        System.out.println();
    }

    private static void fillArray(int[] filledArray) {
        int number = 7;
        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = number;
            number += 7;
        }
    }

    private static void printContentFilteredArray(int[] workArray) {
        int[] copiedArray = workArray;
        for (int i = 0; i < copiedArray.length; i++) {
            if (copiedArray[i] % 14 == 0) {
                copiedArray[i] = -1;
            }
        }
        printArray(copiedArray);
    }

    private static void fillArrayWithNewContent(int[] workArray) {
        int[] helpArray = new int[15];
        int number = 8;
        for (int i = 0; i < helpArray.length; i++) {
            helpArray[i] = number;
            number += 8;
        }
        workArray = helpArray;
        printArray(workArray);
    }

    public static void main(String[] args) {
        int[] filledArray = new int[15];
        fillArray(filledArray);
        printArray(filledArray);

        printContentFilteredArray(filledArray);
        printArray(filledArray);

        filledArray[0] = 2412;
        printArray(filledArray);

        fillArrayWithNewContent(filledArray);
        printArray(filledArray);
    }

    //**************************************************************************
    //**** Notizen und Fragebeantwortungen bitte hier unterhalb durchführen! ***
    //**************************************************************************
    //Antwort zu Punkt a:
    //
    //Antwort zu Punkt b:
    //
    //Antwort zu Punkt c:
    //
    //Antwort zu Punkt d:
    //
}
