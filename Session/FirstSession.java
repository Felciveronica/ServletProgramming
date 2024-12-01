import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class FirstSession extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
		PrintWriter out = resp.getWriter();
		String s=req.getParameter("user");
		out.println("welcome"+s);
		HttpSession ses= req.getSession();
		ses.setAttribute("username","felci");
		out.println("<a href='Servlet2'>click here</a>");
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
