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
                    myDrawObj.fillRectangle(x - current_size / 2, y - current_size / 2, current_size, current_size);
                    myDrawObj.setColor(Color.BLACK);
                    myDrawObj.drawRectangle(x - current_size / 2, y - current_size / 2, current_size, current_size);
                }
            }
        }
    }

    // Iterative Version => ChatGPT 5 generiert
    public static void drawIterativeSquaresChatGPT5(CodeDraw myDrawObj, int width) {
        int s = width / 2; // Startgröße
        int center = width / 2; // Mittelpunkt des Fensters

        // Wir speichern keine Werte, sondern berechnen die Koordinaten schrittweise
        // Solange die Seitenlänge > 4 ist, zeichnen wir Quadrate auf allen Ebenen
        while (s > 4) {
            int step = s / 2;
            int n = (width / s); // Anzahl potenzieller Quadrate in dieser Ebene (nicht wirklich gebraucht)

            // Zeichne alle Quadrate dieser "Ebene"
            for (int dx = -step; dx <= step; dx += s) {
                for (int dy = -step; dy <= step; dy += s) {
                    myDrawObj.setColor(Color.YELLOW);
                    myDrawObj.fillSquare(center + dx - s / 2, center + dy - s / 2, s);
                    myDrawObj.setColor(Color.BLACK);
                    myDrawObj.drawSquare(center + dx - s / 2, center + dy - s / 2, s);
                }
            }

            s /= 2; // Halbierung für nächste Ebene
        }
    }

    // Iterative Version -> handgeschrieben
    private static void drawIterativeSquares(CodeDraw myDrawObj, int width) {
        final int startX = width / 2;
        final int startY = width / 2;
        final int startS = width / 2;

        if (startS < MIN_SIZE) {
            return;
        }

        // calc max stack size
        // size(k) := {4^k for s/(2^k)>=4 ; 0 for s/(2^k) < 4}
        // 4 = s/(2^k) | * (2^k)
        // 4 (2^k) = s | :4
        // 2^k = s/4 | log2
        // k = log2(s/4)
        // maxK := 4^(log2(s/4))
        //
        // As java only provides loge (i.e. Math.log) or log10 we have to do base
        // conversion:
        // log2 := loge(s/4)/log(2) <=> Math.log(s/4)/Math.log(2)
        // source:
        // https://www.purplemath.com/modules/logrules5.htm#:~:text=says%20the%20following%3A-,Change%2Dof%2DBase%20Formula%3A,-Let%20b%20and
        final int k = (int) Math.floor(Math.log((double) startS / 4) / Math.log(2));

        // the stack size is the sum of each k from 0...k <=> 4^0+4^1...+4^k
        // this can also be represented as a geometric series where a_0=1 and the ratio
        // is 4
        // k
        // ⅀ 1×(4)^n => a_n = a×r^(n-1) <=> 1×4^(n-1)
        // n=0
        //
        // thus we can calculate the sum like this
        // Sn = a × (r^n - 1)/(r - 1) => Sk = 1 × (4^k - 1)/3 <=> (4^k - 1)/3
        // but this would be exclusive so k would not be included thus k=k+1
        // => (4^(k+1) - 1)/3
        //
        // source:
        // https://www.geeksforgeeks.org/maths/how-to-find-the-sum-of-a-geometric-series/#:~:text=arn%2D1-,Geometric%20Sum%20Formula,-We%20have%20derived
        int maxStackSize = (int) (Math.pow(4, k + 1) - 1) / 3;

        // init LIFO stack
        int[] stackX = new int[maxStackSize];
        int[] stackY = new int[maxStackSize];
        int[] stackS = new int[maxStackSize];
        // the stage of the stack at [top]. If true drawStage, expand stage otherwise
        boolean[] drawStack = new boolean[maxStackSize];

        int ptr = 0;

        // push center square
        stackX[ptr] = startX;
        stackY[ptr] = startY;
        stackS[ptr] = startS;
        drawStack[ptr] = false;
        ptr++;

        while (ptr > 0) {
            ptr--;

            final int x = stackX[ptr];
            final int y = stackY[ptr];
            final int s = stackS[ptr];
            final boolean draw = drawStack[ptr];

            if (s < MIN_SIZE) {
                continue;
            }

            final int offset = s / 2;

            if (draw) {
                // draw and advance iteration
                myDrawObj.setColor(fill);
                myDrawObj.fillSquare(x - offset, y - offset, s);
                myDrawObj.setColor(stroke);
                myDrawObj.drawSquare(x - offset, y - offset, s);

                continue;
            }
            // calculate locations of the next square based on our current sqaure
            final int left = x - offset;
            final int up = y - offset;
            final int down = y + offset;
            final int right = x + offset;

            // mark the current square as ready to draw
            drawStack[ptr] = true;
            ptr++;

            // push lower right square
            stackX[ptr] = right;
            stackY[ptr] = down;
            stackS[ptr] = offset;
            drawStack[ptr] = false;
            ptr++;

            // push ipper right square
            stackX[ptr] = right;
            stackY[ptr] = up;
            stackS[ptr] = offset;
            drawStack[ptr] = false;
            ptr++;

            // push lower left square
            stackX[ptr] = left;
            stackY[ptr] = down;
            stackS[ptr] = offset;
            drawStack[ptr] = false;
            ptr++;

            // push upper left square
            stackX[ptr] = left;
            stackY[ptr] = up;
            stackS[ptr] = offset;
            drawStack[ptr] = false;
            ptr++;
        }
    }

    static final Color fill = Color.YELLOW;
    static final Color stroke = Color.BLACK;
    static final int MIN_SIZE = 4;

    public static void main(String[] args) {

        int pixelWidth = 512;
        int pixelHeight = 512;

        // CodeDraw myDrawObjIterGLM45v = new CodeDraw(pixelWidth, pixelHeight);
        // myDrawObjIterGLM45v.setTitle("Output Iterative Method -> GLM 4.5v");
        // myDrawObjIterGLM45v.setCanvasPositionX(50);
        // myDrawObjIterGLM45v.setCanvasPositionY(50);

        // CodeDraw myDrawObjIterChatGPT5 = new CodeDraw(pixelWidth, pixelHeight);
        // myDrawObjIterChatGPT5.setTitle("Output Iterative Method -> ChatGPT 5");
        // myDrawObjIterChatGPT5.setCanvasPositionX(600);
        // myDrawObjIterChatGPT5.setCanvasPositionY(50);

        CodeDraw myDrawObjIter = new CodeDraw(pixelWidth, pixelHeight);
        myDrawObjIter.setTitle("Output Iterative Method");
        myDrawObjIter.setCanvasPositionX(1150);
        myDrawObjIter.setCanvasPositionY(50);

        // drawIterativeSquaresGLM45v(myDrawObjIterGLM45v, pixelWidth);
        // myDrawObjIterGLM45v.show();

        // drawIterativeSquaresChatGPT5(myDrawObjIterChatGPT5, pixelWidth);
        // myDrawObjIterChatGPT5.show();

        drawIterativeSquares(myDrawObjIter, pixelWidth);
        myDrawObjIter.show();
    }
}
