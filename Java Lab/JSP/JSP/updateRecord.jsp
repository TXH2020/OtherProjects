<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Record</title>
</head>
<body>
<h1>Update Record</h1><br>
<p>Enter the ID of the book for updating its entry from the database. The previous data
will be displayed. Enter new data below.
</p>
<br>
<form action='updateRecord' method='post'>
<table>
<tr><td>book_ID:</td><td><input type='text' name='id'></td></tr>
</table><br>
<center><input align='center' type='submit'></center>
</body>
</html>