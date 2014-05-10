public class Item {
	int ID;
	String name;
	String description;
	double price;
	public Item(int id) {
		//pull from database?
	}

	public double getPrice() {
		return price;
	}

	public String viewItem() {
		String view = "Item name: " + name + "\n";
		view = view + "Description: " + description + "\n";
		view = view + "Price: $" + Double.toString(price);
		return view;
	}
}