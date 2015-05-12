/*
 * Mandelbrot set calculation
 * Troy Daniels - 13/05/2015
 *
 */

package fractalgui;

import java.awt.Color;
import java.awt.image.BufferedImage;

public final class Mandelbrot {

    private final int iterations = 700;
    private final double zoom = 160;
    public BufferedImage fractalImage;
    private double reX, reY, imX, imY, temp;
    private Color baseColor=new Color(255,255,255);
    private int RGB;
            
    public Mandelbrot(int width, int height) {
         fractalImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                reX = reY = 0;
                imX = (x - width/2) / zoom;
                imY = (y - height/2) / zoom;
                int iter = iterations;
                while (reX * reX + reY * reY < 4 && iter > 0) {
                    temp = reX * reX - reY * reY + imX;
                    reY = 2.0 * reX * reY + imY;
                    reX = temp;
                    iter--;
                }
                RGB=(baseColor.getRGB()*(2*iter*iter))%(256^3);
                fractalImage.setRGB(x, y, RGB );//| (iter << 8));
            }
        }
    }
}
