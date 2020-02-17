import java.awt.Color;
/*
* Ryan Graue
* CS 211
* 7/3/19
*/

// an implemantion of a rabbit for the Animal class
public class Rabbit implements Animal {
   private int step;
   private int direction;
   
   // constructor for the rabbit class
   public Rabbit () {
      step = 0;
      direction = 0;
   }  
   
   // returns string of the object
   public String toString () {
      return "V";
   }
   
   // returns the direction for each move
   public int getMove () {
      if (step <= 1 && step <= 2) {
         direction = NORTH; 
      } else if (step <= 3 && step <= 4 ) {
         direction = EAST;
      } else {
         direction = SOUTH;
      }
      while (step < 5) {
         step++;
         return direction;
      }
      step = 0;
      return direction;
   }
   
   public Color getColor () {
      return new Color(225,0,0);
   }
}