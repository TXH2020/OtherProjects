<?php

// Username is root
$user = 'root';
$password = '';

// Database name is gfg
$database = 'staff';

// Server is localhost with
// port number 3308
$servername='localhost';
$mysqli = new mysqli($servername, $user,
				$password, $database);

// Checking for connections
if ($mysqli->connect_error) {
	die('Connect Error (' .
	$mysqli->connect_errno . ') '.
	$mysqli->connect_error);
}

// SQL query to select data from database
$sql = "SELECT * FROM `college`";
$result = $mysqli->query($sql);
$mysqli->close();
?>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<title>Products</title>
	<!-- CSS FOR STYLING THE PAGE -->
	<style>
p{
float:right;}
.box1{
float:left;}
.box2{
position:absolute;
margin:-90px 0px 0px 580px;
}
h1{
color:DarkOliveGreen;
}
		table {
			margin: 0 auto;
			font-size: large;
			border: 1px solid black;
		}

		h1 {
			text-align: center;
			color: #006600;
			font-size: xx-large;
			font-family: 'Gill Sans', 'Gill Sans MT',
			' Calibri', 'Trebuchet MS', 'sans-serif';
		}

		td {
			background-color: #E4F5D4;
			border: 1px solid black;
		}

		th,
		td {
			font-weight: bold;
			border: 1px solid black;
			padding: 10px;
			text-align: center;
		}

		td {
			font-weight: lighter;
		}
		section{
		position:relative;
		left:-20px;}
	</style>
</head>

<body>
<p align="right"><a href='index.php'>Back to Homepage</a></p>	
<div class="box1">
		<img src="logo.jpg" style="max-width:100px"></img></div><br><br><br><br>   
<div class="box2">
		<h1>FarmEasy</h1></div>
		
		<section>
		<!-- TABLE CONSTRUCTION-->
		<center><h2>Products</h2></center>
		<table>
			<tr>
				<th>Crop</th>
				<th>District</th>
				<th>State</th>
				
			</tr>
			<!-- PHP CODE TO FETCH DATA FROM ROWS-->
			<?php // LOOP TILL END OF DATA
				while($rows=$result->fetch_assoc())
				{
			?>
			<tr>
				<!--FETCHING DATA FROM EACH
					ROW OF EVERY COLUMN-->
				<td><?php echo $rows['crop'];?></td>
				<td><?php echo $rows['district'];?></td>
				<td><?php echo $rows['state'];?></td>
				
			</tr>
			<?php
				}
			?>
		</table>
	</section>
</body>

</html>
