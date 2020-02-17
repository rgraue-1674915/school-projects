/*
*  Ryan Graue
*  CS 211
*  7/8/19
*/

// Object that represents the number of each SKU's selected
public class NumSelected {

   private SKU item;
   private int quantity;
   
   // double parameter constructor
   //
   // @Param item       The SKU item that is being purchased
   // @Param quantity   The amount being purchased
   public NumSelected (SKU item, int quantity) {
      this.item = item;
      this.quantity = quantity;
   }
   
   // returns the price for the amount of items
   public double getPrice() {
      return item.priceFor(quantity);
   }
   
   // returns the primary key of the SKU object
   public int getSKU () {
      return item.getSKU();
   }
   
}