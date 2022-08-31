package userUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
	private static String url="jdbc:mysql://localhost:3306/user";
	private static String user = "root";
	private static String pass = "SHAma1m@";
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
		}
		catch(Exception e) {
			System.out.println("database connection is not success");			
		}
		return con;
	} 

}
