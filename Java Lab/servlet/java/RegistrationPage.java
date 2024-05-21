import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class RegistrationPage
 */
@WebServlet("/RegistrationPage")
public class RegistrationPage extends HttpServlet {
	public void doGet(HttpServletRequest req,  HttpServletResponse res)  
			  throws ServletException, IOException { 
			 
			    // Get print writer. 
			    PrintWriter out = res.getWriter(); 
			    res.setContentType("text/html"); 
				String name=req.getParameter("NAME");
				boolean c1=true,c2=true,c3=true;
				for(int i=0;i<name.length();i++) {
					char c=name.charAt(i);
					if(c=='@' || c=='#' || c=='$' || c=='*') {
						c1=false;
						break;
					}
				}
				String pass=req.getParameter("password");
				String cpass=req.getParameter("conpassword");
				if(pass.length()<8)
					c2=false;
				if(!pass.equals(cpass))
					c3=false;
				if(c1 && c2 && c3)
				out.println("<html><body>"
				           +"<h1>Hello " +name+ " Welcome ...."
						   +"</body></html>");
				else
					out.println("<html><body>"
					           +"<h1>Invalid username/password"
							   +"</body></html>");
			  }	

}
