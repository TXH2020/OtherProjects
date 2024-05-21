

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookies
 */
@WebServlet("/Cookies")
public class Cookies extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie c1=new Cookie("no1","val1");
		Cookie c2=new Cookie("no2","val2");
		Cookie c3=new Cookie("no3","val3");
		Cookie c4=new Cookie("no4","val4");
		c1.setMaxAge(60);
		c2.setMaxAge(60);
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
		response.addCookie(c4);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		Cookie ck[]=request.getCookies();
		String s="<html><body><h1>Cookies</h1><br><br><p>Cookie Name&emsp;Value</p><br>";
		for(int i=0;i<ck.length;i++) 
			s=s+"<p>"+ck[i].getName()+"&emsp;"+ck[i].getValue()+"</p><br>";
		s=s+"</body></html>";
		out.println(s);
		out.close();
	}

	

}
