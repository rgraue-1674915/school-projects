import java.awt.Color;
/*
* Ryan Graue
* CS 211
* 7/3/19
*/

// An implemenation of a snake in the Animal interface
public class Snake implements Animal {
   private int step;
   private int direction;
   private boolean east;
   
   // snake class constructor
   public Snake () {
      step = 0;
      east = false;
   }
   
   // returns string of object
   public String toString () {
      return "S";
   }
   
   // returns the movement direction for each move
   public int getMove () {
      step++;
      if (step % 2 == 0 ) {
         east = !east;
         if (east) {
            return EAST;
         } else {
            step = 0;
            return WEST;
         }
      } else {
         return SOUTH;
      }
   }
   
   // retuns the color of the object
   public Color getColor () {
      return new Color(100,100,0);
   }
}