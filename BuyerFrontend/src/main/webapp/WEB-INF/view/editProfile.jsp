<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/theme.css" rel="stylesheet" type="text/css">
<title>FOOD KA MOOD</title>
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
          <div><a href="/seeRestaurants"><button>See Restaurants</button></a></div>
          <div><a href="/seeOrders"><button>See Orders</button></a></div>
          <div><a href="/editProfile"><button>Edit Profile</button></a></div>
          <div><a href="/logout"><button>Logout</button></a></div>
        </div>
      </nav>
      <div class=page-title><h1>Edit Profile</h1></div>
<div class=page-title>
<form:form action="updateProfile" method="POST">
	<table>
		<tr>
			<td></td>
			<td><form:hidden path="mobileNumber"/><form:hidden path="role"/></td>
		</tr>
		<tr>
			<td>Enter Name :</td>
			<td><form:input path="name"/></td>
		</tr>
		<tr>
			<td>Enter City :</td>
			<td><form:input path="city"/></td>
		</tr>
		<tr>
			<td>Enter Address :</td>
			<td><form:input path="address"/></td>
		</tr>
		<tr>
			<td></td>
			<td><form:hidden path="password"/><input type="submit" value="Save Changes"/></td>
		</tr>
	</table>
</form:form>
</div>
</body>
</html>