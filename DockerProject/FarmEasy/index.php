<!DOCTYPE html>
<html lang="en">
    
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1" />
	<title>
		FarmEasy**
	</title>
  <h1>
		<font face="Lato" color="DarkOliveGreen" size="7">
			FARMEASY 
		</font>
	</h1>
  <style>
    #form{
    position:absolute;
    left:27px;
    top:240px;
    height:700px;
    width:320px;
    background-color:CadetBlue;
    border-style:solid;}
    #box1{
    position:absolute;
    left:140px;
    top:70px;}
    #box2{
    position:absolute;
    left:450px;
    top:150px;}
    #box3{
    position:absolute;
    left:450px;
    top:270px;}
    #box4{
    position:absolute;
    left:700px;
    top:900px;
    max-width:400px;}
    #box5{
    position:absolute;
    left:640px;}
    #box6{
    position:absolute;
    left:260px;
    top:940px;
    width:1000px;
    }
    .blue {
    background: #347fd0;
    }
    .news {
        box-shadow: inset 0 -15px 30px rgba(0,0,0,0.4), 0 5px 10px rgba(0,0,0,0.5);
        width: 350px;
        height:600px;
        position:absolute;
        left: 1210px;
        top:240px;
        overflow: hidden;
        border-radius: 4px;
        padding: 1px;
        -webkit-user-select: none;
    }
    .news span {
        float: left;
        color: red;
        padding: 20px;
        width:100%;
        position: relative;
        bottom: 1%;
        box-shadow: inset 0 -15px 30px rgba(0,0,0,0.4);
        font: 16px 'Raleway', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -webkit-user-select: none;
        cursor: pointer;
    }
    .text1{
        box-shadow:none !important;S
        width: 300px;
    }
    #date {
          font-size: 20px;
          width: 140px;
          position:absolute;
          left:1313px;
          text-align: center;
          border: 2px solid black;
    }
    .search
    {
    position:absolute;
    left:1240px;
    top:152px;}
    #clock {
          font-size: 20px;
          width: 130px;
          position:absolute;
          top:60px;
          left:1320px;
          text-align: center;
          border: 2px solid black;}
    h1 {
        position:absolute;
        left:600px;
        }
    h2 {
        color: red;
        font-family: Calibri;
      }
    marquee{
    border-style:solid;
    background-color:white;}
    * {box-sizing: border-box}
    body {font-family: Verdana, sans-serif; margin:0}
    .mySlides {display: none}
    img {vertical-align: middle;}

    .slideshow-container {
      max-width: 600px;
      position: relative;
      margin: auto;
    }

    .prev, .next {
      cursor: pointer;
      position: absolute;
      top: 50%;
      width: auto;
      padding: 16px;
      margin-top: -22px;
      color: white;
      font-weight: bold;
      font-size: 18px;
      transition: 0.6s ease;
      border-radius: 0 3px 3px 0;
      user-select: none;
    }

    .next {
      right: 0;
      border-radius: 3px 0 0 3px;
    }

    .prev:hover, .next:hover {
      background-color: rgba(0,0,0,0.8);
    }

    .text {
      color: #f2f2f2;
      font-size: 15px;
      padding: 8px 12px;
      position: absolute;
      bottom: 8px;
      width: 100%;
      text-align: center;
    }

    .numbertext {
      color: #f2f2f2;
      font-size: 12px;
      padding: 8px 12px;
      position: absolute;
      top: 0;
    }

    .dot {
      cursor: pointer;
      height: 15px;
      width: 15px;
      margin:0px 2px;
      background-color: #bbb;
      border-radius: 50%;
      display: inline-block;
      transition: background-color 0.6s ease;
    }

    .active, .dot:hover {
      background-color: #717171;
    }

    .fade {
      -webkit-animation-name: fade;
      -webkit-animation-duration: 1.5s;
      animation-name: fade;
      animation-duration: 1.5s;
    }

    @-webkit-keyframes fade {
      from {opacity: .4} 
      to {opacity: 1}
    }

    @keyframes fade {
      from {opacity: .4} 
      to {opacity: 1}
    }

    @media only screen and (max-width: 300px) {
      .prev, .next,.text {font-size: 11px}
    }
</style>
</head>


<body bgcolor="Azure">	
	<h3>
		<div id="box1">
		<img src="logo.jpg" style="max-width:100px"></img></div>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<div id="box2"><font face=>	<a href="#">HOME</a>&nbsp;&nbsp;&nbsp;
                     <span>   <a href="video1.html">VIDEOS</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="data.php">PRODUCTS</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="about.html">ABOUT</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="contact.html">CONTACT</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="https://colab.research.google.com/drive/1cRPSUNIeS1ha82T1o3VXARIxGMSkDMoz?usp=sharing">ANALYTICS</a></span>
		</font></div>
	</h3><br><br>

