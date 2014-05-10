package classes;

import java.sql.ResultSet;
import java.sql.SQLException;

import lib.MysqlConnect;

public class User {
	public int id;
	public String name;
	private String emailAddress, billingAddress, shippingAddress;
	private String creditNum;

	public User(int id) throws SQLException {
		//pull from the database
		MysqlConnect mc = new MysqlConnect();
		ResultSet rs = mc.SelectFromId(id, "User");
		
		if (rs.next()){
	        name = rs.getString("name");
	        setEmailAddress(rs.getString("emailAdd"));
	        setBillingAddress(rs.getString("billingAdd"));
	        setShippingAddress(rs.getString("shippingAdd"));
	        setCreditNum(rs.getString("creditNum"));
		}
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getCreditNum() {
		return creditNum;
	}

	public void setCreditNum(String creditNum) {
		this.creditNum = creditNum;
	}


}