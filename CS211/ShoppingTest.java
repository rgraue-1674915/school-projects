public class ShoppingTest{
   public static void main (String[] args) {
      SKU one = new SKU("one" , 5.99);
      SKU two = new SKU("two" , 7.99, 10 , 20);
      
     // System.out.println(one.getSKU());
     // System.out.println(two.getSKU());
     // System.out.println(two.priceFor(33));
     // System.out.println(one.equals(two));
      
      ShoppingCart basket = new ShoppingCart();
		System.out.println(basket.size()); // 0
      NumSelected four = new NumSelected(two,3);
      basket.add(four);
      System.out.println(basket.getTotal());
      System.out.println(basket.size()); // 1
      basket.add(new NumSelected(two, 10));
      System.out.println(basket.getTotal());
      System.out.println(basket.size()); // 1
      
      for (int i =0; i < basket.size(); i++) {
         System.out.print(basket.get(i).getSKU() + "  ");
      }  
   }
}