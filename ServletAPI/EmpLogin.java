import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EmpLogin extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Database db = new Database();
		
		boolean logedin=false;
		
		String user= req.getParameter("user");
		String pass= req.getParameter("pass");
		HttpSession ses= req.getSession();
		
		PrintWriter out= resp.getWriter();
		
		try
		{
			Connection con = Database.dbconnect();
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery("select * from usert");
			
			while(rs.next())
			{
				if(user.equals(rs.getString("uname")) && pass.equals(rs.getString("pass")))
				{
					JSONObject row= new JSONObject();
					ses.setAttribute("user",user );
					row.put("status","sucess");
					logedin=true;
					out.println(row.toString());
				}
				
			}
			if(logedin== false)
			{
				JSONObject ob= new JSONObject();
				ob.put("status","failed");
				out.println(ob.toString());
			}
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
	}

}
