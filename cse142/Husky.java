// Ryan Graue
// 12/4/18
// CSE 142
// TA: Ivy YU
// Assignment #9
//
//This class is an extension of the critter class. Holds data and behaviors
// relevant to a husky which are to then be used in the critter main client.
import java.awt.*;
import java.util.*;

public class Husky extends Critter {
   private int distance = 3;
   private int moveCount;
   private boolean increase;
   private Direction move = Direction.NORTH;
   private int moveTeller = 0;
   
   // returns a string of what the object appears as
   public String toString () {
      return "‡";
   }
   
   // returns the color of the object
   public Color getColor() {
      return Color.MAGENTA;
   }
   
   // returns the type of attack
   //
   // @param opponent   The String of what the opponent looks like
   public Attack fight(String opponent) {
      String birds = "v<>^";
      if (birds.contains(opponent)) {
         return Attack.SCRATCH;
      } else if (opponent.equals("0")) {
         return Attack.POUNCE;
      } else {
         return Attack.ROAR;
      }
   }
   
   // returns whether the object will eat or not
   public boolean eat() {
      return true;
   }
   
   // returns the dircetion that the object will move toward
   public Direction getMove() {
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
         move = Direction.EAST;
      } else if (moveTeller == 2) {
         move = Direction.SOUTH;
      } else if (moveTeller == 3) {
         move = Direction.WEST;
      } else {
         move = Direction.NORTH;
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