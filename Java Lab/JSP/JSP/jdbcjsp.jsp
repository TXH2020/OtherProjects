<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%
String url = "jdbc:mysql://localhost:3306/"; 
String dbName = "Student1"; 
String driver = "com.mysql.jdbc.Driver"; 
String user = "root";  
String password = ""; 
try {
	Class.forName(driver).newInstance(); 
	Connection con = DriverManager.getConnection(url+dbName, user, password); 
	out.print("Connection is successful");
	String u = request.getParameter("usn");
	String query  = "Select * from student where usn = ?";
	PreparedStatement ps = con.prepareStatement(query);
	ps.setString(1,u);
	ResultSet rs = ps.executeQuery();
	if(rs != null)
	{
		while(rs.next())
		{
			out.println("<br>"+rs.getString(1) +"   "+ rs.getString(2)+"<br>");
		}
	}
	else
		out.println("Invalid USN");
}
  catch(SQLException e) {
  out.println("SQLException: " + e.getMessage() + "<BR>");
  }
catch(ClassNotFoundException e) {
  out.println("ClassNotFoundException: " + e.getMessage() + "<BR>");
  }
 %>
</body>
</html>