package classes;

import java.sql.ResultSet;
import java.sql.SQLException;

import lib.MysqlConnect;
import java.text.DecimalFormat;

public class Item {
	private int id;
	private String name;
	private String description;
	private double price;
	
	public Item(int id) throws SQLException {
		//pull from database
		this.id = id;
		MysqlConnect mc = new MysqlConnect();
		ResultSet rs = mc.selectFromId(id, "Item");
        
		if (rs.next()){
	        name = rs.getString("name");
	        description = rs.getString("description");
	        price = rs.getFloat("price");
		}
        rs.close();
//        conn.close();
	}

	private String priceFormat(double price) {
		DecimalFormat df = new DecimalFormat("##.00");
		return df.format(price);
	}

	public String printDescriptor() {
		StringBuffer output = new StringBuffer();
		output.append("Name: ");
		output.append(name);
		output.append("\nDescription: ");
		output.append(description);
		output.append("\nPrice: $");
		output.append(priceFormat(price));
		output.append("\n");
		return output.toString();
	}

	public double getPrice() {
		return price;
	}

	public int getID() {
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
}