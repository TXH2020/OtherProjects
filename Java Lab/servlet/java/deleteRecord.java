

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
@WebServlet("/deleteRecord")
public class deleteRecord extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
	    response.setContentType("text/html"); 
	    int flag=0;
		int id=0;
	    try {
		id=Integer.parseInt(request.getParameter("id"));}
		catch(Exception e) {
			flag=1;
		}
		if(flag==1)
			out.println("<p>You have entered no values/invalid value. "
					+ "Kindly enter correct values for all fields</p>");
		else {
			Connection conn = null;
		    String url = "jdbc:mysql://localhost:3306/"; 
		    String dbName = "Library"; 
		    String driver = "com.mysql.jdbc.Driver"; 
		    String user = "root";  
		    String password = "";
		    try { 
		        Class.forName(driver).getDeclaredConstructor().newInstance(); 
		        conn = DriverManager.getConnection(url+dbName, user, password);
		        String query = "delete from library where ID=?";
		        PreparedStatement ps=conn.prepareStatement(query);
		        ps.setInt(1,id);
		        int i=ps.executeUpdate();
		        if(i>0)
		        out.println("Successfully deleted record with the ID:"+id+"<br>");
		        else 
		    	out.println("Book with id does not exist");}
		    
		    catch(Exception e ) {
		    out.println("Sorry we have encountered an error:"+e);}
	}

}}
