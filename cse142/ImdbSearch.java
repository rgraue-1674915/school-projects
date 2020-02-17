// This program searches a text file containing information about the top 250 rated 
//   movies on IMDB for movies containing a particular word in the title, then
//   prints the results to an output file.
//
// Notice the use of line-based file input in the find method, the use of a Scanner
//   to tokenize a String in both the highlight and format methods, and the use
//   of input and output files.
import java.util.*;
import java.io.*;

public class ImdbSearch {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      Scanner input = new Scanner(new File("imdb.txt"));
      
      System.out.print("Search term: ");
      String searchTerm = console.next();
      
      System.out.print("Output file? ");
      String outFileName = console.next();
      PrintStream output = new PrintStream(new File(outFileName));
      
      find (searchTerm, input, output);
   }
   
   public static void find(String term, Scanner input, PrintStream output) {
      while (input.hasNextLine()) {
         String line = input.nextLine();
         if (line.toLowerCase().contains(term.toLowerCase())) {
            output.println(format(highlight(term, line)));
         }
      }
   }
   
   public static String highlight(String term, String line) {
      Scanner tokens = new Scanner(line);
      String result = "";
      while (tokens.hasNext()) {
         String token = tokens.next();
         if (token.equalsIgnoreCase(term)) {
            token = "**" + token.toUpperCase() + "**";
         } 
         result += token + " ";
      }
      return result;
   }
   
   public static String format(String movie) {
      Scanner tokens = new Scanner(movie);
      int rank = tokens.nextInt();
      double rating = tokens.nextDouble();
      int count = tokens.nextInt();
      String title = tokens.nextLine();
      
      return "#" + rank + ": " + title + " - rated " + rating + " by " + count + " users";
   }
}