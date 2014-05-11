package classes;

import java.sql.Time;
import java.sql.Timestamp;

import lib.MysqlConnect;

public class Order {
	int id;
	Cart cart;
	String trackingNum;
	String orderstamp;

	public Order(Cart cart) throws Exception {
		this.cart = cart;
		int trackNumLength = 10;
		String validChars = "ABCDEFGHIJKLMNOPQRSTUVQXYZ0123456789";
		StringBuffer tn = new StringBuffer();
		int charLength = validChars.length();
		for (int i = 0; i < trackNumLength; i++) {
			int index = (int) (Math.random() * charLength);
			tn.append(validChars.charAt(index));
		}
		trackingNum = tn.toString();
		
		java.util.Date date= new java.util.Date();
		Timestamp timestamp =  new Timestamp(date.getTime());
		orderstamp = timestamp.toString();
		System.out.println("//////");
		System.out.println(orderstamp);
		
		id = MysqlConnect.insertOrder(cart.getID(), trackingNum, orderstamp);
		System.out.println("//////");
		System.out.println(id);
	}

	public String viewInvoice() {
		return cart.viewInvoice() + "\nTracking Number: " + trackingNum + "\n";
	}
}