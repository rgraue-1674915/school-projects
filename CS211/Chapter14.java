import java.util.*;
/*
*  Ryan Graue
*  CS 211
*  7/22/19
*/
public class Chapter14 {
   
   public Chapter14 () {
   
   }
   // returns a stack that contains doubles of each date. Stack remians in the same order
   //
   // @Param dates         Stack of dates
   public static Stack<CalendarDate> stutter (Stack<CalendarDate> dates) {
      Queue<CalendarDate> hold = new LinkedList<CalendarDate>();
      while(!dates.empty()){
         hold.add(dates.pop());
      }
      while(!hold.isEmpty()){
         dates.push(hold.remove());
      }
      while(!dates.empty()) {    //reverse order of stack in queue
         hold.add(dates.pop());
      }
      while(!hold.isEmpty()){
         dates.push(hold.peek());
         dates.push(hold.remove());
      }
      return dates;
   }
   
   // returns a Boolean whether the two stacks are equal.
   // resets the two Stacks to original order afterwards
   //
   // @Param one        Stack of dates
   // @Param two        Stack of dates
   public static boolean equals (Stack<CalendarDate> one, Stack<CalendarDate> two) {
      Stack<CalendarDate> hold = new Stack<CalendarDate>();
      boolean equals = true;
      
      if(one.size() != two.size()){
         return false;
      }
      
      while(!one.empty()){
         hold.push(one.peek());
         hold.push(two.peek());
         if(one.pop().compareTo(two.pop()) != 0) {
            equals = false;
         }
      }
      
      while(!hold.empty()) {
         two.push(hold.pop());
         one.push(hold.pop());
      }
      
      return equals;      
   }
   
   // returns a Boolean whether the Stack is in ascending order
   // resets Stack to original order after
   //
   // @Param dates         Stack of dates
   public static boolean isSorted (Stack<CalendarDate> dates) {
      Stack<CalendarDate> hold = new Stack<CalendarDate>();
      boolean sorted = true;
      
      if (dates.size() <= 1) {
         return true;
      }
      
      hold.push(dates.pop());
      while(!dates.empty()){
         if(hold.peek().compareTo(dates.peek()) >= 1) {
            sorted = false;
         }
         hold.push(dates.pop());
      }
      
      while(!hold.empty()) {
         dates.push(hold.pop());
      }
      
      return sorted;
   }
   
   // Removes the smallest date and any duplicates of the date
   // 
   // @Param dates         Stack of dates
   public static CalendarDate removeMin (Stack<CalendarDate> dates) {
      Queue<CalendarDate> hold = new LinkedList<CalendarDate>();
      CalendarDate min = dates.peek();
      hold.add(dates.pop());
      while (!dates.empty()) {                  //finds smallest date
         if (min.compareTo(dates.peek()) >= 0) {
            min = dates.peek();
         }
         hold.add(dates.pop());
      }
      
      while (!hold.isEmpty()) {                 // removes min and duplicates of min
         if(min.compareTo(hold.peek()) < 0 ) {
            dates.push(hold.remove());
         } else {
            hold.remove();
         }
      }
      while(!dates.empty()){
         hold.add(dates.pop());
      }
      while(!hold.isEmpty()) {
         dates.push(hold.remove());
      }
      
      return min;
      
   }
}