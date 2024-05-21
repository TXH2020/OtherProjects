<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String name=request.getParameter("name");
int age=Integer.parseInt(request.getParameter("age"));
out.println("Name:"+name+"<br>");
out.println("Age:"+age+"<br>");
if(age>62)
	out.println("Price:50");
else if(age<10)
	out.println("Price:30");
else
	out.println("Price:80");
%>
</body>
</html>