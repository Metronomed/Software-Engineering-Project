package classes;
import java.util.Map;
import java.util.HashMap;

import lib.MysqlConnect;

import java.sql.ResultSet;
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
		coupon = null;
		checkedOutPrices = new HashMap<Integer, Double>();
		checkedOut = false;
		user = new User(userID);
		this.id = MysqlConnect.insertCart(userID);
	}
	
	private void update() throws Exception{
		MysqlConnect.updateCart(this);
		
	}

	public boolean addItem(int itemID, int quantity) {
		try {
			if (checkedOut) {
				throw new Exception();
			}
			contents.put(itemID, quantity);
			update();
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
			update();
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
			if (quantity == 0) {
				removeItem(itemID);
			}
			else {
				contents.put(itemID, quantity);
				update();
			}
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
		if (coupon != null) {
			discount = coupon.getDiscount();
		}
		return cost * discount;
	}

	public Order checkout() throws Exception {
		for (Map.Entry<Integer, Integer> entry : contents.entrySet()) {
			int itemID = entry.getKey();

			Item currItem = new Item(itemID);
			double itemPrice = currItem.getPrice();
			checkedOutPrices.put(itemID, itemPrice);
		}
		checkedOut = true;
		generateInvoice();
		return new Order(this);
	}

	public boolean addCoupon(String tryCoupon) throws Exception {
		System.out.println("Try to add coupon");
		MysqlConnect mc = new MysqlConnect();
		ResultSet rs = mc.selectFromId(id, "Coupon");
		while(rs.next()){
			int couponID = rs.getInt("id");
			String code = rs.getString("code");
			System.out.println(code);
			double discount = rs.getDouble("discount");
			if (tryCoupon.equals(code)){
				coupon = new Coupon(couponID, code, discount);
				update();
				return true;
			}
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

	private void generateInvoice() throws Exception {
		if (!checkedOut) {
			return;
		}
		StringBuffer inv = new StringBuffer();
		double total = 0.0;
		inv.append("INVOICE:\n");
		inv.append("Purchaser: ");
		inv.append(user.getName());
		inv.append("\nShipping Address: \n");
		inv.append(user.getShippingAddress());
		inv.append("\n\nItems Ordered: \n");
		for (Map.Entry<Integer, Integer> entry : contents.entrySet()) {
			int itemID = entry.getKey();
			int quantity = entry.getValue();
			double itemPrice = checkedOutPrices.get(itemID);
			Item currItem = new Item(itemID);
			total += quantity * itemPrice;
			inv.append("Item: ");
			inv.append(currItem.getName());
			inv.append(", Quantity: ");
			inv.append(entry.getValue());
			inv.append(" @ $");
			inv.append(itemPrice);
			inv.append("\n");
		}
		if (coupon != null) {
			inv.append("Applied Coupon: ");
			inv.append(coupon.getDiscount());
		}
		inv.append("\nTotal Amount: $");
		inv.append(getTotalAmount());
		inv.append("\n\nBilling Address: \n");
		inv.append(user.getBillingAddress());
		inv.append("\n\n");
		invoice = inv.toString();
		update();
	}
	
	public String viewInvoice() {
		return this.invoice;
	}

	public int getID() {
		return id;
	}
	
	private double getTotalAmount(){
		double total = 0.0;
		for (Map.Entry<Integer, Integer> entry : contents.entrySet()) {
			int itemID = entry.getKey();
			int quantity = entry.getValue();
			double itemPrice = checkedOutPrices.get(itemID);
			total += quantity * itemPrice;
		}
		double discount = 1.0;
		if (coupon != null) {
			discount = coupon.getDiscount();
		}
		return total * discount;
	}
	
	public String getContents(){
		StringBuffer contentsAsStringBuffer = new StringBuffer();
		for (Map.Entry<Integer, Integer> entry : contents.entrySet()) {
			int itemID = entry.getKey();
			int quantity = entry.getValue();
			contentsAsStringBuffer.append(itemID);
			contentsAsStringBuffer.append(":");
			contentsAsStringBuffer.append(quantity);
			contentsAsStringBuffer.append(", ");
		}
		String contentsAsString = contentsAsStringBuffer.toString();
		return contentsAsString;
	}
	
	public int getCouponID(){
		if (coupon != null){
			return coupon.getID();
		}else{
			return 0;
		}
	}
	
	public int isCheckedOut(){
		if(checkedOut){
			return 1;
		}else{
			return 0;
		}
	}
}