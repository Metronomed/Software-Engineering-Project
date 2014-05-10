package classes;

import java.sql.ResultSet;
import java.sql.SQLException;

import lib.MysqlConnect;

public class Item {
	public int id;
	public String name;
	public String description;
	public double price;
	
	public Item(int id) throws SQLException {
		//pull from database
		MysqlConnect mc = new MysqlConnect();
		ResultSet rs = mc.SelectFromId(id, "Item");
        
		if (rs.next()){
	        name = rs.getString("name");
	        description = rs.getString("description");
	        price = rs.getFloat("price");
		}
        rs.close();
//        conn.close();
	}

	public double getPrice() {
		return price;
	}
}