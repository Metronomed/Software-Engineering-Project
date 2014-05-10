public class Order {
	int ID;
	Cart cart;
	String trackingNumber;

	public Order(Cart cart) {
		this.cart = cart;
		trackingNumber = "HELPME";
	}

	public String viewInvoice() {
		return cart.generateInvoice();
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}
}