<div id="clock">8:10:45</div>
    <script>
        setInterval(showTime, 1000);
        function showTime() {
            let time = new Date();
            let hour = time.getHours();
            let min = time.getMinutes();
            let sec = time.getSeconds();
            am_pm = "AM";
  
            if (hour > 12) {
                hour -= 12;
                am_pm = "PM";
            }
            if (hour == 0) {
                hr = 12;
                am_pm = "AM";
            }
  
            hour = hour < 10 ? "0" + hour : hour;
            min = min < 10 ? "0" + min : min;
            sec = sec < 10 ? "0" + sec : sec;
  
            let currentTime = hour + ":" 
                + min + ":" + sec + am_pm;
  
            document.getElementById("clock")
                .innerHTML = currentTime;
        }
        showTime();
    </script>

<div id="date">
	<table>
			<tr>
			<td >
			<?php
				date_default_timeZone_set("Asia/Calcutta");
				echo date('d-m-Y');
			?>
			</td>
			</tr>
	</table>
	</div>

<div class="search">
			<table>
			<form action="search1.php" method="post">
			<tr>
				<td>  <label for="sear"><b>Search:</b></label> </td>
       				<td>  <input type="text" name="search1" id="search1.php"> </td>
			</tr>
			<tr>
				<td> &nbsp; </td>
       				<td> <input type="submit" name="search" value="submit" > </td>
			</tr></form>
			</table>
		</div>
  
<br><br><br><br><br>
  	<div id="form">
        <form id="registration" action="insert.php" method="post"> 
        <center>
        <font face="Lato" color="black" size="5"><i>FarmEasy</i></font>
	<h2>Farmer Registration Form</h2>
        </center>
          <p>
          <b> <label for="firstName">First Name:</label></b>
          <input type="text" name="first_name" id="firstName" required pattern='[A-Za-z]+' minlength=2 maxlength=40>
          <br>                        
          <b> <label for="lastName">Last  Name:</label></b>
          <input type="text"   name="last_name" id="lastName" required pattern='[A-Za-z]+' minlength=2 maxlength=40>        
          </p> 
            
          <p>		
          <b>Gender:</b>
          <input type="radio" name="gender" value="Male" id="male" required>Male
          <input type="radio" name="gender" value="Female" id="female">Female
          </p>
            
          <p>
          <b> <label for="city">City/Village/Town:</label></b>
          <input type="text"   name="city"  id="city" required minlength=2 maxlength=40><br>
          <b> <label for="district">District:</label></b><br>
          <input type="text"  name="district"  id="district" required minlength=2 maxlength=40><br>
          <b> <label for="state">State:</label></b><br>
          <input type="text"   name="state" id="state" required minlength=2 maxlength=40>
          </p>
                    
          <p>
          <b> <label for="emailAddress">Email:</label></b>
          <input type="email" name="email" id="emailAddress" placeholder="xyz@g.com" required><br>
          <b> <label for="phone">Phone no.:</label></b><br>
          <input type="tel" id="phone" name="phone_no" placeholder="10 digit number" pattern='[0-9]{10}'>
          </p>

          <script type="text/javascript">
              function ShowHideDiv(chkCropType) {
                if(chkCropType.id==='chkCropType1'){
                var dvCropType = document.getElementById("dvCropType");
                dvCropType.style.display = chkCropType.checked ? "block" : "none";}
                if(chkCropType.id==='chkCropType2'){
                var dvCropType1 = document.getElementById("dvCropType1");
                dvCropType1.style.display = chkCropType.checked ? "block" : "none";}
                if(chkCropType.id==='chkCropType3'){
                var dvCropType2 = document.getElementById("dvCropType2");
                dvCropType2.style.display = chkCropType.checked ? "block" : "none";}
                if(chkCropType.id==='chkCropType4'){
                var dvCropType3 = document.getElementById("dvCropType3");
                dvCropType3.style.display = chkCropType.checked ? "block" : "none";}
              }
            function checkall(name){
              var list=document.getElementsByName(name);
              var checked=[]
              var count=0;
              for(var i=0;i<list.length;i++)
                if(list[i].checked===false)
                count++;
                else
                checked.push(list[i]);
              if(count===list.length)
              return false;
              else
              return checked;
            }
            function checkcrop(event){
              var croptypes=checkall('croptype[]');
              if(!croptypes){
              event.preventDefault();
              alert('Select atleast one croptype');}
              else{
                var flag=0;
                for(var i=0;i<croptypes.length;i++){
                  var x=0;
                  if(croptypes[i].id==='chkCropType1')
                  x='fruits[]';
                  else if(croptypes[i].id==='chkCropType2')
                  x='vegetables[]';
                  else if(croptypes[i].id==='chkCropType3')
                  x='pulses[]';
                  else
                  x='grains[]';
                  var indcrops=checkall(x);
                  if(!indcrops){
                  event.preventDefault();
                  alert('Select atleast one of the '+x);}
                }
              }
            }
            document.getElementById('registration').addEventListener('submit',checkcrop);
          </script>

          <p id="major"><b>Crop_Type:</b>
          <input type="checkbox" name="croptype[]" id="chkCropType1" value= "1" onclick="ShowHideDiv(this)" />
              Fruits

          <input type="checkbox" name="croptype[]" id="chkCropType2" value= "2" onclick="ShowHideDiv(this)" />
            Vegetables

          <input type="checkbox" name="croptype[]" id="chkCropType3" value= "3" onclick="ShowHideDiv(this)" />
            Pulses

          <input type="checkbox" name="croptype[]" id="chkCropType4" value= "4" onclick="ShowHideDiv(this)" />
            Grains
          </p>

          <div id="dvCropType" style="display: none">   
          Apple <input type="checkbox" name="fruits[]" id="apple" value="apple" />
          Mango <input type="checkbox" name="fruits[]" id="mango" value="mango" />
          Orange <input type="checkbox" name="fruits[]" id="orange" value="orange" />
          Guava <input type="checkbox" name="fruits[]" id="guava" value="guava" />
          Lemon <input type="checkbox" name="fruits[]" id="lemon" value="lemon" />
          </div>

          <div id="dvCropType1" style="display: none">   
          Cucumber <input type="checkbox" name="vegetables[]" id="cucumber" value="cucumber" />
          Tomato <input type="checkbox" name="vegetables[]" id="tomato" value="tomato" />
          Radish <input type="checkbox" name="vegetables[]" id="radish" value="radish" />
          Spinach <input type="checkbox" name="vegetables[]" id="spinach" value="spinach" />
          Brinjal <input type="checkbox" name="vegetables[]" id="brinjal" value="brinjal"/>
          </div>

          <div id="dvCropType2" style="display: none">   
          Beans <input type="checkbox" name="pulses[]" id="beans" value="beans" />
          Peas <input type="checkbox" name="pulses[]" id="peas" value="peas" />
          Nuts <input type="checkbox" name="pulses[]" id="nuts" value="nuts" />
          Dal <input type="checkbox" name="pulses[]" id="dal" value="dal" />
          Gram <input type="checkbox" name="pulses[]" id="gram" value="gram" />
          </div>

          <div id="dvCropType3" style="display: none">   
          Rice<input type="checkbox" name="grains[]" id="rice" value="rice"/>
          Wheat <input type="checkbox" name="grains[]" id="wheat" value="wheat"/>
          Corn <input type="checkbox" name="grains[]" id="corn" value="corn"/>
          Ragi <input type="checkbox" name="grains[]" id="ragi" value="ragi"/>
          Jowar <input type="checkbox" name="grains[]" id="jowar" value="jowar"/>
          </div>
	  
          <input type="submit" value="Submit" id="sub">
        </form></div>

