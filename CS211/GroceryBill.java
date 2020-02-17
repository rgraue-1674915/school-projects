import java.util.*;
/*
 * W.P. Iverson, June 2019
 * copied from https://practiceit.cs.washington.edu/problems/bjp4/chapter9/GroceryBill.java
 * so we can work Exercise BJP4 Exercise 9.10: DiscountBill
 * 
 * for Bellevue College, CS211
 */
public class GroceryBill {
	// FIELDS
	private Employee clerk;
	private List<Item> receipt;
	private double total;
	private double internalDiscount;
	
	// CONSTRUCTORS
	public GroceryBill(Employee name) {
		clerk = name;
		receipt = new ArrayList<Item>();
		total = 0.0;
		internalDiscount = 0.0;
	}
	
	// Zero parameter constructor added by Iverson
	public GroceryBill() {
		this(new Employee("no name provided"));
	}
	
	public void add(Item i) {
		receipt.add(i);
		total += i.getPrice();
		internalDiscount += i.getDiscount();
	}
	
	public double getTotal() {
		return Math.rint(total * 100) / 100.0;
	}
	
	public Employee getClerk() {
		return clerk;
	}
	
	
	// private methods are called "helper" methods
	private String valueToString(double value) {
		value = Math.rint(value * 100) / 100.0;
		String result = "" + Math.abs(value);
		if(result.indexOf(".") == result.length() - 2) {
			result += "0";
		}
		result = "$" + result;
		return result;
	}
	
	public String receiptToString() {
		String build = "items:\n";
		for(int i = 0; i < receipt.size(); i++) {
			build += "   " + receipt.get(i);
			if(i != receipt.size() - 1) {
				build += "\n";
			}
		}
		return build;
	}
	
	public String toString() {
		return receiptToString() + "\ntotal: " + valueToString(total);
	}
	
	public String discountToString() {
		return receiptToString() + "\nsub-total: " + valueToString(total) + "\ndiscount: " + valueToString(internalDiscount) + "\ntotal: " + valueToString(total - internalDiscount);
	}
	
	// inner Class used only for the GroceryBill Class
	// since we use Item.java for other exercises, we make a different one here
	public static class Item {
		private String name;
		private double price;
		private double discount;
		
		public Item(String name, double price, double discount) {
			this.name = name;
			this.price = price;
			this.discount = discount;
		}
		
		public double getPrice() {
			return price;
		}
		
		public double getDiscount() {
			return discount;
		}
		
		private String valueToString(double value) {
			String result = "" + Math.abs(value);
			if(result.indexOf(".") == result.length() - 2) {
				result += "0";
			}
			result = "$" + result;
			return result;
		}
		
		public String toString() {
			return name + " " + valueToString(price) + " (-" + valueToString(discount) + ")";
		}
	}

//	REPLACEME
	// UW author put that in

}
