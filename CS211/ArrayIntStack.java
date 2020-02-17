import java.util.*;
/**
* An array to hold intgers in a stack configuration
*
*  @author Ryan Graue
*  @since 7-19-2019
*/

public class ArrayIntStack {
   private int[] elementData;
   private int size;
   private int lastIndex = -1;
   private final int DEFAULT_SIZE = 20;         /** Default array size */
   
   /** 
   *  Generates array of the DEFAULT_SIZE
   *
   */
   public ArrayIntStack() {
      elementData = new int[DEFAULT_SIZE];
      size = DEFAULT_SIZE;
   }
   
   /** Single parameter constructor for an array of size n
   *
   * @param size          Size of array
   */
   public ArrayIntStack(int size) {
      if (size < 0) {
         throw new IllegalArgumentException("Size must be at least 0: " + size);
      }
      this.size = size;
      elementData = new int[size];
      
   }
   
   /**
   *  returns {@code true} if element is empty
   *
   *  @return {@code true} if element is empty
   */
   public boolean empty() {
      return lastIndex == -1;
   }
   
   /**
   *  returns the top Integer of tf the stack
   *
   *  @return Integer vaue at top of stack
   */
   public int peek() {
      return elementData[lastIndex];
   }
   
   /**
   *  looks at the value in the stack of a given index
   *
   *  @param index      index to look in stack at
   *
   *  @return the Integer value of index
   */
   public int peek(int index) {
      notPresent();
      return elementData[index];
   }
   
   /** 
   *  removes top of stack and returns the value
   *
   *  @return Integer at the top of stack
   */
   public int pop() {
      notPresent();
      int item = elementData[lastIndex];
      lastIndex--;
      return item;  
   }
   
   /**
   *  both places new value at top of stack and returns that value
   *
   *  @param item       value to be placed at top of stack
   *
   *  @return value that was pushed to stack
   */
   public int push(int item) {
      lastIndex++;
      notPresent();
      elementData[lastIndex] = item;
      return item;
   }
   
   /**
   * Creates Iterator object for this stack
   *
   *  @return iterator object for type<ArrayIntStack>
   */
   public IntStackIterator iterator () {
      return new IntStackIterator(this);
   }
   
   /**
   *  returns the last index value of the top of the stack
   *
   *  @return index of the top of stack
   */
   public int getLastIndex() {
      return lastIndex;
   }
   
   /**
   *  checks whether or not given stack method will work
   *
   *  @throws a null pointer exception for whether wrong push, pop, and peek methods
   */
   public void notPresent () {
      if (this.empty()) {
         throw new NullPointerException("Empty Stack");
      }
      if (lastIndex >= size ) {
         throw new NullPointerException("Pointer exceeds size of stack");
      }
   }
   
   /**
   * testing what is writen for a javaDoc
   */
   private void nothing () {
   
   }
   
   
   /**
   *  Iterator for ArrayIntStack object
   *
   *  @author Ryan Graue
   *  @since 7-29-2019
   */
   public static class IntStackIterator implements Iterator<Integer> {
      private int pointer;
      private ArrayIntStack stack;
      
      /**
      *  Single paramater constructor for Iterator
      *
      *  @param stack      Stack object to be iterated through
      */
      public IntStackIterator (ArrayIntStack stack) {
         this.stack = stack;
         pointer = stack.getLastIndex();
      }
      
      /**
      *  Checks whether there is another item value in the stack
      *
      *  @return {@code true} if there is another value in stack
      */
      public boolean hasNext() {
         return pointer < stack.getLastIndex() && pointer >= 0;
      }
      
      
      /**
      *  returns the next value
      *  If no value, throws a null pointer exception
      *
      *  @return int of next item in stack
      */
      public Integer next() {
         if (!hasNext()) {
            throw new NullPointerException();
         } else {
            int item = stack.peek(pointer);
            pointer--;   
            return item;   
         }
      }
   }
}