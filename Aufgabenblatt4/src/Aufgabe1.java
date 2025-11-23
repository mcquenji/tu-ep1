/*
    Aufgabe 1) Code Analyse - Eindimensionale Arrays
*/

import java.util.Arrays;

public class Aufgabe1 {

    private static void printArray(int[] workArray) {
        for (int i = -1; i < workArray.length - 1; i++) {
            System.out.print(workArray[i + 1] + " ");
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

    // **************************************************************************
    // **** Notizen und Fragebeantwortungen bitte hier unterhalb durchführen! ***
    // **************************************************************************
    // Antwort zu Punkt a:
    // da wir von minus eins zu array.length - 1 itererieren und innerhalb der
    // schleife i+1 gerechnet wird. D.h. wir haben am ende bei z.B. einem 2
    // elementigen array print(arr[i+1]) was auf 1+1=2 kommt und arrays fangen aber
    // bei 0 an.
    // Antwort zu Punkt b:
    // Da ein Array kein primitiver datentyp ist i.e. es wird eine referenz
    // übergeben und änderungen innerhalb der methode in dem objekt werden im heap
    // durchgeführt. da nach dem aufruf die referenz die selbe ist haben ist kein
    // return nötig.
    // Antwort zu Punkt c:
    // Die "copy" auf zeile 22 ist ein shallow copy also es wird nur die referenz
    // auf den heap kopiert. um dies zu verhndern währe eine deep copy nötig, die
    // ein neues array im heap anlegt.
    // Antwort zu Punkt d:
    // zeile 38 setzt die referenz der LOCAL variable auf die addresse des neuen
    // arrays. die variable auserhalb der methode hat immernoch eine referenz auf
    // den alten array. man müssete den übergebenen array manuell überspielen um
    // änderungen zu persitieren.
    //
    // 1. Welchen Datentyp muss der Indexausdruck haben, mit dem die Position in
    // einem Array bestimmt wird?
    // int
    // 2. Wie kann die Länge eines Arrays verändert werden?
    // Entweder statt einem array eine LinkedList oder ArrayList (oder eine andere
    // impl von java.util.List) verwenden. diese haben eine dynamische länge.
    // ansonsten muss man einen neuen array erstellen mit einer neuen länge, die
    // alten werte in diesen hineinkopieren und diese referenz verwenden.
    // 3. Wie gehen Sie vor, wenn Sie ein int-Array kopieren mussen?
    // einen neuen array mit der selben länge erstellen und durchloopen und
    // newArr[i]=arr[i]
    // 4. Ist es sinnvoll, zwei Arrays mit "==" zu vergleichen? Was passiert im
    // Detail bei einem Vergleich mit "=="?
    // bin mir nicht sicher wie java das under the hood handeld wenn es sich um
    // einen array an primitiven datentypen handelt aber bei einem `==`wird
    // überprüft ob es sich um das GLEICHE/IDENTISCHE handelt also bei reftypes ob
    // beide variablen auf die selbe addresse im heap eigen und bei primitives
    // werden die werte verglichen. Daher in java immer .equals verwenden wenn die
    // actuall werte verglichen werden sollen.
}
