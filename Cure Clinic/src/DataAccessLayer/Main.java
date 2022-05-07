package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		getConnection();
		
	}

	public static Connection getConnection() throws Exception 
	{
		try
		{
			String driver = "com.mysql.cj.jdbc.Driver";
			String url ="jdbc:mysql://localhost:3306/test";
			String userName ="root";
			String password = "";
			Class.forName(driver);
			
			String allQuery = "select * from Patient";
			
			Connection conn = DriverManager.getConnection(url,userName,password);
			Statement statement = conn.createStatement();
			ResultSet res = statement.executeQuery(allQuery);
			int count = 0;
			while(res.next())
			{	
				String firstName = res.getString("firstName");
				count++;
				System.out.print("Patient number"+ count +"'s name is: "+ firstName+"\n");
			}
			System.out.print("connected");
			return conn;
		}
		catch (Exception e) {System.out.println(e);}
		return null;
	}
	
}
