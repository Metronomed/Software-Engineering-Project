import java.sql.*;

public class connect {
	
	public static void main(String[] args)
	   {
	       Connection conn = null;

	       try
	       {

	           String url = "jdbc:mysql://localhost:3306/shoppingcart";
	           Class.forName ("com.mysql.jdbc.Driver");
	           conn = DriverManager.getConnection (url,"root","");
	           System.out.println ("Database connection established");
	       }
	       catch (Exception e)
	       {
	           e.printStackTrace();

	       }
	       finally
	       {
	           if (conn != null)
	           {
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
