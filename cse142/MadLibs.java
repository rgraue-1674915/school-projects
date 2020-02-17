// Ryan Graue
// 11/13/18
// CSE 142
// TA: Ivy Yu
// assignment #6
// 
// This program allows you to create and view madlibs files
// by reading in premade and formatted files
import java.util.*;
import java.io.*;

public class MadLibs {
   public static void main (String [] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      
      intro();
      
      String command = "";
      while (!command.toLowerCase().equals("q")) {
         System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
         command = console.next();
         command += console.nextLine();
         if (command.toLowerCase().equals("c")) {
            create(console);
         }else if(command.toLowerCase().equals("v")) {
            view(console);
         }
      }
   }
   
   // prints out the intro to the program.
   public static void intro () {
      System.out.println("Welcome to the game of Mad Libs.");
      System.out.println("I will ask you to provide various words");
      System.out.println("and phrases to fill in a story.");
      System.out.println("The result will be written to an output file.");
      System.out.println();

   }
   
   // Creates the new file for the new madlib to be stored in
   //
   // @param console    allows for user input
   public static void create (Scanner console) throws FileNotFoundException {
      File fileIn = new File(fileCheck(console));
      Scanner input = new Scanner(fileIn);
      System.out.print("Output file name: ");
      String outputName = console.next();
      PrintStream output = new PrintStream(new File(outputName));
      System.out.println();
      populate(input, output, console);
   }
   
   // prints out the file that is entered
   //
   // @param console    allows for user input           
   public static void view (Scanner console) throws FileNotFoundException{
      File out = new File(fileCheck(console));
      Scanner reader = new Scanner (out);
      System.out.println();
      while(reader.hasNextLine()) {
         System.out.println(reader.nextLine());
      }
      System.out.println();
   }
   
   // reads in the given madlib file and populates the output file
   // with the user input
   //
   // @param input      Scanner object that reads the input file
   // @param output     Scanner onject that prints to the output file
   // @param console    allows for user input
   public static void populate (Scanner input, PrintStream output, Scanner console) {
      String token = "";
      String topic = "";
      String enter = "";
      String article = "";
      char test = '\0';
      while (input.hasNextLine()){
         String line = input.nextLine();
         Scanner lineScan = new Scanner(line);
         while (lineScan.hasNext()) {
            token = lineScan.next();
            if(token.contains("<") && token.contains(">")){
               topic = token.substring(1,token.length() - 1);
               topic = topic.replace('-', ' ');
               test = topic.toLowerCase().charAt(0);
               if (test == 'a' || test == 'e' || test == 'i' || test == 'o' || test == 'u' ) {
                  article = "an";
               } else {
                  article = "a";
               }
               System.out.print("Please type " + article + " " + topic + ": ");
               enter = console.next();
               enter += console.nextLine();
               output.print(enter + " "); 
            }else {
               output.print(token + " ");
            }
         }
         output.println();
      }
      System.out.println("Your mad-lib has been created!");
      System.out.println();
   }
   
   // checks that the file exists
   //
   // @param console    allows for user input
   public static String fileCheck (Scanner console) {
      System.out.print("Input file name: ");
      String inputName = console.next();
      File fileTest = new File(inputName);
      while (!fileTest.exists()){
         System.out.print("File not found. Try again: ");
         inputName = console.next();
         inputName += console.nextLine();
         fileTest = new File(inputName);
      }
      return inputName;
   }
}