/*
    Aufgabe 4) Zweidimensionale Arrays und CodeDraw - "Schwärzen ähnlicher Bildbereiche"
*/

import codedraw.CodeDraw;
import codedraw.Palette;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Aufgabe4 {

    // converts BufferedImage object to a grayscale array
    private static int[][] convertImg2Array(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        int[][] imgArray = new int[height][width];
        Color tempColor;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                tempColor = new Color(img.getRGB(col, row));
                imgArray[row][col] = (int) (tempColor.getRed() * 0.3 + tempColor.getGreen() * 0.59 + tempColor.getBlue() * 0.11);
            }

        }
        return imgArray;
    }

    //draws the image array to the canvas
    private static void drawImage(int[][] imgArray) {
        CodeDraw cd = new CodeDraw(Math.max(imgArray[0].length, 150), Math.max(imgArray.length, 150));

        for (int y = 0; y < imgArray.length; y++) {
            for (int x = 0; x < imgArray[y].length; x++) {
                cd.setPixel(x, y, Palette.fromGrayscale(imgArray[y][x]));
            }
        }
        cd.show();
    }

    private static int[][] blackenSimilarRegions(int[][] imgArray, int rowStart, int rowEnd, int colStart, int colEnd, double threshold) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        return null; //Zeile kann geändert oder entfernt werden.
    }


    public static void main(String[] args) {

        String fileName = "./src/page4.png";
        BufferedImage img = null;
        // try to open image file
        try {
            img = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        int[][] imgArray = convertImg2Array(img);

        //blacken the "g"
        int[][] resultImg = blackenSimilarRegions(imgArray, 148, 158, 321, 328, 1e5);

        //blacken the "while"
        //int[][] resultImg = blackenSimilarRegions(imgArray, 214, 230, 233, 270, 1e6);

        //binarize by comparing to a single black pixel region
        //int[][] resultImg = blackenSimilarRegions(imgArray, 150, 150, 95, 95, 220 * 220);

        drawImage(imgArray);
        if (resultImg != null) {
            drawImage(resultImg);
        }
    }
}
