import java.util.*;
/**
 * Rya Graue
 * CS 211
 * 7/10/19
 * 
 */
public class Exercises11
{
    public static void main(String[] a) {
        // Build Integer array
        Integer[] arrayI = {7,4,-9,4,15,8,27,7,11,-5,32,-9,-9};
        ArrayList<Integer> testListI = new ArrayList<Integer>();
        // Build an array of Strings
        String[] arrayS = {"Jane","Logan","Whitaker","Alyssa","Stefanie","Jeff","Kim","Sylvia"};
        ArrayList<String> testListS = new ArrayList<String>();
        
        // Build the Set of Strings:
        for (String s: arrayS) testListS.add(s);
        Set<String> testSetS = new TreeSet<String>(testListS);
        
        // Build the Set of Integers:
         Set<Integer> testSetI = new TreeSet<Integer>();       
        for (int i: arrayI) testSetI.add(i);
        
        // Build a Map of Strings:
        Map<String, String> testMapSS = new HashMap<String, String>();
        Map<String, Integer> testMapSI = new HashMap<String, Integer>();
        String[] array2 = {"Jane2","Logan2","Whitaker2","Alyssa2","Stefanie2","Jeff2","Kim2","Sylvia2"};
        for (int i=0; i<arrayS.length; i++) testMapSS.put(arrayS[i], array2[i]);
        for (int i=0; i<arrayS.length; i++) testMapSI.put(arrayS[i], i);
         
        // Exercise 11.8
       // System.out.println(testSetS);
        //System.out.println("maxLength="+maxLength(testSetS));       
        
        // Exercise 11.11
        System.out.println(testSetI);
        System.out.println("symmetricSetDifference="+symmetricSetDifference(testSetI, testSetI));
        
        // Exercise 11.12
        System.out.println(testListS);
        System.out.println("contains3="+contains3(testListS));
        
        // Exercise 11.13
        System.out.println(testMapSS);
        System.out.println("isUnique="+isUnique(testMapSS));
        
        // Exercise 11.14
        System.out.println(testMapSI);
        System.out.println("intersect="+intersect(testMapSI,testMapSI));
        
        // Exercise 11.15
        System.out.println(testListI);
        System.out.println("maxOccurrences="+maxOccurrences(testListI));
    }
    
    // returns a set of the overlapped Integers from two other sets
    //
    // @Param one    First set of Integers
    // @Param two    Second set of Integers
    public static Set<Integer> symmetricSetDifference (Set<Integer> one, Set<Integer> two){
         Set<Integer> dif = new TreeSet<Integer>();
         dif.addAll(one);
         dif.addAll(two);   
         Set<Integer> intersection = two;
         intersection.retainAll(one);;
         dif.removeAll(intersection);
         return dif;
        }
        
      // returns a boolean if a String appears three times in list of Strings
      //
      // @Param words      List of Strings
      public static boolean contains3 (List<String> words) {
         Map<String, Integer> storage = new TreeMap<String, Integer> (); 
         Iterator<String> itr = words.iterator();
         Integer value = 0;
         while(itr.hasNext()) {
            String key = itr.next();
            if (storage.containsKey(key)) {
               value = storage.get(key) + 1;
               storage.remove(key);
               storage.put(key, value);
            } else {
               storage.put(key,1);
            }
         }
         if (storage.containsValue(3)) {
            return true;
         } else {
            return false;
         }
      }
      
      // returns whether each key and value is unique from eachother in a map
      //
      // @Param data    map of keys and valyes that are both Strings
      public static boolean isUnique (Map<String, String> data) {
         Set<String> values = new TreeSet<String>();
         Set<String> keys = new TreeSet<String>();
         keys = data.keySet();
         for (String key : keys) {
            if (values.contains(data.get(key))) {
               return false;
            }
            values.add(data.get(key));
         }
         return true;
      }
      
      // returns a map of elements that appear in two seperate maps
      //
      // @param one     first map of elements
      // @Param two     second map of elements   
      public static Map<String, Integer> intersect (TreeMap<String, Integer> one,
                                                    TreeMap<String, Integer> two) {
         Map<String, Integer> intersect = new TreeMap<String, Integer>();
         
         for (String key : one.keySet()) {
            if (one.get(key) == two.get(key) && two.containsKey(key)) {
               intersect.put(key, one.get(key));
            }
         } 
         return intersect;
      }
      
      // returns the mode in a list of Integers
      //
      // @param numbers    List of Integers
      public static int maxOccurrences (List<Integer> numbers) {
         Map<Integer, Integer> occurrences = new TreeMap<Integer, Integer>();
         Iterator<Integer> itr = numbers.iterator();
         int count = 0;
         int max =0;
         
         while(itr.hasNext()) {
            Integer x = itr.next();
            if (occurrences.containsKey(x)) {
               count = occurrences.get(x) + 1;
               occurrences.remove(x);
               occurrences.put(x, count);
            } else {
               occurrences.put(x,1);
               max = 1;
            }
            if (count > max) {
               max = count;
            }
         }
         return max;
      }                                         
}