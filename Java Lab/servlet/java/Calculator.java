import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */
@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	public void doPost(HttpServletRequest req,  HttpServletResponse res)  
			  throws ServletException, IOException { 
		PrintWriter out = res.getWriter(); 
		res.setContentType("text/html");
			try {
			 double no1=Double.parseDouble(req.getParameter("no1"));
			 double no2=Double.parseDouble(req.getParameter("no2"));
			 String val=req.getParameter("Calculation");
			 double result=0.0;
			 if(val.equals("add"))
				 result=no1+no2;
			 else if(val.equals("subtract"))
				 result=no1-no2;
			 else if(val.equals("multiply"))
				 result=no1*no2;
			 else if(val.equals("divide")) 
			 		result=no1/no2;
			 else
				 result=Math.exp(no1);
			 if(result==Double.NEGATIVE_INFINITY || result==Double.POSITIVE_INFINITY)
			 out.println("<html><body>"
			           +"<h1>Second number cannot be zero</h1>"
					   +"</body></html>");
			 else {
				 out.println("<html><body>"
				           +"<h1>Result="+result+"</h1>"
						   +"</body></html>");}
			  }	
			catch(Exception e) {
				out.println("<html><body>"
				           +"<h1>Please enter numbers/operation</h1>"
						   +"</body></html>");
			}}
			
}
