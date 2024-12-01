import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SecondServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

try
{  PrintWriter out= resp.getWriter();
	HttpSession ses=req.getSession(false);
	String n=(String)ses.getAttribute("username");
	out.println("hello"+n);
}
catch(Exception e)
{
	System.out.println(e);
}

	}
}
