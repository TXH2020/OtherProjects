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
double no=Double.parseDouble(request.getParameter("no"));
String val=request.getParameter("Calculation");
double result=0.0;
if(val.equals("sin"))
	 result=Math.sin(no);
else if(val.equals("cos"))
	result=Math.cos(no);
else if(val.equals("tan"))
	 result=Math.tan(no);
else if(val.equals("log"))
	result=Math.log(no);
else
	result=Math.sqrt(no);
out.println(result);
%>
</body>
</html>