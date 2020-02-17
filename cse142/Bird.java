// Ryan Graue
// 12/4/18
// CSE 142
// TA: Ivy YU
// Assignment #9
//
// This class is an extension of the Critter class and creates a bird object.
// Stores information and data relevant to the birds behavior in the Critter
// main client program.
import java.awt.*;

public class Bird extends Critter {
   private int moveCount;
   private Direction move;
   
   // returns the color of the bird object
   public Color getColor() {
      return Color.BLUE;
   }
   
   // returns the type of attack
   //
   // @param opponent   The String of what the opponent looks like
   public Attack fight(String opponent) {
      if (opponent.equals("%")) {
         return Attack.ROAR;
      } else {
         return Attack.POUNCE;
      }
   }
   
   // returns what direction the object will move toward
   public Direction getMove() {
      moveCount ++;
      if (moveCount <= 3) {
         move = Direction.NORTH;
      } else if (moveCount > 3 && moveCount <= 6) {
         move = Direction.EAST;
      } else if (moveCount > 6 && moveCount <= 9) {
         move =  Direction.SOUTH;
      } else {
         move =  Direction.WEST;
      }
      if (moveCount == 12 ) {
         moveCount = 0;
      }
      return move; 
   }
   
   // returns what the object looks like
   public String toString() {
      if (move == Direction.WEST) {
         return "<";
      } else if (move == Direction.EAST) {
         return ">";
      } else if (move == Direction.SOUTH) {
         return "v";
      } else {
         return "^";
      }
   }
   
}