// Ryan Graue
// 10/9/2018
// CSE: 142
// TA: Ivy Yu
// Assignment #2
//
// This program draws a sailboat using ascii characters.
public class AsciiArt {
   public static void main (String[] args) {
      drawSail();
      drawMast();
      drawHull();
   }
   
   // Creates the sail section of the sailboat using forward and backslashes.
   public static void drawSail () {
      for (int line = 1; line <= 3; line++) {
         for (int spaces = 1; spaces <= 9 - (line * 3); spaces++) {
            System.out.print(" ");
         }
         for (int forwardSlash = 1; forwardSlash <= line * 3; forwardSlash++) {
            System.out.print("/");
         }
         for (int backSlash = 1; backSlash <= line * 3; backSlash++) {
            System.out.print("\\");
         }
         System.out.println();
      }
   }
   
   // Creates the mast of the sailboat.
   public static void drawMast () {
      for (int line = 1; line <= 2; line++) {
         for (int spaces = 1; spaces < 9; spaces++) {
            System.out.print(" ");
         }
         for (int mast = 1; mast <= 2; mast++) {
            System.out.print("|");
         }
         System.out.println();
      }
   }
   
   // Creates the hull of the ship. 
   public static void drawHull () {
      for (int line = 1; line <= 2; line++) {
         for (int spaces = 1; spaces < line; spaces++) {
            System.out.print(" ");
         }
         System.out.print("\\");
         for (int shipSide = 1; shipSide <= 18 - 2 * line; shipSide++) {
            System.out.print("_");
         }
         System.out.println("/");
      }
   } 
}