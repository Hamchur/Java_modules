package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImagesToChar {
    private File image;
    private char whitePixel;
    private char blackPixel;

    public ImagesToChar(String image, char whitePixel, char blackPixel) {
        this.image = new File(image);
        this.whitePixel = whitePixel;
        this.blackPixel = blackPixel;
    }

    public void getImage() throws IOException {
        BufferedImage imageBuffer = ImageIO.read(new FileInputStream(image.getAbsolutePath()));
        int [] [] array2D = new int[imageBuffer.getHeight()][imageBuffer.getWidth()];
        for (int x = 0; x < array2D.length; x++) {
            for (int y = 0; y < array2D[x].length; y++) {
                int color = imageBuffer.getRGB(y, x);
                if (color == Color.WHITE.getRGB())
                    System.out.print(whitePixel);
                else
                    System.out.print(blackPixel);
            }
            System.out.println();
        }
    }
}

