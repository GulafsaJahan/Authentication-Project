<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Registartion page</title>
</head>
<body>
<center>
<h3> Registration Form </h3>
<form action="regform" method="post">
 Name : <input type="text" name="name1" > <br><br>
 FName : <input type="text" name="fname" > <br><br>
 Email ID : <input type="text" name="email" > <br><br>
 Password : <input type="password" name="password1" > <br><br>
 Gender : <input type="radio" name="gender1" value="Male" >Male <input type="radio" name="gender1" value="Female" >Female <br><br>
 Address : <textarea name="address" cols="32" rows="6"></textarea><br><br>
 City : <select name="city">
 <option>Delhi</option>
 <option>Lucknow</option>
 <option>Gorakhpur</option>
 <option>Kushinagar</option>
 <option>Noida</option>
 <option>Bengaluru</option>
 <option>Kolkata</option>
 </select>
 <br><br>
 <input type="submit" value="Register" />
</form>
</center>
</body>
</html>