/*
 * Mandelbrot set calculation
 * Troy Daniels - 13/05/2015
 *
 */

package fractalgui;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;

public final class Mandelbrot {
    private final int iterations = 20;
    private double zoom = 160;
    public BufferedImage fractalImage;
    private double reX, reY, imX, imY, temp;
    private Color baseColor=new Color(255,255,255);
    private int RGB, width, height;
    private Point center;
    private double xZoomCenter, yZoomCenter;
            
    public Mandelbrot(int width, int height) {
         fractalImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
         this.width=width;
         this.height=height;
         this.center=new Point(width/2, height/2);
         this.calculate();
    }
    public void calculate(){
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                reX = reY= 0;
                imX =xZoomCenter+((x - center.x) / zoom);
                imY =yZoomCenter+((y - center.y) / zoom);
                int iter = iterations;
                while (reX * reX + reY * reY < 4 && iter > 0) {
                    temp = reX * reX - reY * reY + imX;
                    reY = 2.0 * reX * reY + imY;
                    reX = temp;
                    iter--;
                }
                RGB=(baseColor.getRGB()*(2*iter*iter))%(256^3);
                fractalImage.setRGB(x, y, RGB );
            }
        }
       
    }
    public void scale(double zoom){
       this.zoom+=zoom;
       this.calculate();
    }
    public void recenter(Point center){
       if(center.x<(width/2)){
          this.center.x+=(width/2-center.x);
          xZoomCenter-=(width/2 -center.x)/zoom;
       }else{
          this.center.x-=(center.x-width/2);
          xZoomCenter+=(center.x-width/2)/zoom;
      }
      if(center.y<(height/2)){
          this.center.y+=(height/2-center.y);
          yZoomCenter-=(height/2 -center.y)/zoom;
      }else{
           this.center.y-=(center.y-height/2);
          yZoomCenter+=(center.y-height/2)/zoom;       
      }
      this.calculate();
    }
}
