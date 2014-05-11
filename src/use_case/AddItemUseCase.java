package use_case;
import java.sql.SQLException;

import lib.MysqlConnect;

import classes.*;

public class AddItemUseCase {
	public static void main(String[] args) throws Exception { 
		Item pen = new Item(1);
		Item kindle = new Item(2);
		Item keyboard = new Item(3);
		Item snowboard = new Item(4);
		Item usb = new Item(5);
		Item notebook = new Item(6);

		User testUser = new User(2);

		Cart testCart = new Cart(2);

		System.out.println(pen.printDescriptor());
		System.out.println(notebook.printDescriptor());
		System.out.println(usb.printDescriptor());
		System.out.println(testCart.printCart());
		
		System.out.println("Adding an item with quantity");
		testCart.addItem(pen.getID(), 5);
		System.out.println(testCart.printCart());

		System.out.println("Adding more items");
		testCart.addItem(notebook.getID(), 1);
		testCart.addItem(usb.getID(), 20);

		System.out.println(testCart.printCart());
	}
}