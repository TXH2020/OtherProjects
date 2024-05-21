<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Record</title>
</head>
<body>
<h1>Display Record</h1><br>
<p>Enter the ID or Name of the book for obtaining its details.</p><br>
<form action='displayRecord' method='post'>
<table>
<tr><td>book_ID:</td><td><input type='text' name='id'></td></tr><br>
<tr><td>book_Name:</td><td><input type='text' name='name'></td></tr><br>
</table><br>
<center><input align='center' type='submit'></center>
</body>
</html>