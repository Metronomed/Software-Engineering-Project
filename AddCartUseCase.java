public class AddCartUseCase {
	public static void main(String[] args) {
		Item testItem = new Item(0);
		User testUser = new User(0);
		Cart testCart = new Cart(0);

		//test adding item
		System.out.println(testItem.viewItem());
		boolean success = testCart.addItem(0, 15);
		if (success) {
			System.out.println("Added item");
			System.out.println(testCart.viewCart());
			System.out.println("Cost: $" + testCart.calculateCost());
		}

		//test removing item
		success = testCart.removeItem(0);
		if (success) {
			System.out.println("Removed item");
			System.out.println(testCart.viewCart());
			System.out.println("Cost: $" + testCart.calculateCost());
		}

		//test changing item quantity
		testCart.addItem(0, 15);
		System.out.println(testCart.viewCart());
		System.out.println("Cost: $" + testCart.calculateCost());
		success = testCart.changeQuantity(0, 12);
		if (success) {
			System.out.println("Changed quantity");
			System.out.println(testCart.viewCart());
			System.out.println("Cost: $" + testCart.calculateCost());
		}
		
		//test adding coupon
		String discountName = "DISCOUNT20";
		Coupon coupon = new Coupon(discountName);
		success = testCart.addCoupon(coupon);
		if (success) {
			System.out.println("Added coupon" + discountName);
			System.out.println(testCart.viewCart());
			System.out.println("Cost: $" + testCart.calculateCost());
		}

		//test check out


		//test viewing invoice

	}
}