// Ryan Graue
// 10/30/18
// CSE142
// TA: Ivy Yu
// Assignment #5
//
// This program is a guessing game, where you try and guess
// the random number generated in the fewest amount of times
import java.util.*;

public class GuessingGame {
   // @class constant MAX_NUM    the max number in the range of random numbers generated
   public static final int MAX_NUM = 100;

   public static void main (String[] args) {
      Scanner console = new Scanner(System.in);
      Random rand = new Random();
      double totalGuesses = 0;
      double roundGuesses = 0; 
      double totalGames = 0;
      double bestGame = 0;
      String anotherGame = "yes";
      
      haiku();

      while (anotherGame.charAt(0) == 'y') {
         totalGames++;
         int num = rand.nextInt(MAX_NUM) + 1;
         
         roundGuesses = guessing(console, num);
         totalGuesses += roundGuesses;
         bestGame = bestFinder(totalGames , roundGuesses, bestGame);
         
         System.out.print("Do you want to play agian? ");
         anotherGame = console.next().toLowerCase();
         System.out.println();
      }
      results(totalGames , totalGuesses, bestGame);
   }
   
   // Prints out a haiku
   public static void haiku () {
   System.out.println(" How Good is your guess");
   System.out.println("If you get it have a ball");
   System.out.println("  Try till you get it");
   System.out.println();
   }
      
   // takes in the guesses for the game and keeps track of how many
   // guesses have been made for the round
   //
   // @param console    Scanner ibject allowing for user input
   // @param num        random number that user is trying to guess
   public static int guessing (Scanner console, int num) {
      int roundGuesses = 1;
      System.out.println("I'm thinking of a number between 1 and " + MAX_NUM);
      System.out.print("Your guess? ");
      while (!guessCheck(console.nextInt(), num)) {
         System.out.print("Your guess? ");      
         roundGuesses++;
      }
      System.out.println("You got it right in " + roundGuesses + " guesses!");
      return roundGuesses;
   }
   
   // Checks whether the guess is too high, too low, or correct
   //
   // @param guess      the number the user guessed
   // @param num        the number the user is trying to guess
   public static boolean guessCheck (int guess, int num) {
      if (guess < num) {
         System.out.println("It's higher.");
         return false; 
      } else if (guess > num) {
         System.out.println("It's lower.");
         return false;
      } else {
         return true;
      }
   }
   
   // determines the best amount of guesses the user had in a game
   //
   // @param totalGames    The amount of games they have played
   // @param roundGuesses  The amount of guesses they made in the previous game
   // @param bestGame      The amount of guesses in the best guess
   public static double bestFinder (double totalGames , double roundGuesses , double bestGame) {
      if (totalGames == 1) {
         return roundGuesses;
      }else{
         return Math.min(roundGuesses , bestGame);
      }
   }
   
   // prints out the results of the total time played
   //
   // @param totalGames    The amount of games they have played
   // @param totalGuesses  The total amount of guesses made the entire time
   // @param bestGame      The amount of guesses in the best guess
   public static void results (double totalGames, double totalGuesses, double bestGame ) {
      System.out.println("Overall results:");
      System.out.println("Total games   = " + (int)totalGames);
      System.out.println("Total guesses = " + (int)totalGuesses);
      double guessPerGame = totalGuesses/totalGames;
      System.out.printf("Guesses/game  = %.1f\n", guessPerGame);
      System.out.println("Best game     = " + (int)bestGame);   
   }
}