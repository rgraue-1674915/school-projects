public class Post {
   public static void main(String[] args) {// store some dates so they can be reused
      CalendarDate[] store = {new CalendarDate(1,1,10), new CalendarDate(1,2,10),new CalendarDate(12,30,10)};
      Stack<CalendarDate> testAll = new Stack<CalendarDate>();
      for (CalendarDate i: store) testAll.push(i);
      //System.out.println(Chapter14.stutter(testAll));
      //System.out.println(Chapter14.equals(testAll,testAll));
      //System.out.println(Chapter14.isSorted(testAll));
      for (int i=1;i<=9;i++) {
       testAll.push(new CalendarDate(1,1,10));
       
       }
      Chapter14.removeMin(testAll);
      while (!testAll.empty()) {
         System.out.println(testAll.pop().longDate()); // only 2 remain
      }
   }
}