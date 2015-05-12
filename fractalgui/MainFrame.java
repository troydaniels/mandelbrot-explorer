 /*
 * Troy Daniels - 13/05/2015
 *
 */

package fractalgui;

import java.awt.*;
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
