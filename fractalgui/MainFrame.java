 /*
 * Troy Daniels - 13/05/2015
 *
 */
package fractalgui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.*;

public class MainFrame extends JFrame {

   private FractalPanel fractalPanel;

   public MainFrame(String name) {
      super(name);

      fractalPanel = new FractalPanel();
      fractalPanel.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
      fractalPanel.setVisible(true);
      Container container = getContentPane();
      container.add(fractalPanel, BorderLayout.CENTER);
   }
}
