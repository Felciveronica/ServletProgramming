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

public class Login  extends HttpServlet{
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String user=req.getParameter("user");
	String pass= req.getParameter("pass");
	
	HttpSession ses= req.getSession();
	
	resp.addHeader("Access-Control-Allow-Orgin", "*");
	PrintWriter out=resp.getWriter();
	
	boolean logedin= false;
	Statement  st=null;
	
	try
	{
		Connection con= Database.dbconnect();
		st=con.createStatement();
		ResultSet rs= st.executeQuery("Select * from userdata");
		
		while(rs.next())
		{
			String uname=rs.getString("uname");
			String password=rs.getString("pass");
			if(uname.equals(user) && password.equals(pass))
			{
				ses.setAttribute("user", uname);
				ses.setAttribute("pass", password);
				JSONObject ob= new JSONObject();
				
				ob.put("status","success");
				
				out.println(ob.toString());
				logedin=true;
				break;
			}
			
		}
		if(logedin==false)
		{
			JSONObject ob=new JSONObject();
			ob.put("status","failed");
			out.println(ob.toString());
		}
	}
		catch(Exception e)
		{
			JSONObject ob=new JSONObject();
			ob.put("status","failed");
			ob.put("Exception",e);
			out.println(ob.toString());
		}
		
	
	
}
}
