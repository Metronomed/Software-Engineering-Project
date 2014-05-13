package use_case;


import classes.*;

public class RemoveItemUseCase {
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
		testCart.addItem(snowboard.getID(), 1);
		System.out.println(testCart.printCart());
		printDivider();
		
		System.out.println("Right now it's summer, there is no reason to buy a "+snowboard.getName()+".\n");
		testCart.removeItem(snowboard.getID());
		printDivider();

		System.out.println(testCart.printCart());
		printDivider();
		
		System.out.println("Removing rest of items");
		testCart.removeItem(notebook.getID());
		testCart.removeItem(pen.getID());
		testCart.removeItem(usb.getID());
		System.out.println(testCart.printCart());
	}
	
	public static void printDivider(){
		System.out.println();
		System.out.println("===================================");
	}
}