import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class Filter implements jakarta.servlet.Filter {
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String pass = arg0.getParameter("password");
		
		if(pass.equals("123"))
		{
			arg2.doFilter(arg0, arg1);
		}
		else
		{
			PrintWriter out=arg1.getWriter();
			out.println("password wrong");
		}
		
	}

}
