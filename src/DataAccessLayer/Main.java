package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		BusinessLayer.ChambreServices.getChambers();
	}

	public static Connection getConnection() throws Exception 
	{
			String driver = "com.mysql.cj.jdbc.Driver";
			String url ="jdbc:mysql://localhost:3306/cure_clinic";
			String userName ="root";
			String password = "";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,userName,password);
			System.out.print("connected\n");
			return conn;
		
	}

}
