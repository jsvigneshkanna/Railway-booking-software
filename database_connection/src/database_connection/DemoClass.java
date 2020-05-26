package database_connection;

import java.sql.*;



/**
 * Created by js Vignesh Kanna
 * 11:19:39 AM :: Aug 12, 2019
 * DemoClass.java
 * database_connection
**/

public class DemoClass {

	public static void main(String[] args) throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/vk2db";   //format for URL is "jdbc:mysql:database-name"    jdbc:mysql://127.0.0.1:3306/?user=root
		String username = "root";
		String password = "rishitaran";
		String query = "select * from vk1";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		
		Statement st = con.createStatement();
		ResultSet rs =  st.executeQuery(query);
		
		rs.next();
		String name = rs.getString("cat1");
		
		System.out.println(name);
		
		st.close();
		con.close();
		
		

	}

}
