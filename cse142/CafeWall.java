// Ryan Graue
// 10/16/18
// CSE 142
// TA: Ivy YU 
// Assignment #3
//
// This program will draw rows with alternating black and white boxes
// The rows can then be combined and offset to make grids which create
// the cafe wall illsuion

import java.awt.*;

public class CafeWall {
   public static final int MORTAR = 2;
   public static void main (String [] args) {
      DrawingPanel panel = new DrawingPanel(650, 400);
      panel.setBackground(Color.GRAY);
      Graphics brush = panel.getGraphics();
      
      drawRow(brush, 0, 0, 4, 20);
      drawRow(brush, 50, 70, 5, 30);
      drawGrid(brush, 425, 180, 5, 20, 10);
      drawGrid(brush, 10, 150, 4, 25, 0);
      drawGrid(brush, 250, 200, 3, 25, 10);
      drawGrid(brush, 400, 20, 2, 35, 35);
   }
   
   // Creates a single row of black and white boxes
   //
   // @Param brush   The graphics object that enables the ability to draw on the drawing panel
   // @Param x       The X-coordinate for the origin of the row
   // @Param y       The Y-coordinate for the origin of the row
   // @Param length  The length of the row in number of boxes
   // @Param size    The size of the boxes for both height and width
   public static void drawRow (Graphics brush, int x, int y, int length, int size) {
      brush.setColor(Color.BLACK);
      for (int i = 0; i < length; i++) {
         brush.fillRect(x + (2 * i * size ), y, size , size);
         brush.setColor(Color.BLUE);
         brush.drawLine(x + (2*i*size) , y , size + x + ( 2* i * size) , y + size);
         brush.drawLine(x + (2 * i * size) , y + size , size + x + (2 * i * size) , y);
         brush.setColor(Color.WHITE);
         for (int j = 0; j<1;j++) {
            brush.fillRect((x + size) + (2 * i * size), y, size , size);
            brush.setColor(Color.BLACK);
         }
      }  
   }
   
   // creates a grid of offset rows of alternating black and white boxes 
   // with a small mortar between them to create the cafe wall illusion
   //
   // @Param brush   The graphics object that enables the ability to draw on the panel
   // @Param x       The X-coordinate for the origin of the grid
   // @Param y       The Y-coordinate for the origin of the grid
   // @Param length  The length of each row in the grid
   // @Param size    The size of the boxes for both height and width
   // @Param offset  The offset between the rows        
   public static void drawGrid (Graphics brush, int x, int y, int length, int size, int offset) {
      for (int line = 0; line < length * 2; line++){
        drawRow(brush, x, y, length, size);
        x = x + offset;
        y = y + MORTAR + size;
        offset = offset * -1;
      }
   }   
}