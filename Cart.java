import java.util.Map;
import java.util.HashMap;

public class Cart {
	int ID;
	User user;
	Map<Integer, Integer> contents;
	Coupon coupon;
	boolean isCheckedOut;
	Map<Integer, Double> checkedOutPrices;
	String invoice;

	public Cart(int userID) {
		//use database to load user
		contents = new HashMap<Integer, Integer>();
		checkedOutPrices = new HashMap<Integer, Double>();
		isCheckedOut = false;
	}

	public boolean addItem(int itemID, int quantity) {
		try {
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
			contents.put(itemID, quantity);
			return true;
		}
		catch (Exception e) {
			System.out.println("Failed to change quantity");
			return false;
		}
	}

	public double calculateCost() {
		double cost = 0.0;
		for (Map.Entry<Integer, Integer> entry : contents.entrySet()) {
			int itemID = entry.getKey();
			int quantity = entry.getValue();

			//lookup item cost
			double itemPrice = 1.0;
			cost += itemPrice * quantity;
		}
		double discount = 1.0;
		if (coupon.isValid() ) {
			discount = coupon.getDiscount();
		}
		return cost * discount;
	}

	public boolean checkout() {
		for (Map.Entry<Integer, Integer> entry : contents.entrySet()) {
			int itemID = entry.getKey();

			//lookup item cost
			double itemPrice = 1.0;
			checkedOutPrices.put(itemID, itemPrice);
		}
		isCheckedOut = true;
		return true;
	}

	public boolean addCoupon(Coupon tryCoupon) {
		if (tryCoupon.isValid() ) {
			coupon = tryCoupon;
			return true;
		}
		return false;
	}

	public String generateInvoice() {
		if (!isCheckedOut) {
			return null;
		}
		String invoice = "";

		return invoice;
	}
}