package lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConnect {
	Connection conn = null;
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
	
	
	public ResultSet SelectFromId(int id, String table){
		
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









