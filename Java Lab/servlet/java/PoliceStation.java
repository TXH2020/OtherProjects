

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/PoliceStation")
public class PoliceStation extends HttpServlet {
  public void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {
	  response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter(); 
	    Connection conn = null;
	    String url = "jdbc:mysql://localhost:3306/"; 
	    String dbName = "Police"; 
	    String driver = "com.mysql.jdbc.Driver"; 
	    String user = "root";  
	    String password = "";
	    String area= request.getParameter("area");
	    String phone = request.getParameter("phone");
	    try { 
	        Class.forName(driver).getDeclaredConstructor().newInstance(); 
	        conn = DriverManager.getConnection(url+dbName, user, password);
			String query = "SELECT * FROM police where Area = ? or Phone = ?";
	        PreparedStatement ps=conn.prepareStatement(query);
	        ps.setString(1,area);
	        ps.setString(2,phone);
			ResultSet rs = ps.executeQuery();
	        if(rs != null) {
	        	String s="";
	        	while(rs.next()) {
	        		s+=rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"<br>";
	        	}
	        	out.println("<html><body>"+"Police Station Details<br>"+s+"<br></body></html>");}
	        else
	        	out.println("<html><body>"+"Police Station with entered details doesnt exist"+"</body></html>");
	         
	    } catch (Exception e) { 
	    	System.out.println("ERROR"+e);
  	 	        out.close(); }
	    }
  }