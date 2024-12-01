
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ReadUser extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out= resp.getWriter();
		
		try
		{
			Connection con = Database.dbconnect();
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery("select * from usert");
			JSONArray arr= new JSONArray();
			while(rs.next())
			{
			
					JSONObject row= new JSONObject();
					row.put("uid",rs.getInt("uid") );
					row.put("user",rs.getString("user") );
					row.put("pass",rs.getString("pass") );
					
					arr.put(row);
				out.println(arr);
			}
			
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
	}

}