public class Coupon {
	int ID;
	String code;
	double discount;

	public boolean isValid() {
		//connect to database to check?
		return true;
	}

	public double getDiscount() {
		return discount;
	}
}