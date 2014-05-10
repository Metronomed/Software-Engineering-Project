package classes;
public class Order {
	int ID;
	Cart cart;
	String trackingNumber;

	public Order(Cart cart) {
		this.cart = cart;
	}

	public String viewInvoice() {
		return cart.generateInvoice();
	}
}