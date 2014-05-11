package lib;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import classes.Cart;

public class MysqlConnect {
	static Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
	
	public MysqlConnect(){
		String url = "jdbc:mysql://localhost:3306/shoppingcart";
	    try {
			Class.forName ("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection (url,"root","");
			stmt = conn.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ResultSet selectFromId(int id, String table){
		
        String sql;
        sql = "SELECT * FROM "+table+" WHERE id = '" + id +"'";
        ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return rs;
	}
	
	public boolean insert(Object object) throws Exception{
		if(object.getClass().getName() == "classes.Cart"){
			
			for (Field field : object.getClass().getDeclaredFields()) {
			    field.setAccessible(true);
			    String name = field.getName();
			    Object value = field.get(object);
			    System.out.printf("Field name: %s, Field value: %s%n", name, value);
			}
			
			return true;
		}else if(object.getClass().getName() == "classes.Order"){
			
			return true;
		}else{
			
			return false;
		}
	}
	
	public static int insertCart(int userID) throws Exception{
		PreparedStatement pst = null;
		pst = conn.prepareStatement("INSERT INTO Cart(userID, content, invoice)" +
				" VALUES(?, ?, ?)");
		pst.setInt(1, userID);
		pst.setString(2, "");
		pst.setString(3, "");
		pst.executeUpdate();
		
		Statement stmt = null;
		ResultSet rs = null;
		stmt = conn.createStatement();
        String sql;
        sql = "SELECT MAX(id) FROM Cart";
        rs = stmt.executeQuery(sql);
        
        rs.next();
        return rs.getInt("MAX(id)");
	}
	
	public static void updateCart(Cart cart) throws Exception{
		PreparedStatement pst = null;
		pst = conn.prepareStatement("UPDATE Cart SET contents=?, couponID=?" +
				"checkedOut=?, nvoice=? WHERE id=?");
        pst.setString(1, cart.getContents());
        pst.setInt(2, cart.getCouponID());
        pst.setInt(3, cart.isCheckedOut());
        pst.setString(4, cart.viewInvoice());
        pst.setInt(5, cart.getID());
	}
	
	public static void main(String[] args){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		int id = 1;
		String sql;
        sql = "SELECT * FROM User WHERE id = '" + id +"'";
		try {
			String url = "jdbc:mysql://localhost:3306/shoppingcart";
            Class.forName ("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection (url,"root","");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
	               //Retrieve by column name
//	               int id  = rs.getInt("id");
	               String name = rs.getString("name");
	               String description = rs.getString("emailAdd");
//	               float price = rs.getFloat("price");

	               //Display values
//	               System.out.print("ID: " + id);
	               System.out.print(", name: " + name);
	               System.out.print(", description: " + description);
//	               System.out.println(", price: " + price);
	            }
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}









