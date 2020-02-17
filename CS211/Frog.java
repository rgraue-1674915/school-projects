import java.awt.Color;
/*
* Ryan Graue
* CS 211
* 7/3/19
*/

// an implemenation of a frog for the animal interface
public class Frog implements Animal {
   private int step;
   private int direction;
   
   // constructor for the Frog object
   public Frog () {
      step = 0;
      direction = 0;
      
   }
   
   // returns a string of the object
   public String toString () {
      return "F";
   }
   
   // retuns the direction for each move
   public int getMove () {
      if (step == 0) {
         double r = Math.random();
           if (r < 0.25) {
               direction = NORTH;
               
           } else if (r < 0.5) {
               direction = SOUTH;
           } else if (r < 0.75) {
               direction = EAST;
           } else { 
               direction = WEST;
           }
         }
      while (step < 2 ) {
         step++;
         return direction; 
      }
      step = 0;
      return direction;
   }
   
   public Color getColor () {
      return new Color(0,225,0);
   }
}
