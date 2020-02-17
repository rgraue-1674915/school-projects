// Implements a set of objects using a hash table.
// The hash table uses separate chaining to resolve collisions.
// Original from buildingjavaprograms.com supplements
// minor edits by Bill Iverson, Bellevue College, March 2019

/*
*  Ryan Graue
*  CS 211
*  8/7/19
*/
public class HashSet<E> {
    private static final double MAX_LOAD_FACTOR = 0.75;
    private HashEntry<E>[] elementData;
    private int size;
    
    // Constructs an empty set.
    @SuppressWarnings("unchecked")
	public HashSet() {
        elementData = new HashEntry[10];
        size = 0;
    }
    
    // ADD METHODS HERE for exercise solutions:
    
    // returns a formatted string of HashSet
    public String toString2 () {
      String full = "";
      String line = "";
      
      line += String.format("%-10s","[0]");
      for (int i = 1; i < elementData.length; i++) {
         line+= String.format("%-10s","[" + i +"]");
      }
      full += line + "\n";
      if (isEmpty()) {
         return line;
      }
      // populates two dimesnional array of hash set values
      int depth = longestLinkedList();
      String[][] hold = new String[depth][elementData.length];
      for (int j = 0; j < elementData.length; j++) {
         int row = 0;
         HashEntry<E> current = elementData[j];
         while(current != null) {
            hold[row][j] = current.data.toString();
            row++;
            current = current.next;
         }
      }
      full += formatArray(hold);
      return full;
    }
    
    // returns the max length of any linked list with hash set
    public int longestLinkedList () {
      int max = 0;
      for (int i = 0;  i < elementData.length; i++) {
         HashEntry<E> current = elementData[i];
         int depth = 0;
         while (current != null) {
            depth++;
            current = current.next;
         }
         if (depth > max) {
            max = depth;
         }
      }
      return max;
    }
    
    // returns a String of the values in the Hash Set
    //
    // @param array     Two dimensonal array of the values in hash set
    public String formatArray (String[][] array) {
      String format = "";
      for (int row = 0; row < array.length; row++) {
         boolean first = true;
         for (int col = 0; col < array[row].length; col++) {
            if (!first) {
               format += String.format("%-10s", array[row][col]);
               first = false;
            } else {
               if (array[row][col] != null) {
                  format += String.format("%-10s",array[row][col]);
               } else {
                  format += String.format("          ");
               }
            }
         }
         format += "\n"; 
      }
      return format;
    }
    
    // checks whether the elements of two Hash sets equal one another
    //
    // @param other     Other hash set being checked against
    public boolean contentsEqual (HashSet<E> other) {
      if (size != other.size) {
         return false;
      }
      for (int i = 0; i < elementData.length; i ++) {
         HashEntry<E> current = elementData[i];
         while(current != null) {
            if (!other.contains(current.data)) {
               return false;
            }
            current = current.next;
         }
      }
      return true;
      
    }

    
    // Adds the given element to this set, if it was not already
    // contained in the set.
    public void add(E value) {
        if (!contains(value)) {
            if (loadFactor() >= MAX_LOAD_FACTOR) {
                rehash();
            }
            
            // insert new value at front of list
            int bucket = hashFunction(value);
            elementData[bucket] = new HashEntry<E>(value, elementData[bucket]);
            size++;
        }
    }
    
    // Removes all elements from the set.
    public void clear() {
        for (int i = 0; i < elementData.length; i++) {
            elementData[i] = null;
        }
        size = 0;
    }
    
    // Returns true if the given value is found in this set.
    public boolean contains(E value) {
        int bucket = hashFunction(value);
        HashEntry<E> current = elementData[bucket];
        while (current != null) {
            if (current.data.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // Returns true if there are no elements.
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Removes the given value if it is contained in the set.
    // If the set does not contain the value, has no effect.
    public void remove(E value) {
        int bucket = hashFunction(value);
        if (elementData[bucket] != null) {
            // check front of list
            if (elementData[bucket].data.equals(value)) {
                elementData[bucket] = elementData[bucket].next;
                size--;
            } else {
                // check rest of list
                HashEntry<E> current = elementData[bucket];
                while (current.next != null && !current.next.data.equals(value)) {
                    current = current.next;
                }
                
                // if the element is found, remove it
                if (current.next != null && current.next.data.equals(value)) {
                    current.next = current.next.next;
                    size--;
				}
            }
        }
    }
    
    // Returns the number of elements.
    public int size() {
        return size;
    }
    
    // Returns a string representation such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    public String toString() {
        String result = "[";
        boolean first = true;
        if (!isEmpty()) {
            for (int i = 0; i < elementData.length; i++) {
                HashEntry<E> current = elementData[i];
                while (current != null) {
                    if (!first) {
                        result += ", ";
                    }
                    result += current.data;
                    first = false;
                    current = current.next;
                }
            }
        }
        return result + "]";
    }
    
    
    // Returns the preferred hash bucket index for the given value.
    private int hashFunction(E value) {
        return Math.abs(value.hashCode()) % elementData.length;
    }
    
    private double loadFactor() {
        return (double) size / elementData.length;
    }
    
    // Resizes the hash table to twice its former size.
    @SuppressWarnings("unchecked")
	private void rehash() {
        // replace element data array with a larger empty version
        HashEntry<E>[] oldElementData = elementData;
        elementData = new HashEntry[2 * oldElementData.length];
        size = 0;

        // re-add all of the old data into the new array
        for (int i = 0; i < oldElementData.length; i++) {
            HashEntry<E> current = oldElementData[i];
            while (current != null) {
                add((E)current.data);
                current = current.next;
            }
        }
    }
    
    // Represents a single value in a chain stored in one hash bucket.
    @SuppressWarnings("hiding")
	private class HashEntry<E> {
        public E data;
        public HashEntry<E> next;

        @SuppressWarnings("unused")
		public HashEntry(E data) {
            this(data, null);
        }

        public HashEntry(E data, HashEntry<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}
