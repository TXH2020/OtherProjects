

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
@WebServlet("/updateRecord")
public class updateRecord extends HttpServlet {
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
		if(empty==1)
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
		        String query = "select * from library where ID=?";
		        PreparedStatement ps=conn.prepareStatement(query);
		        ps.setInt(1,id);
		        ResultSet rs=ps.executeQuery();
		        try {
		        rs.next();
		        rs.getString(1);
		        out.println("the book details are as follows. Update them and submit "
		        		+ "to set new values for record :<hr><br>");
		        out.println("<form action='updateRecord_sub' method='post'><br>");
		        out.println("ID:"+"<input type='text' value="+rs.getString(1)+" name="
		        		+ "'id'><br>");
		        out.println("name:"+"<input type='text' value="+rs.getString(2)+" name="
		        		+ "'name'><br>");
		        out.println("Author:"+"<input type='text' value="+rs.getString(3)+" name="
		        		+ "'author'><br>");
		        out.println("Edition:"+"<input type='text' value="+rs.getString(4)+" name="
		        		+ "'edition'><br>");
		        out.println("Price:"+"<input type='text' value="+rs.getString(5)+" name="
		        		+ "'price'><br>");
		        out.println("<input type='hidden' value="+id+" name="
		        		+ "'updateID'><br>");
		        out.println("<input type='submit'><br>");
		        RequestDispatcher rd=request.getRequestDispatcher("updateRecord_sub");
		        }
		        catch(SQLException e) {
		        	out.println("Book with id does not exist");}
		}
		    
		    catch(Exception e ) {
		    out.println("Sorry we have encountered an error:"+e);}
	}

}}
