/*
 * Troy Daniels - 13/05/2015
 *
 */
package fractalgui;

import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class FractalPanel extends JPanel {

   private final int scaleFactor=3;
   private final Rectangle screen;
   private Mandelbrot mandelbrot;

   public FractalPanel(){
      screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
      mandelbrot = new Mandelbrot(screen.width, screen.height);
      addMouseWheelListener(new MouseWheelListener(){
         @Override
         public void mouseWheelMoved(MouseWheelEvent event){
            FractalPanel.this.mandelbrot.scale(-scaleFactor*event.getUnitsToScroll());
            revalidate();
            repaint();
         }
      });
      addMouseListener(new MouseListener(){
         @Override
         public void mouseClicked(MouseEvent event) {
            
            FractalPanel.this.mandelbrot.recenter(event.getLocationOnScreen());
            revalidate();
            repaint();
         }

         @Override
         public void mousePressed(MouseEvent e) {
      //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         }

         @Override
         public void mouseReleased(MouseEvent e) {
       //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         }

         @Override
         public void mouseEntered(MouseEvent e) {
      //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         }

         @Override
         public void mouseExited(MouseEvent e) {
       ///     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         }
      });

   }

   @Override
   public void paint(Graphics g) {
      g.drawImage(mandelbrot.fractalImage, 0, 0, this);
   }
}
