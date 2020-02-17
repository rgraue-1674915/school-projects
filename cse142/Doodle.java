// Ryan Graue
// 10/16/18
// CSE 142
// TA: Ivy Yu
// Assignment #3
//
// Draws a sailboat which can be scaled and moed to any position on the drawing panel

import java.awt.*;

public class Doodle {
   public static final int SCALE = 10;
   public static void main (String[] args) {
      DrawingPanel panel = new DrawingPanel(1000,1000);
      panel.setBackground(Color.GRAY);
      Graphics brush = panel.getGraphics();
      
      drawSailboat(brush, 400, 100);
   }
   
   // draws a sailboat on the water
   //
   // @Param brush   The graphics object which allows for drawing on the panel
   // @Param x       The X-coordinate for the origin of the sailboat
   // @Param y       The Y-coordinate for the origin of the sailboat
   public static void drawSailboat (Graphics brush, int x, int y) {
      brush.fillRect(x + 18 * SCALE , y , 1 * SCALE , 60 * SCALE);
      brush.fillArc(x - 25 * SCALE , y + 45 * SCALE , 80 * SCALE, 18 * SCALE, -180,180 );
      brush.setColor(Color.ORANGE);
      brush.fillArc(x - 18 * SCALE , y , 70 * SCALE, 100 * SCALE, 90, 90);
      brush.fillArc(x, y, 40 * SCALE, 100 * SCALE, 90, -90);
      brush.setColor(Color.BLUE);
      brush.fillRect(0, y + 60 * SCALE, 1000, 1000);
      
   }
}