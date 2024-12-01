import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONObject;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class FirstFilter implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		PrintWriter out= arg1.getWriter();
		HttpServletRequest req =(HttpServletRequest)arg0;
		HttpSession ses=req.getSession(false);
		String ur=req.getContextPath()+"/login";
		boolean logedin= ses!=null&& ses.getAttribute("user")!=null;
		boolean logedurl= req.getRequestURI().equals(ur);
		if(logedin || logedurl)
		{
			arg2.doFilter(arg0, arg1);
		
		}
		else
		{
			JSONObject ob= new JSONObject();
			ob.put("status","failed");
			out.println(ob.toString());
		}
		
	}
}
