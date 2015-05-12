/*
 * Contains main method for Mandelbrot Explorer
 * Troy Daniels - 13/05/2015
 *
 */
package fractalgui;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FractalGUI {

   public static void main(String[] args) {

      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            Rectangle screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
            JFrame frame = new MainFrame("Mandelbrot Explorer");
            frame.setSize(screen.width, screen.height);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
         }
      });
   }

}
