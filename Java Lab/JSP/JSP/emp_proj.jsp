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
<% String url = "jdbc:mysql://localhost:3306/"; 
String dbName = "employee"; 
String driver = "com.mysql.jdbc.Driver"; 
String user = "root";  
String password = ""; 
try {
	Class.forName(driver).newInstance(); 
	Connection con = DriverManager.getConnection(url+dbName, user, password); 
	out.print("Connection is successful");
	int id=0;
	double sal = 0.0;
	try{
	id = Integer.parseInt(request.getParameter("id"));}
	catch(Exception e){id=0;}
	try{
		sal = Double.parseDouble(request.getParameter("salary"));}
		catch(Exception e){sal=0.0;}
	String fn = request.getParameter("fname");
	String ln = request.getParameter("lname");
String proj = request.getParameter("project");
	String query  = "Select * from employee where ID=? or FName=? or LName=? or Salary=? or Project=?";
	PreparedStatement ps = con.prepareStatement(query);
	ps.setInt(1,id);
	ps.setString(2,fn);
	ps.setString(3,ln);
	ps.setDouble(4,sal);
	ps.setString(5,proj);
	ResultSet rs = ps.executeQuery();
	if(rs != null)
	{
		while(rs.next())
		{
			out.println("<br>"+rs.getString(1)+"   "+rs.getString(2)+"   "+
		rs.getString(3)+"   "+rs.getString(4)+"   "+rs.getString(5)+"<br>");
		}
	}
	else
		out.println("Not present");
}
  catch(SQLException e) {
  out.println("SQLException: " + e.getMessage() + "<BR>");
  }
catch(ClassNotFoundException e) {
  out.println("ClassNotFoundException: " + e.getMessage() + "<BR>");
  }
catch(Exception e){
	out.println(e);
}

 %>
</body>
</html>