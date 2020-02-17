import java.util.*;

// Implements a priority queue of comparable objects using a
// min-heap represented as an array.

/*
*  Ryan Graue
*  CS 211 
*  8/13/19
*/
public class HeapPriorityQueue<E extends Comparable<E>> {
    private E[] elementData;
    private int size;
    private Comparator comp = new DefaultComparator(); //field determing which comparator to use
    
    // Constructs an empty queue.
    @SuppressWarnings("unchecked")
    public HeapPriorityQueue() {
        elementData = (E[]) new Comparable[10];
        size = 0;
    }
    
    // ADD METHODS HERE for exercise solutions:
    // constructor accepting a different comparator to use
    //
    // @Param c      Comparator to be used for new ordering
    public HeapPriorityQueue (Comparator c) {
      this();
      comp = c;
    }
    
    /*
    * removes any duplicates within the Heap Queue
    */
    public void removeDuplicates () {
      Set<E> hold = new TreeSet<E>();
      while(!isEmpty()) {
         hold.add(remove());
      }
      Iterator<E> itr = hold.iterator();
      while (itr.hasNext()){
         add(itr.next());
      }
    }
    

    
    // Adds the given element to this queue.
    public void add(E value) {
        // resize if necessary
        if (size + 1 >= elementData.length) {
            elementData = Arrays.copyOf(elementData, elementData.length * 2);
        }
        
        // insert as new rightmost leaf
        elementData[size + 1] = value;
        
        // "bubble up" toward root as necessary to fix ordering
        int index = size + 1;
        boolean found = false;   // have we found the proper place yet?
        while (!found && hasParent(index)) {
            int parent = parent(index);
            if (comp.compare(elementData[index], elementData[parent]) < 0) {
                swap(elementData, index, parent(index));
                index = parent(index);
                
            } else {
                found = true;  // found proper location; stop the loop
            }
        }
        
        size++;
    }
    
    // Returns true if there are no elements in this queue.
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Returns the minimum value in the queue without modifying the queue.
    // If the queue is empty, throws a NoSuchElementException.
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elementData[1];
    }
    
    // Removes and returns the minimum value in the queue.
    // If the queue is empty, throws a NoSuchElementException.
    public E remove() {
        E result = peek();

        // move rightmost leaf to become new root
        elementData[1] = elementData[size];
        size--;
        
        // "bubble down" root as necessary to fix ordering
        int index = 1;
        boolean found = false;   // have we found the proper place yet?
        while (!found && hasLeftChild(index)) {
            int left = leftChild(index);
            int right = rightChild(index);
            int child = left;
            if (hasRightChild(index) &&
                    comp.compare(elementData[right],elementData[left]) < 0) {
                child = right;
            }
            
            if (comp.compare(elementData[index],elementData[child]) > 0) {
                swap(elementData, index, child);
                index = child;
            } else {
                found = true;  // found proper location; stop the loop
            }
        }
        
        return result;
    }
    
    // Returns the number of elements in the queue.
    public int size() {
        return size;
    }
    
    // Returns a string representation of this queue, such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    public String toString() {
        String result = "[";
        if (!isEmpty()) {
            result += elementData[1];
            for (int i = 2; i <= size; i++) {
                result += ", " + elementData[i];
            }
        }
        return result + "]";
    }
    
    
    // helpers for navigating indexes up/down the tree
    private int parent(int index) {
        return index / 2;
    }
    
    // returns index of left child of given index
    private int leftChild(int index) {
        return index * 2;
    }
    
    // returns index of right child of given index
    private int rightChild(int index) {
        return index * 2 + 1;
    }
    
    // returns true if the node at the given index has a parent (is not the root)
    private boolean hasParent(int index) {
        return index > 1;
    }
    
    // returns true if the node at the given index has a non-empty left child
    private boolean hasLeftChild(int index) {
        return leftChild(index) <= size;
    }
    
    // returns true if the node at the given index has a non-empty right child
    private boolean hasRightChild(int index) {
        return rightChild(index) <= size;
    }
    
    // switches the values at the two given indexes of the given array
    private void swap(E[] a, int index1, int index2) {
        E temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

   /*
   *  private class to determing ordering based on given Comparator
   */
   private static class DefaultComparator implements Comparator {
      // Default Constructor
      public DefaultComparator () {
      
      }
      
      // returns whether fisrt object is great, less than, or equalto other object
      // depending on Comparator ordering preference
      //
      // @param e1      object being compared
      // @param e2      object being compared against
      //
      // @return negative number if less than, 0 if equal, and positive if greater than
      public int compare(Object e1, Object e2) {
         return ((Comparable) e1).compareTo(e2);
      }
   }

}
