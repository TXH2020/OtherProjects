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
Cookie c1=new Cookie("no5","val2");
Cookie c2=new Cookie("no6","val22");
Cookie c3=new Cookie("no7","val32");
response.addCookie(c1);
response.addCookie(c2);
response.addCookie(c3);%>
<jsp:forward page="cookiesread.jsp" >
<jsp:param name="name" value="ABCD" />
</jsp:forward>

</body>
</html>