package use_case;
import java.sql.SQLException;

import lib.MysqlConnect;

import classes.*;

public class ChangeQuantityUseCase {
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
		
		System.out.println(testUser.getName()+" feel like he don't need that many of "+usb.getName()+".\n");
		testCart.changeQuantity(usb.getID(), 10);
		System.out.println(testCart.printCart());
		printDivider();

		
		System.out.println("Change more quantities (notebook = 0)");
		testCart.changeQuantity(notebook.getID(), 0);
		testCart.changeQuantity(pen.getID(), 5);
		System.out.println(testCart.printCart());
	}
	
	public static void printDivider(){
		System.out.println();
		System.out.println("===================================");
	}
}