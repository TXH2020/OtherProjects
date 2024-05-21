<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Record</title>
</head>
<body>
<h1>Delete Record</h1><br>
<p>Enter the ID of the book for deleting its entry from the database.</p><br>
<form action='deleteRecord' method='post'>
<table>
<tr><td>book_ID:</td><td><input type='text' name='id'></td></tr>
</table><br>
<center><input align='center' type='submit'></center>
</body>
</html>