package use_case;
import java.sql.SQLException;

import lib.MysqlConnect;

import classes.*;

public class CheckoutUseCase {
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
		testCart.addItem(keyboard.getID(), 1);
		testCart.addItem(usb.getID(), 20);
		printDivider();

		System.out.println(testCart.addCoupon("DISCOUNT20"));
		System.out.println(testCart.printCart());
		printDivider();

		System.out.println("System checking out...\n");
		Order myOrder = testCart.checkout();
		System.out.println(myOrder.viewInvoice());
		printDivider();
	}
	
	public static void printDivider(){
		System.out.println();
		System.out.println("===================================");
	}
}