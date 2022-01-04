<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/static/css/register.css">

</head>
<body>
<div class="form">
<h3>User Registration</h3>



<form:form id="registrationform" action="saveUser" method="post" modelAttribute="user">

<p class="contact"><label for="fname">Email</label></p>
<input id="email" name="email" placeholder="Enter Email" required tabindex="1" type="email">


<p class="contact"><label for="fname">First Name</label></p>
<input id="firstname" name="firstname" placeholder="Enter first name" required tabindex="2" type="text">



<p class="contact"><label for="lname">Last Name</label></p>
<input id="lastname" name="lastname" placeholder="Enter last name" required tabindex="2" type="text">


<p class="contact"><label for="fathername">Father's Name</label></p>
<input id="fathername" name="fathername" placeholder="Enter father name" required tabindex="4" type="text">



<label for="birthday">Birthday:</label>
<input type="date" id="dob" name="dob" tabindex="5">


<p class="contact"><label for="aadharnumber">Aadhar Number</label></p>
<input id="aadharnumber" name="aadharnumber" placeholder="Enter Aadhar number" required tabindex="6" type="text">


<p class="contact"><label for="pannumber">Pan Number</label></p>
<input id="pannumber" name="pannumber" placeholder="Enter Pan number" required tabindex="7" type="text">



<p class="contact"><label for="password">Enter a password</label></p>
<input type="password" id="password" name="password" required tabindex="8">



<p class="contact"><label for="phone">Mobile phone</label></p>
<input id="mobilenumber" name="mobilenumber" placeholder="phone number" required tabindex="9" type="text">


<p class="country"><label for="country">Country</label></p>
<input id="country" name="country" placeholder="Country" required tabindex="10" type="text">

<p class="state"><label for="state">State</label></p>
<input id="state" name="state" placeholder="State" required tabindex="11" type="text">


<select class="select-style city" name="city" tabindex="12">

<option value="select">Select Your City</option>
<option value="Bangalore">Bangalore</option>
<option value="Chennai">Chennai</option>
<option value="Delhi">Delhi</option>
<option value="Kolkatta">Kolakatta</option>
<option value="Mumbai">Mumbai</option>
</select><br><br>

<p class="street"><label for="street">Address</label></p>
<input id="street" name="street" placeholder="Street Address" required tabindex="13" type="text">


<p class="pincode"><label for="pincode">Pin Code</label></p>
<input id="pincode" name="pincode" placeholder="Enter Pin Code" required tabindex="14" type="text">
<br>
<input class="buttom" name="submit" id="submit" tabindex="9" value="Sign me up!" type="submit">
</form:form>
</div>


</body>
</html>