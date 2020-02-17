/*
* Ryan Graue
* CS 211
* 7/4/19
*/

// an inplemation for a pentagon for the shape interface
public class Pentagon implements Shape {
   private double side;    //side length
   
   // zero parameter constructor
   public Pentagon () {
      side = 0;
   }
   
   // single argument constructor
   public Pentagon (double x) {
      side = x;
   }
   
   // changes the side length
   public void setSide (double x) {
      side = x;
   }
   
   // retuns the side length
   public double getSide () {
      return side;
   } 
   
   // returns the area of the pentagon
   public double getArea () {
      return (Math.sqrt(5 * (5 + 2 * (Math.sqrt(5)))) * side * side) / 4;
   }
   
   // retuns the permieter of the pentagon
   public double getPerimeter () {
      return side * 5;
   }
   
   
}