package use_case;
import java.sql.SQLException;

import lib.MysqlConnect;

import classes.Item;
import classes.User;
import classes.Cart;


public class UseCase1 {
	public static void main(String[] args) throws Exception{
		//Put items into cart
		Item item_3 = new Item(3);
		
		System.out.print("ID: " + item_3.getID());
        System.out.print(", name: " + item_3.getName());
        System.out.print(", description: " + item_3.getDescription());
        System.out.println(", price: " + item_3.getPrice());
        
        User user_1 = new User(1);
        
        System.out.print("ID: " + user_1.id);
        System.out.print(", name: " + user_1.name);
        System.out.print(", Billing Address: " + user_1.getBillingAddress());
        System.out.println(", credit: " + user_1.getCreditNum());
        
        Cart cart_1 = new Cart(user_1.id);
        System.out.print("Cart ID: " + cart_1.id);
//        MysqlConnect mc = new MysqlConnect();
//        mc.insert(cart_1);
	}
}
