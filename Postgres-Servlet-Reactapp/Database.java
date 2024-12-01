import java.sql.Connection;
import java.sql.DriverManager;

public class Database  {
	
	public static Connection dbconnect()
	{
		String dbname="jdbc:postgresql://localhost:5432/UserManagement";
		String dbdriver="org.postgresql.Driver";
		String user="postgres";
		String pass="felcipass";
		Connection con =null;
		
		try
		{  Class.forName(dbdriver);
			con=DriverManager.getConnection(dbname,user,pass);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
		
	}

}
