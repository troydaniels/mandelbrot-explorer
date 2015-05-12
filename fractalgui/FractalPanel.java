/*
 * Troy Daniels - 13/05/2015
 *
 */

package fractalgui;

import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class FractalPanel extends JPanel {

   private final Rectangle screen;
   private BufferedImage fractalImage;
   private Mandelbrot mandelbrot;

   public FractalPanel() {
      screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
      mandelbrot = new Mandelbrot(screen.width, screen.height);
   }

      @Override
    public void paint(Graphics g) {
        g.drawImage(mandelbrot.fractalImage, 0, 0, this);
    }
}