<div id="box3">
<meta name="viewport" content="width=device-width, initial-scale=1">
<body>

<div class="slideshow-container">

<div class="mySlides fade">
  <div class="numbertext">1 / 5</div>
  <img src="s4.jpeg" style="width:100%">
  <div class="text">Caption One</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">2 / 5</div>
  <img src="s7.jpeg" style="width:100%">
  <div class="text">Caption Two</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">3 / 5</div>
  <img src="s3.jpeg" style="width:100%">
  <div class="text">Caption Three</div>
</div>
<div class="mySlides fade">
  <div class="numbertext">4 / 5</div>
  <img src="s1.jpeg" style="width:100%">
  <div class="text">Caption Four</div>
</div>
<div class="mySlides fade">
  <div class="numbertext">5 / 5</div>
  <img src="s2.jpeg" style="width:80%">
  <div class="text">Caption Five</div>
</div>

<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
<a class="next" onclick="plusSlides(1)">&#10095;</a>

</div>
<br>

  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
  <span class="dot"  onclick="currentSlide(1)"></span> 
  <span class="dot"  onclick="currentSlide(2)"></span> 
  <span class="dot"  onclick="currentSlide(3)"></span> 
  <span class="dot"  onclick="currentSlide(4)"></span> 
  <span class="dot"  onclick="currentSlide(5)"></span>


<script>
var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
}
</script></div>
<div class="news blue"> <center>
<span> <h2>📢 LATEST NEWS </h2></span></center><span class="text1" ><marquee>
<p><h2><a href="https://krishijagran.com">krishi news</a></h2></p>
<p><h2><a href="http://agriretailers.com/agri-retail-news.html">Agriretail News</a></h2></p>
<p><h2><a href="https://www.farmart.co/">Farmart News </a></h2></p>
<p><h2><a href="http://agtechnews.com/Ag-Tech-News.html">Agtech News <a></h2></p>
<p><h2><a href="https://www.gktoday.in/topics/agriculture/">Current AgriNews   </a></h2></p></marquee></span>

</div>
<br><br>
<div id="box4">
 <center><br>Useful Links:</center></div><br><br>
<center><br><br><br><br><br>

<div id="box6"><marquee direction="right"  width="60%" height="60%">
<a href="https://farmer.gov.in">https://farmer.gov.in</a>
<br><br>
<a href="https://icar.gov.in/">ICAR</a>
<br><br>
<a href="https://pmfby.gov.in/">Pradhan Mantri Fasal Bhima Yojana</a>
<br><br>
<a href="https://mnsoybean.org/msrpc/modern-ag/">Modern Agriculture</a>
<br><br>
<a href="https://www.grainmart.in/news/category/news/">Grainmart</a>
</marquee>
 </center></div>
<h3 align="top">
		<font face="Lato" color="#000" size="5">
		
		</font>
	</h3>
	
</body>
</html>