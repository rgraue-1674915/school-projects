// Class SearchTree stores and prints a binary search tree of
// objects of type E.  E must implement the Comparable<E>
// interface.  from Reges and Stepp, BJP 3ed.
// modified by W.P. Iverson, to not allow duplicates added
// Bellevue College, November 2015

/*
*  Ryan Graue
*  CS 211
*  8/5/19
*/

public class SearchTree<E extends Comparable<E>> {
    private SearchTreeNode<E> overallRoot; // root of overall tree

    // post: constructs an empty search tree
    public SearchTree() {
        overallRoot = null;
    }
    
    // WRITE ADDITIONAL METHODS HERE:
    
    /*
    * checks whether a tree is full or not.
    * full means that each node has either both leaves full or none.
    *
    * @return {@code true} if set is full
    */
    public boolean isFull () {
      return isFull(overallRoot);
    }
    
    /*
    * recursive helper method
    *
    * @return {@code true} is set is full
    */
    private boolean isFull (SearchTreeNode node) {
      if (node == null) {
         return true;
      }
      if (node.left != null && node.right == null) {
         return false;
      }
      if (node.left == null && node.right != null) {
         return false;
      }
      return (isFull(node.left) && isFull(node.right));
    }
    
    /*
    * determines whehter two tree sets are identical
    *
    * @return {@code true} if sets are equal to each other
    */
    public boolean equals(SearchTree other) {
      return equals(other.overallRoot, this.overallRoot);
    }
    
    /*
    * recursive helper method
    *
    * @return {@code true} if nodes are equal
    */
    private boolean equals (SearchTreeNode<E> n1, SearchTreeNode<E> n2) {
      if (n1 == null && n2 == null) {
         return true;
      }
      if(!subEquals(n1,n2)){
         return false;
      }
      if (n1.data.compareTo(n2.data) != 0) {
         return false;
      }
      return (equals(n1.left,n2.left) && equals(n1.right,n2.right));
      
    }
    
    /*
    * determines if two nodes have matching branch patterns
    * for example if both left branches are not null
    *
    * @return {@code true} if both nodes have matching branch patterns
    */
    private boolean subEquals (SearchTreeNode<E> n1, SearchTreeNode<E> n2) {
      if (n1 == null && n2 != null) {
         return false;
      }else if (n1 != null && n2 == null) {
         return false;
      }else {
         return true;
      }
    }
    
    /*
    * removes the leaves from a tree set
    */
    public void removeLeaves () {
      removeLeaves(overallRoot);
    } 
    
    /*
    * recursive helper method
    *
    * @return SearchTreeNode<E> null for the leaves
    */
    private SearchTreeNode<E> removeLeaves (SearchTreeNode<E> node) {
      if (node == null) {
         return null;
      }
      if (node.left == null && node.right == null) {
         node = null;
         return node;
      }
      node.left = removeLeaves(node.left);
      node.right = removeLeaves(node.right);
      return node;
    }
    
    /*
    * removes a given value from a tree set and then re-orders the tree set appropriatly
    */
    public void remove (E value) {
      SearchTree<E> hold = new SearchTree();
      remove(overallRoot, value, hold);
    }
    
    private SearchTree<E> remove (SearchTreeNode<E> node, E value, SearchTree<E> hold ) {
      if (node == null) {
         return hold;
      }
      if (node.data.compareTo(value) != 0) {
         hold.add(node.data);
      }
      remove(node.left, value, hold);
      remove(node.right,value, hold);
      this.overallRoot = hold.overallRoot;
      return hold;
    }
    
    public int countSameData (SearchTree<E> other) {
      int count = 0;
      return countSameData (other.overallRoot, count);
    }
    
    private int countSameData (SearchTreeNode<E> node, int count) {
      if (node == null) {
         return 0;
      }
      if (this.contains(node.data)) {
        count++;
      }
      count += countSameData(node.left, count);
      count += countSameData(node.right, count);
      return count;
    }
    
    
    

    // post: value added to tree so as to preserve binary search tree
    public void add(E value) {
        overallRoot = add(overallRoot, value);
    }

    // post: value added to tree so as to preserve binary search tree
    private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
        if (root == null) {
            root = new SearchTreeNode<E>(value);
        } else if (root.data.compareTo(value) > 0) {
            root.left = add(root.left, value);
        } else if (root.data.compareTo(value) < 0) {
            root.right = add(root.right, value);
        }
        return root;
    }

    // post: returns true if tree contains value, returns false otherwise
    public boolean contains(E value) {
        return contains(overallRoot, value);
    }   

    // post: returns true if given tree contains value, returns false otherwise
    private boolean contains(SearchTreeNode<E> root, E value) {
        if (root == null) {
            return false;
        } else {
            int compare = value.compareTo(root.data);
            if (compare == 0) {
                return true;
            } else if (compare < 0) {
                return contains(root.left, value);
            } else {   // compare > 0
                return contains(root.right, value);
            }
        }
    }

    // post: prints the data of the tree, one per line
    public void print() {
        printInorder(overallRoot);
    }

    // post: prints the data of the tree using an inorder traversal
    private void printInorder(SearchTreeNode<E> root) {
        if (root != null) {
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
        }
    }

    private static class SearchTreeNode<E> {
        public E data;                   // data stored in this node
        public SearchTreeNode<E> left;   // left subtree
        public SearchTreeNode<E> right;  //  right subtree

        // post: constructs a leaf node with given data
        public SearchTreeNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with the given data and links
        public SearchTreeNode(E data, SearchTreeNode<E> left,
                              SearchTreeNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
