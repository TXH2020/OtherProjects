import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.sql.Date;
import java.text.DateFormat;

@WebServlet("/SubjectDB")
public class SubjectDB extends HttpServlet {
  public void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {
	  response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter(); 
	    Connection conn = null;
	    String url = "jdbc:mysql://localhost:3306/"; 
	    String dbName = "Subject1"; 
	    String driver = "com.mysql.jdbc.Driver"; 
	    String user = "root";  
	    String password = "";
	    String olds = request.getParameter("old");
	    String news = request.getParameter("new");
	    try { 
	        Class.forName(driver).getDeclaredConstructor().newInstance(); 
	        conn = DriverManager.getConnection(url+dbName, user, password);
			String query1="update subject set Sub_Name='"+news+"' where Sub_Name='"+olds+"'";
	        PreparedStatement ps1=conn.prepareStatement(query1);
	        int no=ps1.executeUpdate();
	        out.println("No. of rows updated="+no);
	    } catch (Exception e) { 
	    	System.out.println("ERROR"+e);
  	 	        out.close(); }
	    }
  		protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
  		{
  			doGet(request,response);
  		}
  }