<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<% 
String url = "jdbc:mysql://localhost:3306/"; 
String dbName = "User"; 
String driver = "com.mysql.jdbc.Driver"; 
String user = "root";  
String password = "";
String user1 = request.getParameter("user");
String pass = request.getParameter("pass");
	   try { 
	        Class.forName(driver).getDeclaredConstructor().newInstance(); 
	        Connection conn = DriverManager.getConnection(url+dbName, user, password);
			String query = "SELECT * FROM user where Username = ? and Password = ?";
	        PreparedStatement ps=conn.prepareStatement(query);
	        ps.setString(1,user1);
	        ps.setString(2,pass);
			ResultSet rs = ps.executeQuery();
	        if(rs.next())
	        	out.println("<b>Valid user "+rs.getString(1)+"</b>");
	   else
	        	out.println("<b>"+"Invalid user credentials"+"</b>");
	         }
	   catch (Exception e) { 
	    	System.out.println("ERROR"+e); }
	   %>
</body>
</html>