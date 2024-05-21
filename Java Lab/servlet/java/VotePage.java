import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  

/**
 * Servlet implementation class RegistrationPage
 */
@WebServlet("/VotePage")
public class VotePage extends HttpServlet {
	public void doGet(HttpServletRequest req,  HttpServletResponse res)  
			  throws ServletException, IOException { 
			 
			    // Get print writer. 
			    PrintWriter out = res.getWriter(); 
			    res.setContentType("text/html"); 
				String fname=req.getParameter("fname");
				String lname=req.getParameter("lname");
				String email=req.getParameter("email");
				String dob[]=req.getParameter("date").split("-");
				String dnow[]=DateTimeFormatter.ofPattern("yyyy/MM/dd").format(LocalDateTime.now()).split("/");
				float y=Float.parseFloat(dnow[0])-Float.parseFloat(dob[0]);
				float m=Float.parseFloat(dnow[1])-Float.parseFloat(dob[1]);
				float d=Float.parseFloat(dnow[2])-Float.parseFloat(dob[2]);
				y=y+m/12.0F+d/365.F;
				if((int)y>=18)
				out.println("<html><body>"
				           +"<h1>Eligible to Vote</h1"
						   +"</body></html>");
				else
					out.println("<html><body>"
					           +"<h1>Not Eligible to Vote</h1"
							   +"</body></html>");
					
			  }	

}
