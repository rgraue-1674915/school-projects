import java.util.ArrayList;
/*
*  Ryan Graue
*  CS 211
*  7/8/19
*/

//  contains all of the items and quantities to be purchased.
//  They are stored in an ArrayList of NumSelected objects
public class ShoppingCart extends ArrayList<NumSelected> {
   private boolean discount;
   
   // Empty Constructor for initialization.
   public ShoppingCart() {
      super();
   }
   
   // Adds the new entry
   //
   // @Param entry      The NumSelected object of the item and how many
   public boolean add (NumSelected entry) {
      for (int i =0; i < super.size(); i++ ) {
         if (entry.getSKU() == super.get(i).getSKU()) {
            super.remove(i);
            super.add(entry);
            return true;
         }
      }
      
      super.add(entry);
      return true;
   }
   
   // returns whether or not the shopping cart has a discount applied to the 
   // final cost or not
   //
   // @Param value      boolean to tell whether or not to apply the discount 
   public void setDiscount (boolean value) {
      discount = value;
   }
   
   // returns the total amount of the shopping cart
   public double getTotal() {
      double total = 0;
      for (int i =0; i < super.size(); i++) {
         total += super.get(i).getPrice();
      }
      if (discount) {
         total = total * .9;
      }
      return total;
   }
}