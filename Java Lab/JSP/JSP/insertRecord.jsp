<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert-Record</title>
</head>
<body>
<h1>Insert Record</h1>
<form action='validateRecord' method='post'>
<table>
<tr><td>book_ID:</td><td><input type='text' name='id'></td></tr><br>
<tr><td>book_Name:</td><td><input type='text' name='name'></td></tr><br>
<tr><td>book_Author:</td><td><input type='text' name='author'></td></tr><br>
<tr><td>book_Edition:</td><td><input type='text' name='edition'></td></tr><br>
<tr><td>book_Price:</td><td><input type='text' name='price'></td></tr>
</table><br>
<center><input align='center' type='submit'></center>
</form>
</body>
</html>