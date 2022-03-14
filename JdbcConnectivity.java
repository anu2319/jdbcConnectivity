package jdbc.demo;
import java.sql.*;

public class JdbcConnectivity 
{
	public static void main(String[] args)  throws Exception
	{
		 String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
	     String USERNAME = "root";
	     String PASSWORD = "root";
	     String query = "select id,name,category,price,active from product";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String category = rs.getString("category");
			long price = rs.getLong("price");
			String active = rs.getString("active");
			System.out.println("ID:"+id);
			System.out.println("Name:"+name);
			System.out.println("Category:"+category);
			System.out.println("Price:"+price);
			System.out.println("active:"+active);
			
		}
		
		st.close();
		con.close();
	}
}
