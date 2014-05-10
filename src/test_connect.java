import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class test_connect {
	

	public static void main(String[] args){
       Connection conn = null;
       Statement stmt = null;
       ResultSet rs = null;
       
       try{
           String url = "jdbc:mysql://localhost:3306/shoppingcart";
           Class.forName ("com.mysql.jdbc.Driver");
           conn = DriverManager.getConnection (url,"root","");
           System.out.println ("Database connection established");
           
           //Execute a query
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
