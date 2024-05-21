<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
Cookie ck[]=request.getCookies();
		String s="<html><body><h1>Cookies</h1><br><br><p>Cookie Name&emsp;Value</p><br>";
		for(int i=0;i<ck.length;i++) 
			s=s+"<p>"+ck[i].getName()+"&emsp;"+ck[i].getValue()+"</p><br>";
		s=s+"</body></html>";
		out.println(s);
		%>
</body>
</html>