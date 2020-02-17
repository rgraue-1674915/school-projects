import java.awt.Color;
/*
* Ryan Graue
* CS 211
* 7/3/19
*/

// An implemanation of a turtle in the animal interface
public class Turtle implements Animal {
   private int direction;
   private int step;
   
   // Constructor for the Turtle class
   public Turtle () {
      direction = NORTH;
      step = 0;
   }
   
   // returns a string of the object
   public String toString() {
      return "T";
   }
   
   // returns the color of the object
   public Color getColor() {
      return new Color(0,100,100);
   }
   
   // retuns the direction for each move
   public int getMove () {
      step++;
      if (step >= 0 && step <= 4 ) {
         direction = SOUTH;
      } else if (step >= 5 && step <= 9) {
         direction = WEST;
      } else if (step >= 10 && step <= 14 ) {
         direction = NORTH;
      } else {
         direction = EAST;
      }
      if (step == 20) {
         step = 0;
      }
      return direction;
   }
}