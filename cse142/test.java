import java.util.*;
public class test {
   public static void main (String[] args) {
      int [] num = {7};
      String test = "   I need to pee  ";
      System.out.println(Arrays.toString(mystery(num)));
      reverse(test);

   }
   
   public static int[] delta (int[] arr) {
      int pointer = 0;
      int length = arr.length*2 - 1;
      int[] deltas = new int[length];
      for (int i = 0; i < deltas.length; i++) {
         if (i % 2 !=0) {
            deltas[i] = arr[pointer + 1] - arr[pointer];
            pointer++;
         }else {
            deltas[i] = arr[pointer];

         }
      }
      return deltas;
   }
   
   public static void reverse(String s) {
      String word = "";
      Scanner sc = new Scanner(s);
      for (int i =0; i < s.length(); i++) {
         if (s.charAt(i) == ' ') {
            System.out.print(s.charAt(0));
         }else if (sc.hasNext()){
            word = sc.next();
            for (int j = word.length(); j > 0; j--){
               System.out.print(word.charAt(j-1));
            }
            i += word.length() - 1;
         }
      }
   }
   
   public static int[] mystery(int[] arr) {
      for (int i =0; i < arr.length; i++) {
         arr[i] = i * arr[i];
      }
      return arr;
   }
   
} 