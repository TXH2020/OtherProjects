

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
@WebServlet("/displayRecord")
public class displayRecord extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
	    response.setContentType("text/html"); 
	    int empty=0;
	    int flag=0;
		int id=0;
	    try {
		id=Integer.parseInt(request.getParameter("id"));}
		catch(Exception e) {
			empty=1;
		}
		String name=request.getParameter("name");
		if(name.equals("") )
			flag=1;
		if(flag==1 && empty==1)
			out.println("<p>You have entered no values/invalid value. ");
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
		        String query = "select * from library where ID=? or Name=?";
		        PreparedStatement ps=conn.prepareStatement(query);
		        ps.setInt(1,id);
		        ps.setString(2, name);
		        ResultSet rs=ps.executeQuery();
		        try {
		        rs.next();
		        rs.getString(1);
		        out.println("the book details are as follows :<hr><br>");
		        out.println("<hr><br>ID:"+rs.getString(1)+"<br>");
		        out.println("Name:"+rs.getString(2)+"<br>");
		        out.println("Author:"+rs.getString(3)+"<br>");
		        out.println("Edition:"+rs.getString(4)+"<br>");
		        out.println("Price:"+rs.getString(5)+"<br>");}
		        catch(SQLException e) {
		        	out.println("No book found with entered details");}
		}
		    
		    catch(Exception e ) {
		    out.println("Sorry we have encountered an error:"+e);}
	}

}}
