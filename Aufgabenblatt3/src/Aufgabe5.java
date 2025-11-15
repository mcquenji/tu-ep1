/*
    Aufgabe 4) Quadrate => Rekursiv
*/

import codedraw.*;

import java.awt.*;

public class Aufgabe5 {
    static final int SIZE = 512;
    static final int INITIAL_SQUARE_SIZE = SIZE / 2;

    private static void drawRecursiveSquares(CodeDraw myDrawObj, int x, int y, int s) {
        if (s < 4)
            return;

        // offset required to center the square
        final int offset = s / 2;

        // coordinate of the left side
        final int left = x - offset;

        // coordinate of the top side
        final int up = y - offset;

        // coordinate of the lower side
        final int down = y + offset;

        // coordinate of the right side
        final int right = x + offset;

        drawRecursiveSquares(myDrawObj, left, up, offset);
        drawRecursiveSquares(myDrawObj, left, down, offset);
        drawRecursiveSquares(myDrawObj, right, up, offset);
        drawRecursiveSquares(myDrawObj, right, down, offset);

        final Color fill = Color.YELLOW;
        final Color stroke = Color.BLACK;

        myDrawObj.setColor(fill);
        myDrawObj.fillSquare(x - offset, y - offset, s);
        myDrawObj.setColor(stroke);
        myDrawObj.drawSquare(x - offset, y - offset, s);
        myDrawObj.setColor(Color.red);
    }

    public static void main(String[] args) {
        CodeDraw canvas = new CodeDraw(SIZE, SIZE);
        canvas.setTitle("Fortnite");
        canvas.setCanvasPositionX(50);
        canvas.setCanvasPositionY(50);

        drawRecursiveSquares(canvas, INITIAL_SQUARE_SIZE, INITIAL_SQUARE_SIZE, INITIAL_SQUARE_SIZE);

        canvas.show();
    }
}
