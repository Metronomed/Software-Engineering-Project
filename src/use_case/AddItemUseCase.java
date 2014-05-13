package use_case;

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
		System.out.println(testUser.getName()+" has logged in the website...");
		printDivider();

		Cart testCart = new Cart(2);
		System.out.println(testUser.getName()+" is browsing the first page of this website.\n");

		System.out.println(pen.printDescriptor());
		System.out.println(notebook.printDescriptor());
		System.out.println(usb.printDescriptor());
		System.out.println(snowboard.printDescriptor());
		printDivider();
		
		System.out.println(testCart.printCart());
		printDivider();
		
		testCart.addItem(pen.getID(), 5);
		System.out.println(testCart.printCart());
		printDivider();

		System.out.println("Adding more items");
		testCart.addItem(notebook.getID(), 1);
		testCart.addItem(usb.getID(), 20);
		testCart.addItem(snowboard.getID(), 1);
		printDivider();
		
		System.out.println("\n"+testUser.getName()+" is browsing the second page of this website");
		System.out.println();
		System.out.println(kindle.printDescriptor());
		System.out.println(keyboard.printDescriptor());
		System.out.println("But nothing interests "+ testUser.getName());
		printDivider();

		System.out.println(testCart.printCart());
	}
	
	public static void printDivider(){
		System.out.println();
		System.out.println("===================================");
	}
}