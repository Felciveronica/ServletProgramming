import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import jakarta.servlet.http.HttpServlet;

public class Database  extends HttpServlet{
    public static Connection dbconnect()
    {
    	Connection con=null;
    	String dbname="jdbc:postgresql://localhost:5432/login";
    	String dbdriver= "org.postgresql.Driver";
    	String user="postgres";
    	String pass="felcipass";
    	
    	try
    	{
    	Class.forName(dbdriver);
    	con=DriverManager.getConnection(dbname,user,pass);
    	
    	
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return con;
    	
    }
}
