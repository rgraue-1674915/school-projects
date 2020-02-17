import java.awt.Color;
/*
* Ryan Graue
* CS 211
* 7/3/19
*/

// an imlementation of a wolf for the Animal interface
public class Wolf implements Animal {
   private int distance;
   private int moveCount;
   private boolean increase;
   private int move;
   private int moveTeller;
   
   // Constructor for the wolf class
   public Wolf () {
      distance = 3;
      moveCpunt = 0;
      increase = true;
      move = 0;
      moveTeller = 0;
   }
   
   // retuns string of object
   public String toString() {
      return "W";
   }
   
   // retuns color of the object
   public Color getColor() {
      return new Color(100,0,100);
   }
   
   // returns the direction for each move
   public int getMove() {
      moveCount++;
      if (moveCount <= distance) {
         return move;
      } else {
         getDirection();
         if (getIncrease()) {
            moveCount = 0;
            distance++;
            return move;
         } else {
            moveCount = 0;
            distance--;
            return move;
         }
      }
   }
   
   // changes the direction that the object will move toward
   public void getDirection () {
      moveTeller++;
      if (moveTeller == 1) {
         move = EAST;
      } else if (moveTeller == 2) {
         move = SOUTH;
      } else if (moveTeller == 3) {
         move = WEST;
      } else {
         move = NORTH;
         moveTeller = 0;
      }
   }
   
   // chnages whether the object will move away or towards its origin
   public boolean getIncrease () {
      if (distance == 15) {
         increase = false;
      }
      if (distance == 2) {
         increase = true;
      }
      return increase;
   }
}
