

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExtInitials")
public class ExtInitials extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String res="";
		try {
		String names[]=name.split(" ");
		for(String w:names) 
			res+=Character.toUpperCase(w.charAt(0));}
		catch(Exception e) {
			res+="Please enter single space beteen words";
		}
		PrintWriter out = response.getWriter(); 
	    response.setContentType("text/html");
	    out.println("<html><body>"
		           +"<h1>Extracted initials are:</h1><br>"
				   +res+"<br>"
		           +"</body></html>");
		
	}

}
