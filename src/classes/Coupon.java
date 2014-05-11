package classes;


public class Coupon {
	private int id;
	private String code;
	private double discount;
	
	public Coupon(int id, String code, double discount){
		this.id = id;
		this.code = code;
		this.discount = discount;
	}

	public String getCode(){
		return code;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public int getID(){
		return id;
	}
}