/*
    Aufgabe 6) Quadrate => Iterativ
*/

import codedraw.*;

import java.awt.*;

public class Aufgabe6 {

    // Iterative Version => Z.ai GLM4.5v generiert
    public static void drawIterativeSquaresGLM45v(CodeDraw myDrawObj, int width) {

        int k_max = 0;
        int size = width;
        while (size > 4) {
            k_max++;
            size /= 2;
        }

        for (int k = 0; k <= k_max; k++) {
            int current_size = width / (1 << k);
            int num_squares = 1 << (2 * k);

            for (int i = 0; i < num_squares; i++) {
                int x = width / 2;
                int y = width / 2;
                int temp = i;
                for (int j = 0; j < k; j++) {
                    int dir = temp % 4;
                    temp /= 4;

                    int dx = (dir == 0 || dir == 1) ? 1 : -1;
                    int dy = (dir == 0 || dir == 2) ? 1 : -1;

                    x += (current_size / 2) * dx;
                    y += (current_size / 2) * dy;
                }

                if (current_size > 4) {
                    myDrawObj.setColor(Color.YELLOW);
                    myDrawObj.fillRectangle(x - current_size/2, y - current_size/2, current_size, current_size);
                    myDrawObj.setColor(Color.BLACK);
                    myDrawObj.drawRectangle(x - current_size/2, y - current_size/2, current_size, current_size);
                }
            }
        }
    }

    // Iterative Version => ChatGPT 5 generiert
    public static void drawIterativeSquaresChatGPT5(CodeDraw myDrawObj, int width) {
        int s = width / 2;             // Startgröße
        int center = width / 2;        // Mittelpunkt des Fensters

        // Wir speichern keine Werte, sondern berechnen die Koordinaten schrittweise
        // Solange die Seitenlänge > 4 ist, zeichnen wir Quadrate auf allen Ebenen
        while (s > 4) {
            int step = s / 2;
            int n = (width / s);  // Anzahl potenzieller Quadrate in dieser Ebene (nicht wirklich gebraucht)

            // Zeichne alle Quadrate dieser "Ebene"
            for (int dx = -step; dx <= step; dx += s) {
                for (int dy = -step; dy <= step; dy += s) {
                    myDrawObj.setColor(Color.YELLOW);
                    myDrawObj.fillSquare(center + dx - s / 2, center + dy - s / 2, s);
                    myDrawObj.setColor(Color.BLACK);
                    myDrawObj.drawSquare(center + dx - s / 2, center + dy - s / 2, s);
                }
            }

            s /= 2;  // Halbierung für nächste Ebene
        }
    }


    // Iterative Version -> handgeschrieben
    private static void drawIterativeSquares(CodeDraw myDrawObj, int width) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
    }

    public static void main(String[] args) {

        int pixelWidth = 512;
        int pixelHeight = 512;

        CodeDraw myDrawObjIterGLM45v = new CodeDraw(pixelWidth, pixelHeight);
        myDrawObjIterGLM45v.setTitle("Output Iterative Method -> GLM 4.5v");
        myDrawObjIterGLM45v.setCanvasPositionX(50);
        myDrawObjIterGLM45v.setCanvasPositionY(50);

        CodeDraw myDrawObjIterChatGPT5 = new CodeDraw(pixelWidth, pixelHeight);
        myDrawObjIterChatGPT5.setTitle("Output Iterative Method -> ChatGPT 5");
        myDrawObjIterChatGPT5.setCanvasPositionX(600);
        myDrawObjIterChatGPT5.setCanvasPositionY(50);

        CodeDraw myDrawObjIter = new CodeDraw(pixelWidth, pixelHeight);
        myDrawObjIter.setTitle("Output Iterative Method");
        myDrawObjIter.setCanvasPositionX(1150);
        myDrawObjIter.setCanvasPositionY(50);

        drawIterativeSquaresGLM45v(myDrawObjIterGLM45v, pixelWidth);
        myDrawObjIterGLM45v.show();

        drawIterativeSquaresChatGPT5(myDrawObjIterChatGPT5, pixelWidth);
        myDrawObjIterChatGPT5.show();

        drawIterativeSquares(myDrawObjIter, pixelWidth);
        myDrawObjIter.show();
    }
}



