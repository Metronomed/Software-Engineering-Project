import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class test_connect {
	

	public static void main(String[] args){
       Connection conn = null;
       Statement stmt = null;
       ResultSet rs = null;
       PreparedStatement pst = null;
       
       try{
           String url = "jdbc:mysql://localhost:3306/shoppingcart";
           Class.forName ("com.mysql.jdbc.Driver");
           conn = DriverManager.getConnection (url,"root","");
           System.out.println ("Database connection established");
           
           //Execute a SELECT query
           stmt = conn.createStatement();
           String sql;
           sql = "SELECT id, name, description, price FROM Item";
           rs = stmt.executeQuery(sql);
           
           while(rs.next()){
               //Retrieve by column name
               int id  = rs.getInt("id");
               String name = rs.getString("name");
               String description = rs.getString("description");
               float price = rs.getFloat("price");

               //Display values
               System.out.print("ID: " + id);
               System.out.print(", name: " + name);
               System.out.print(", description: " + description);
               System.out.println(", price: " + price);
            }
           
           //Execute a INSERT query
           String new_name = "Notebood";
           String new_description = "This is a macbooc";
           float new_price = 1399;
           
           pst = conn.prepareStatement("INSERT INTO Item(name, description, price) VALUES(?, ?, ?)");
           pst.setString(1, new_name);
           pst.setString(2, new_description);
           pst.setFloat(3, new_price);
           pst.executeUpdate();
           
         //Clean-up environment
           rs.close();
           stmt.close();
           conn.close();
           
       }
       catch (Exception e){
           e.printStackTrace();

       }
       finally{
           if (conn != null){
               try
               {
                   conn.close ();
                   System.out.println ("Database connection terminated");
               }
               catch (Exception e) { /* ignore close errors */ }
           }
       }
       
	}
}
