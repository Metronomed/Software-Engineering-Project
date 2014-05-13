package classes;
import java.util.Map;
import java.util.HashMap;

import lib.MysqlConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class Cart {
	private int id;
	private User user;
	private Map<Integer, Integer> contents;
	private Coupon coupon;
	private boolean checkedOut;
	private Map<Integer, Double> checkedOutPrices;
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
		invoice = "";
	}
	
	private String priceFormat(double price) {
		DecimalFormat df = new DecimalFormat("##.00");
		return df.format(price);
	}

	private void update() throws Exception{
		MysqlConnect.updateCart(this);
		
	}

	public boolean addItem(int itemID, int quantity) {
		try {
			if (checkedOut || quantity <= 0) {
				return false;
			}
			contents.put(itemID, quantity);
			update();
			Item item = new Item(itemID);
			String itemName = item.getName();
			String itemPrice = priceFormat(item.getPrice());
			String plurality = quantity==1?" ":"s ";
			System.out.println(user.getName()+" put "+quantity+" "+itemName+plurality+"@ $"+itemPrice+" in cart.");
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
				return false;
			}
			contents.remove(itemID);
			update();
			Item item = new Item(itemID);
			String itemName = item.getName();
			System.out.println(user.getName()+" has removed "+itemName+" from cart.");
			return true;
		}
		catch (Exception e) {
			System.out.println("Failed to remove item");
			return false;
		}
	}

	public boolean changeQuantity(int itemID, int quantity) {
		try {
			if (checkedOut || quantity < 0) {
				return false;	
			}
			if (quantity == 0) {
				removeItem(itemID);
			}
			else {
				contents.put(itemID, quantity);
			}
			Item item = new Item(itemID);
			String itemName = item.getName();
			System.out.println(user.getName()+" changed the quantity of "+itemName+" to "+quantity+".");
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
	
	public double calculateTotalWithoutDiscount() throws SQLException{
		double cost = 0.0;
		for (Map.Entry<Integer, Integer> entry : contents.entrySet()) {
			int itemID = entry.getKey();
			int quantity = entry.getValue();

			Item currItem = new Item(itemID);
			double itemPrice = currItem.getPrice();
			cost += itemPrice * quantity;
		}
		return cost;
	}

	public Order checkout() throws Exception {
		if (checkedOut) {
			throw new Exception();
		}
		for (Map.Entry<Integer, Integer> entry : contents.entrySet()) {
			int itemID = entry.getKey();

			Item currItem = new Item(itemID);
			double itemPrice = currItem.getPrice();
			checkedOutPrices.put(itemID, itemPrice);
		}

		generateInvoice();
		checkedOut = true;
		update();
		return new Order(this);
	}

	public boolean addCoupon(String tryCoupon) throws Exception {
		if (checkedOut) {
			return false;
		}
		MysqlConnect mc = new MysqlConnect();
		ResultSet rs = mc.selectAllFrom( "Coupon");
		while(rs.next()){
			int couponID = rs.getInt("id");
			String code = rs.getString("code");
			double discount = rs.getDouble("discount");
			if (tryCoupon.equals(code)){
				coupon = new Coupon(couponID, code, discount);
				update();
				return true;
			}
		}
		coupon = null;
		System.out.println("The coupon is not right.");
		return false;
	}

	public String printCart() throws SQLException {
		if (checkedOut) {
			return null;
		}
		StringBuffer output = new StringBuffer();
		output.append("\nNow this cart has");
		if (contents.isEmpty()){
			output.append(" nothing in it.\n");
		}else{
			output.append(":\n");
		}
		for (Map.Entry<Integer, Integer> entry : contents.entrySet()) {
			int itemID = entry.getKey();
			Item currItem = new Item(itemID);
			double itemPrice = currItem.getPrice();
			output.append("Item: ");
			output.append(currItem.getName());
			output.append(", Quantity: ");
			output.append(entry.getValue());
			output.append(" @ $");
			output.append(priceFormat(itemPrice));
			output.append("\n");
		}
		if (coupon != null) {
			output.append("\nApplied Coupon: ");
			output.append(coupon.getCode());
		}
		if (!contents.isEmpty()){
			output.append("\nTotal Amount: $");
			output.append(priceFormat(calculateCost()));
//			output.append("\n");
			if (coupon != null){
				output.append("  (You Save: $");
				output.append(priceFormat(calculateTotalWithoutDiscount()-calculateCost()));
				output.append("!)");
//				output.append("\n");
			}
		}
		return output.toString();
	}

	private void generateInvoice() throws Exception {
		StringBuffer inv = new StringBuffer();
		double total = 0.0;
		inv.append("-----------------------------------------------------------------\n");
		inv.append("| INVOICE:\t\t\t\t\t\t\t|");
		inv.append("\n| \t\t\t\t\t\t\t\t|\n");
		inv.append("| Purchaser: ");
		inv.append(user.getName());
		inv.append("\t\t\t\t\t\t|");
		inv.append("\n| Shipping Address: \t\t\t\t\t\t|\n");
		inv.append("| "+user.getShippingAddress()+"\t\t\t|");
		inv.append("\n| \t\t\t\t\t\t\t\t|\n");
		inv.append("| Items Ordered: \t\t\t\t\t\t|\n");
		int entryCount = 0;
		for (Map.Entry<Integer, Integer> entry : contents.entrySet()) {
			entryCount += 1;
			int itemID = entry.getKey();
			int quantity = entry.getValue();
			double itemPrice = checkedOutPrices.get(itemID);
			StringBuffer inv2 = new StringBuffer();
			Item currItem = new Item(itemID);
			total += quantity * itemPrice;
			inv2.append("| Item: ");
			inv2.append(currItem.getName());
			inv2.append(", Quantity: ");
			inv2.append(entry.getValue());
			inv2.append(", Price: $");
			inv2.append(priceFormat(itemPrice));
			String inv2String = inv2.toString();
			int count = inv2String.length()/8;
			for(int i=1; i<(9-count); i++){
				inv2.append("\t");
			}
			if (entryCount != contents.size()){
				inv.append(inv2.toString()+"|\n");
			}else{
				inv.append(inv2.toString()+"|");
			}
		}
		inv.append("\n| \t\t\t\t\t\t\t\t|\n");
		if (coupon != null) {
			inv.append("| Applied Coupon: ");
			inv.append(coupon.getCode()+"\t\t\t\t\t|");
		}
		inv.append("\n| Total Amount: $");
		inv.append(priceFormat(getTotalAmount()));
		if (coupon != null){
			inv.append("  (WOW! You Just Saved: $");
			inv.append(priceFormat(calculateTotalWithoutDiscount()-calculateCost()));
			inv.append("!)\t|");
		}
		inv.append("\n| \t\t\t\t\t\t\t\t|\n");
		inv.append("| Billing Address: \t\t\t\t\t\t|\n");
		inv.append("| "+user.getBillingAddress()+"\t\t\t|\n");
		inv.append("| \t\t\t\t\t\t\t\t|\n");
		inv.append("| Card Used: \t\t\t\t\t\t\t|\n");
		inv.append("| "+user.getCreditNum()+"\t\t\t\t\t\t|\n");
		inv.append("-----------------------------------------------------------------\n");
		invoice = inv.toString();
		update();
	}
	
	public String viewInvoice() {
		if (!checkedOut) {
			return "";
		}
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
		} else {
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