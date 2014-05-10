public class Coupon {
	int ID;
	String code;
	double discount;

	public Coupon(String code) {
		this.code = code;
	}

	public boolean isValid() {
		//connect to database to check?, set 
		discount = 0.8;
		return true;
	}

	public double getDiscount() {
		return discount;
	}
}