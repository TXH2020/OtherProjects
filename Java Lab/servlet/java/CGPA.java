import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class RegistrationPage
 */
@WebServlet("/CGPA")
public class CGPA extends HttpServlet {
	public void doPost(HttpServletRequest req,  HttpServletResponse res)  
			  throws ServletException, IOException { 
			 
			    // Get print writer. 
			    PrintWriter out = res.getWriter(); 
			    res.setContentType("text/html"); 
				String name=req.getParameter("name");
				String usn=req.getParameter("usn");
				String sem[]=req.getParameter("marks").split(",");
				float cgpa;
				float sum=0;
				for(int i=0;i<sem.length;i++)
					sum=sum+Float.parseFloat(sem[i]);
				cgpa=sum/sem.length;
				out.println("<html><body>"
				           +"<h1>Student Details</h1>"
				           +"Name:"+name+"<br>"
				           +"USN:"+usn+"<br>"
				           +"CGPA:"+cgpa+"<br>"
						   +"</body></html>");
			  }	

}
