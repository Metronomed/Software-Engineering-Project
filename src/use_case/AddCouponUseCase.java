package use_case;

import classes.*;

public class AddCouponUseCase {
	public static void main(String[] args) throws Exception { 
		Item pen = new Item(1);
		Item kindle = new Item(2);
		Item keyboard = new Item(3);
		Item snowboard = new Item(4);
		Item usb = new Item(5);
		Item notebook = new Item(6);

		User testUser = new User(2);

		Cart testCart = new Cart(2);

		testCart.addItem(pen.getID(), 5);
		testCart.addItem(notebook.getID(), 1);
		testCart.addItem(usb.getID(), 20);
		System.out.println(testCart.printCart());
		printDivider();

		System.out.println("Trying to add coupon");
		testCart.addCoupon("DISCOUNT20");
		System.out.println(testCart.printCart());	
		printDivider();
		
		System.out.println("Trying to add another coupon");
		testCart.addCoupon("DISCOUNT50");
		System.out.println(testCart.printCart());	
		printDivider();
		
		System.out.println("This is the true 50% off coupon");
		testCart.addCoupon("HALFDAY");
		System.out.println(testCart.printCart());	
		printDivider();
		System.out.println();
		System.out.println("Only one coupon effects.");
	}
	
	public static void printDivider(){
		System.out.println();
		System.out.println("===================================");
	}
}