

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
@WebServlet("/validateRecord")
public class validateRecord extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
	    response.setContentType("text/html"); 
	    int flag=0;
		int id=0;
		double price=0.0;
		int edition=0;
	    try {
		id=Integer.parseInt(request.getParameter("id"));}
		catch(Exception e) {
			flag=1;
		}
		String name=request.getParameter("name");
		String author=request.getParameter("author");
		try{ edition=Integer.parseInt(request.getParameter("edition"));}
		catch(Exception e) {flag=1;}
		if(name.equals("") || author.equals(""))
			flag=1;
		try{price=Double.parseDouble(request.getParameter("price"));}
		catch(Exception e) {flag=1;}
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
		        String query = "insert into library values(?,?,?,?,?)";
		        PreparedStatement ps=conn.prepareStatement(query);
		        ps.setInt(1,id);
		        ps.setString(2, name);
		        ps.setString(3, author);
		        ps.setInt(4, edition);
		        ps.setDouble(5, price);
		        ps.executeUpdate();
		        out.println("Successfully entered the following details:<br>");
		        out.println("<hr><br>ID:"+id+"<br>");
		        out.println("Name:"+name+"<br>");
		        out.println("Author:"+author+"<br>");
		        out.println("Edition:"+edition+"<br>");
		        out.println("Price:"+price+"<br>");
		}
		    catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
		    	out.println("Book with id already exists");
		    }
		    catch(Exception e ) {
		    out.println("Sorry we have encountered an error:"+e);}
	}

}}
