import java.text.*;
/*
*  Ryan Graue
*  CS 211
*  7/8/19
*/

// A class that acts as an indicual item from the store
public class SKU {
   private static int pkey_next = 123018; //Primary Key origin
   private int pkey;
   private String name;
   private double price;
   private double bulkPrice;
   private double bulkQuantity; 
   NumberFormat nf = NumberFormat.getCurrencyInstance();
   
   // Double parameter constructor
   //
   // @Param name    Name of the object
   // @Param price   Price of the object
   public SKU (String name, double price) {
      this.name = name;
      this.price = price;
      bulkPrice = -1;
      pkey = pkey_next;
      pkey_next++;
   }
   
   // Multi-Paramter constructor
   //
   // @Param name          Name of the object
   // @Param price         Price of the object
   // @Param bulkQuantity  Amount needed to qualify for bulk pricing
   // @Param bulkPrice     The price for a bulk amount
   public SKU (String name, double price, double bulkQuantity, double bulkPrice ) {
      this.name = name;
      this.price = price;
      this.bulkPrice = bulkPrice;
      this.bulkQuantity = bulkQuantity;
      pkey = pkey_next;
      pkey_next++;
   }
   
   // returns the price of a certain number of the item
   //
   // @Param Quantity      amount being added
   public double priceFor (int quantity) {
      if (quantity < 0) {
         throw new IllegalArgumentException ("Quantity is negative.");
      } 
      double total = 0;
      for (int count = 1; count <= quantity; count++) {
         total += price;
         if (count % bulkQuantity == 0) {
            total -= price * bulkQuantity;
            total += bulkPrice;
         }
      }
      return total;
   }
   
   // toString method that returns the price and if applicable the bulk pricing
   public String toString() {
      String formattedPrice = nf.format(price);
      String formatted = "SKU: " + name + ", " + formattedPrice;
      if (bulkPrice != -1) {
         formatted += " (" + bulkQuantity + " for " + bulkPrice + ")" ;
      } 
      return formatted;
   }
   
   // Returns whether two SKU objects are the same
   //
   // @Param other      The SKU object being compared against
   public Boolean equals(SKU other) {
      return other.getSKU() == pkey;
   }
   
   // returns the Primary key
   public int getSKU() {
      return pkey;
   }
   
}