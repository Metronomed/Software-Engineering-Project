package classes;
public class Order {
	int ID;
	Cart cart;
	String trackingNumber;

	public Order(Cart cart) {
		this.cart = cart;
		int trackNumLength = 10;
		String validChars = "ABCDEFGHIJKLMNOPQRSTUVQXYZ0123456789";
		StringBuffer tn = new StringBuffer();
		int charLength = validChars.length();
		for (int i = 0; i < trackNumLength; i++) {
			int index = (int) (Math.random() * charLength);
			tn.append(validChars.charAt(index));
		}
		trackingNumber = tn.toString();
	}

	public String viewInvoice() {
		return cart.viewInvoice() + "\nTracking Number: " + trackingNumber + "\n";
	}
}