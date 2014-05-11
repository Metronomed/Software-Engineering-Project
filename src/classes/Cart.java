package classes;
import java.util.Map;
import java.util.HashMap;

import lib.MysqlConnect;
import java.sql.SQLException;

public class Cart {
	private int id;
	User user;
	private Map<Integer, Integer> contents;
	Coupon coupon;
	private boolean checkedOut;
	private Map<Integer, Double> checkedOutPrices;
//	private double totalAmount;
	private String invoice;

	//if user has cart that is not checked out, should load that cart instead

	public Cart(int userID) throws Exception {
		//use database to load user
		contents = new HashMap<Integer, Integer>();
		checkedOutPrices = new HashMap<Integer, Double>();
		checkedOut = false;
		
		this.id = MysqlConnect.insertCart(userID);
	}
	
//	private void update() throws Exception{
//		MysqlConnect.updateCart(this);
//		
//	}

	public boolean addItem(int itemID, int quantity) {
		try {
			if (checkedOut) {
				throw new Exception();
			}
			contents.put(itemID, quantity);
			return true;
		}
		catch (Exception e) {
			System.out.println("Failed to add item");
			return false;
		}
	}

	public boolean removeItem(int itemID) {
		try {
			if (checkedOut) {
				throw new Exception();
			}
			contents.remove(itemID);
			return true;
		}
		catch (Exception e) {
			System.out.println("Failed to remove item");
			return false;
		}
	}

	public boolean changeQuantity(int itemID, int quantity) {
		try {
			if (checkedOut) {
				throw new Exception();	
			}
			contents.put(itemID, quantity);
			return true;
		}
		catch (Exception e) {
			System.out.println("Failed to change quantity");
			return false;
		}
	}

	public double calculateCost() throws SQLException {
		double cost = 0.0;
		for (Map.Entry<Integer, Integer> entry : contents.entrySet()) {
			int itemID = entry.getKey();
			int quantity = entry.getValue();

			Item currItem = new Item(itemID);
			double itemPrice = currItem.getPrice();
			cost += itemPrice * quantity;
		}
		double discount = 1.0;
		if (coupon != null && coupon.isValid() ) {
			discount = coupon.getDiscount();
		}
		return cost * discount;
	}

	public boolean checkout() throws SQLException {
		for (Map.Entry<Integer, Integer> entry : contents.entrySet()) {
			int itemID = entry.getKey();

			Item currItem = new Item(itemID);
			double itemPrice = currItem.getPrice();
			checkedOutPrices.put(itemID, itemPrice);
		}
		checkedOut = true;
		return true;
	}

	public boolean addCoupon(Coupon tryCoupon) {
		if (tryCoupon.isValid() ) {
			coupon = tryCoupon;
			return true;
		}
		return false;
	}

	public String printCart() throws SQLException {
		StringBuffer output = new StringBuffer();
		output.append("Cart:\n");
		for (Map.Entry<Integer, Integer> entry : contents.entrySet()) {
			int itemID = entry.getKey();
			Item currItem = new Item(itemID);
			double itemPrice = currItem.getPrice();
			output.append("Item: ");
			output.append(currItem.getName());
			output.append(", Quantity: ");
			output.append(entry.getValue());
			output.append(" @ $");
			output.append(itemPrice);
			output.append("\n");
		}
		output.append("Total Amount: $");
		output.append(this.calculateCost());
		output.append("\n");
		return output.toString();
	}

	public String generateInvoice() {
		if (!checkedOut) {
			return null;
		}
		String invoice = "";

		return invoice;
	}
	
	public int getID() {
		return id;
	}
	
	public double getTotalAmount(){
		double total = 0.0;
		for (Map.Entry<Integer, Integer> entry : contents.entrySet()) {
			int itemID = entry.getKey();
			int quantity = entry.getValue();
			double itemPrice = checkedOutPrices.get(itemID);
			total += quantity * itemPrice;
		}
		return total;
	}
	
	public String getContents(){
		return "";
	}
}