<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int m[]=new int[5];
m[0]=Integer.parseInt(request.getParameter("sub1"));
m[1]=Integer.parseInt(request.getParameter("sub2"));
m[2]=Integer.parseInt(request.getParameter("sub3"));
m[3]=Integer.parseInt(request.getParameter("sub4"));
m[4]=Integer.parseInt(request.getParameter("sub5"));
double res=0.0;
for(int i=0;i<m.length;i++)
res=res+m[i];
res=res/m.length;
if(res>=90.0)
	out.println("A");
else if(res>=80.0 && res<=89.0)
		out.println("B");
else if(res>=70.0 && res<=79.0)
		out.println("C");
else if(res>=60.0 && res<=69.0)
		out.println("D");
else if(res>=50.0 && res<=59.0)
		out.println("E");
else
		out.println("Fail");
%></body>
</html>