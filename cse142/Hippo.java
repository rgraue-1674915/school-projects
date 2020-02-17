// Ryan Graue
// 12/4/18
// CSE 142
// TA: Ivy YU
// Assignment #9
//
//This class is an extension of the critter class. Holds data and behaviors
// relevant to a hippo which are to then be used in the critter main client.
import java.awt.*;
import java.util.*;

public class Hippo extends Critter {
   private int hunger;
   private Direction way;
   private int moveCount;
   
   // Constructor for the hippo class
   //
   // @param hunger     A number of how many times the hippo object can eat
   public Hippo (int hunger) {
      this.hunger = hunger;
      changeDirection();
   }
   
   // returns the color of the object
   public Color getColor () {
      if (hunger > 0) {
         return Color.GRAY;
      } else {
         return Color.WHITE;
      }
   }
   
   // returns a boolean of whether the object will eat or not
   public boolean eat () {
      if (hunger > 0) {
         hunger--;
         return true;
      } else {
         return false;
      }
   }
   
   // returns the type of attack
   //
   // @param opponent   The String of what the opponent looks like
   public Attack fight(String opponent) {
      if (hunger > 0) {
         return Attack.SCRATCH;
      } else {
         return Attack.POUNCE;
      }
   }
   
   // returns the direcion that the object will move toward
   public Direction getMove() {
      moveCount++;
      if (moveCount == 5) {
         changeDirection();
         moveCount = 0;
      }
      return way;
   }
   
   // changes the direction the object will move toward to a random direction
   public void changeDirection () {
      Random rand = new Random();
      Direction[] directions = {Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};
      way = directions[rand.nextInt(4)];
   }
   
   // returns a string of what the object appears as
   public String toString() {
      return "" + hunger;
   }

}