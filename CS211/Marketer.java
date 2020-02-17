/*
* Ryan Graue
* CS 211
* 7/3/19
*/

// A class to represent a marketer which is an extension of the 
// standard employee
public class Marketer extends Employee {
   
   // cunstructor of marketer object
   public Marketer () {
   
   }
   
   // returns the adjusted salary
   public double getSalary () {
      return super.getSalary() + 10000;
   }
   
   // to string method which returns their special saying.
   public String toString() {
      return "Act now, while supplies last!";
   }
}