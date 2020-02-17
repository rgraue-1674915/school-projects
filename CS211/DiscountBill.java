/*
 * Ryan Graue
 * CS 211
 * 7/3/19
 *
 */
public class DiscountBill extends GroceryBill {
    // FIELDS just for DiscountBill
    private boolean preferred;
    private int count;
    private double discount;
    
    // cunstructor
    public DiscountBill(Employee clerk, boolean maybe) {
      super(clerk);
      preferred = maybe;
      count = 0;
      discount = 0.0;
    }
    
    // Adjust the total discount amount and count based on item amount and 
    // whether it is a preferred customer.
    //
    // @Param i      Specific item to be added to list
    public void add(Item i) {
      super.add(i);
      if (preferred && i.getDiscount() > 0) {
         count++;
         discount += i.getDiscount();
         
      }
    }
    
    // Returns total items that recieved dicount, if any
    public int getDiscountCount() {
      return count;
    }
    
    // retruns total discount amount for all discounted items, if any
    public double getDiscountAmount() {
      return discount;
    }
    
    // returns the percent of the total discount as a percent 
    // of what the total would have been otherwise
    public double getDiscountPercent() {
      return (discount / super.getTotal()) * 100;
    }
    
    // returns new total after diacount has been applied
    public double getTotal () {
      return super.getTotal() - discount;
    }
}