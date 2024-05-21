import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.sql.Date;
import java.text.DateFormat;

@WebServlet("/EmployeeDB")
public class EmployeeDB extends HttpServlet {
	static void insert(String query,Connection con,String info[]) {
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1,Integer.parseInt(info[0]));
			ps.setString(2,info[1]);
			ps.setString(3,info[2]);
			ps.setString(4, info[3]);
			ps.execute();
		System.out.println();}
			catch(SQLException e) {
			e.printStackTrace();}
			finally {
				try {
					ps.close();}
				catch(Exception e) {
					e.printStackTrace();}}}
  public void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {
	  response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter(); 
	    Connection conn = null;
	    String url = "jdbc:mysql://localhost:3306/"; 
	    String dbName = "Employee1"; 
	    String driver = "com.mysql.jdbc.Driver"; 
	    String user = "root";  
	    String password = "";
	    String info[]=new String[4];
	    info[0] = request.getParameter("id");
	    info[1] = request.getParameter("name");
	    info[2] = request.getParameter("add");
	    info[3] = request.getParameter("dob");
	    try { 
	        Class.forName(driver).getDeclaredConstructor().newInstance(); 
	        conn = DriverManager.getConnection(url+dbName, user, password);
			String query = "SELECT * FROM employee";
			String query1="insert into employee values(?,?,?,?)";
	        PreparedStatement ps=conn.prepareStatement(query);
	        insert(query1,conn,info);
			ResultSet rs = ps.executeQuery();
	        if(rs != null) {
	        	String f[]=new String[4];
			while(rs.next()) {
				for(int i=0;i<4;i++)
					f[i]=rs.getString(i+1);
				out.println(f[0]+"&nbsp;"+f[1]+"&nbsp;"+f[2]+"&nbsp;"+f[3]+"<br>");
			}
	        }
	    } catch (Exception e) { 
	    	System.out.println("ERROR"+e);
  	 	        out.close(); }
	    }
  		protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
  		{
  			doGet(request,response);
  		}
  }