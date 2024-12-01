import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewEmployee  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   PrintWriter out = resp.getWriter();
	   
	    JSONArray arr = new JSONArray();  // entire json data
	   
	    
		String dbname="jdbc:postgresql://localhost:5432/login";
		String dbdriver = "org.postgresql.Driver";
		String username="postgres";
		String password="felcipass";
		
		try
		{
			Class.forName(dbdriver);
			Connection con = DriverManager.getConnection(dbname,username,password);
			Statement st= con.createStatement();
			String sql= "select * from emp";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next())
			{   JSONObject obj = new JSONObject(); //depict row
				obj.put("empid ", rs.getInt("empid"));
				obj.put("name ",rs.getString("empname"));
				obj.put("email ", rs.getString("email"));
				
				arr.put(obj);
				
				
				
				//out.printf("id=%d    name= %s   email=%s\n",rs.getInt("empid"),rs.getString("empname"), rs.getString("email"));
			}
			out.println(arr);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
