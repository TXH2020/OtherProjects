<!DOCTYPE html>
<html>

<head>	
	<title>Insert Page</title>
</head>

<body bgcolor="Chartreuse">
<p align="right"><a href='index.php'>Back to Homepage</a></p>
	<center>
		<?php
		$conn = mysqli_connect("localhost", "root", "", "staff");
		
		// Check connection
		if($conn === false){
			die("ERROR: Could not connect. "
				. mysqli_connect_error());
		}
		
		$first_name = $_REQUEST['first_name'];
		$last_name = $_REQUEST['last_name'];
		$gender = $_REQUEST['gender'];
		$city = $_REQUEST['city'];
		$district = $_REQUEST['district'];
		$state = $_REQUEST['state'];
		$email = $_REQUEST['email'];
        $phone = $_REQUEST['phone_no'];
		$crop='';
		$x=$_REQUEST['croptype'];
		for($i=0;$i<count($x);$i++){
			$crop.=$x[$i].',';
			if($x[$i]=='1')
			$crop.= implode(',',$_REQUEST['fruits']);
			elseif($x[$i]=='2')
			$crop.= implode(',',$_REQUEST['vegetables']);
			elseif($x[$i]=='3')
			$crop.= implode(',',$_REQUEST['pulses']);
			elseif($x[$i]=='4')
			$crop.= implode(',',$_REQUEST['grains']);
			if($i!=count($x)-1)
			$crop.=',';
		}
		
		// Performing insert query execution
		// here our table name is college
		
		$sql = "INSERT INTO college VALUES ('$first_name',
			'$last_name','$gender','$city','$district','$state','$email','$phone','$crop')";
		
		if(mysqli_query($conn, $sql)){
			echo "<h3>Success!"
				. " Data stored in the database successfully.</h3>";

			echo nl2br("\nFirst Name: $first_name\n Last Name: $last_name\n "
				. "Gender: $gender\nCity/Village/Town: $city\nDistrict: $district\nState: $state\nEmail: $email\nPhone: $phone\nCrop: $crop");
		} else{
			echo "ERROR:Sorry, data was not stored $sql. "
				. mysqli_error($conn);
		}
		
		// Close connection
		mysqli_close($conn);
		?>
	</center>
</body>

</html>
