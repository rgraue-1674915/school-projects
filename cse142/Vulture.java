// Ryan Graue
// 12/4/18
// CSE 142
// TA: Ivy YU
// Assignment #9
//
//This class is an extension of the critter class. Holds data and behaviors
// relevant to a vulture which are to then be used in the critter main client.
import java.awt.*;

public class Vulture extends Critter {
   private boolean hungry = true;
   private int moveCount;
   private Direction move;   
   
   // returns a boolena to whether the object will eat or not
   public boolean eat () {
      if (hungry) {
         hungry = false;
         return true;
      } else {
         return false;
      }
   }
   
   // returns the type of attack
   //
   // @param opponent   The String of what the opponent looks like
   public Attack fight(String opponent) {
      hungry = true;
      if (opponent.equals("%")) {
         return Attack.ROAR;
      } else {
         return Attack.POUNCE;
      }
   }
   
   // returns the direction that the object will move toward
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
   
   // returns a string of what the object looks like
   public String toString() {
      if (move == Direction.WEST) {
         return "<";
      } else if (move == Direction.EAST) {
         return ">";
      } else if (move == Direction.SOUTH) {
         return "V";
      } else {
         return "^";
      }
   }
   
}