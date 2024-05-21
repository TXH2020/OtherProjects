import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/JDBCServlet")
public class JDBCServlet extends HttpServlet {
  public void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {
	  response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter(); 
	    Connection conn = null;
	    String url = "jdbc:mysql://localhost:3306/"; 
	    String dbName = "User"; 
	    String driver = "com.mysql.jdbc.Driver"; 
	    String user = "root";  
	    String password = "";
	    String user1 = request.getParameter("user1");
	    String pass = request.getParameter("pass");
	    try { 
	        Class.forName(driver).getDeclaredConstructor().newInstance(); 
	        conn = DriverManager.getConnection(url+dbName, user, password);
			String query = "SELECT * FROM user where ID = ? and Password = ?";
	        PreparedStatement ps=conn.prepareStatement(query);
	        ps.setString(1,user1);
	        ps.setString(2,pass);
			ResultSet rs = ps.executeQuery();
	        if(rs != null)
	        	out.println("<html><body>"+"Valid user"+"</body></html>");
	        else
	        	out.println("<html><body>"+"Invalid user"+"</body></html>");
	         
	    } catch (Exception e) { 
	    	System.out.println("ERROR"+e);
  	 	        out.close(); }
	    }
  		protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
  		{
  			doGet(request,response);
  		}
  }