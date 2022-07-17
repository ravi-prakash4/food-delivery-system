<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FOOD KA MOOD</title>
<link href="css/theme.css" rel="stylesheet" type="text/css">
</head>
<body>      
	<nav>
        <div class="wrapper1">
          <a href="/" style="text-decoration: none;">
          <div class="logo"><ul>
            <li class=logo-li-h1 style="display:block;line-height:10px">FOOD</li>
            <li class=logo-li-h3 style="display:block;line-height:10px">KA</li>
            <li class=logo-li-h1 style="display:block;line-height:10px">MOOD</li>
          </ul></div>
          </a>
          </div>
        <div class="wrapper2">
          <div></div>
        </div>
      </nav>
<div class=page-title><h1>Sign Up</h1></div>
<div class=page-title>
<form:form action="signUpSubmit" method="post">
<table>
	<tr><td>Name :</td><td><input type="text" name="name"/></td></tr>
	<tr><td>Mobile Number :</td><td><input type="number" name="mobileNumber"/></td></tr>
	<tr><td>City :</td><td><input type="text" name="city"/></td></tr>
	<tr><td>Full Address :</td><td><input type="text" name="address"/></td></tr>
	<tr><td>Password :</td><td><input type="password" name="password"/></td></tr>
	<tr><td></td><td><input type="submit" value="Sign Up"/></td></tr>
</table>
</form:form>
</div>
</body>
</html>