package classes;

import java.sql.ResultSet;
import java.sql.SQLException;

import lib.MysqlConnect;

public class User {
	public int id;
	public String name;
	private String emailAdd, billingAdd, shippingAdd;
	private String creditNum;

	public User(int id) throws SQLException {
		this.id = id;
		//pull from the database
		MysqlConnect mc = new MysqlConnect();
		ResultSet rs = mc.selectFromId(id, "User");
		
		if (rs.next()){
	        name = rs.getString("name");
	        setEmailAddress(rs.getString("emailAdd"));
	        setBillingAddress(rs.getString("billingAdd"));
	        setShippingAddress(rs.getString("shippingAdd"));
	        setCreditNum(rs.getString("creditNum"));
		}
	}

	public String getEmailAddress() {
		return emailAdd;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAdd = emailAddress;
	}

	public String getBillingAddress() {
		return billingAdd;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAdd = billingAddress;
	}

	public String getShippingAddress() {
		return shippingAdd;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAdd = shippingAddress;
	}

	public String getCreditNum() {
		return creditNum;
	}

	public void setCreditNum(String creditNum) {
		this.creditNum = creditNum;
	}


}