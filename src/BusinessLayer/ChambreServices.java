package BusinessLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import DataAccessLayer.Main;

public class ChambreServices {

	public static Connection getChambers() throws Exception
	{
		    String allQuery = "select * from chambre";
		    Connection conn = Main.getConnection();
		    Statement statement = conn.createStatement();
			ResultSet res = statement.executeQuery(allQuery);
			while(res.next())
			{	
				int id = res.getInt("id");
				System.out.print("Chamber number"+ id +"\n");
			}	
			return conn;
	}
	
}
