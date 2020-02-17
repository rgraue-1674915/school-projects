// Ryan Graue
// 12/4/18
// CSE 142
// TA: Ivy YU
// Assignment #9
//
// This class is an extension of the Critter class and holds information 
// and properties relevant to an ant that are used in the Critter Main client. 
import java.awt.*;

public class Ant extends Critter {
   private boolean walkSouth;
   private int moveCount;
   
   // constructor for the Ant class
   //
   // @param walkSouth  A specifier to whether the ant walks South or not.
   public Ant (boolean walkSouth) {
      this.walkSouth = walkSouth;
   }
   
   // return the color to be displayed
   public Color getColor () {
      return Color.RED;
   }
   
   // return a boolean whether the any eats or not.
   public boolean eat() {
      return true;
   }
   
   // returns the type of attack
   //
   // @param opponent   The String of what the opponent looks like
   public Attack fight(String opponent) {
      return Attack.SCRATCH;
   }
   
   // returns The direction that the ant will move toward 
   public Direction getMove() {
      moveCount++;
      if (walkSouth) {
         if (moveCount % 2 == 1) {
            return Direction.SOUTH;
         } else{
            moveCount = 0;
            return Direction.EAST;
         }
      } else {
         if (moveCount % 2 == 1) {
            return Direction.NORTH;
         } else{
            moveCount = 0;
            return Direction.EAST;
         }
      } 
   }
   
   // returns a String to what the object will displayed like
   public String toString() {
      return "%";
   }
   
}