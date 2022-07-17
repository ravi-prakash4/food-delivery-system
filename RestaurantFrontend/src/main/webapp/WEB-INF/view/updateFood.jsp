<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FOOD KA MOOD | Restaurant</title>
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
          <div><a href="/food"><button>Edit Food Menu</button></a></div>
          <div><a href="/seeOrders"><button>See Orders</button></a></div>
          <div><a href="/logout"><button>Logout</button></a></div>
        </div>
      </nav>
<div class=page-title><h1>Edit Dish</h1></div>
<div class=page-title>
<form:form method="post" action="update">
<table>
		<tr>
			<td>Enter Name :</td>
			<td><form:input path="name"/></td>
		</tr>
		<tr>
			<td>Enter Price :</td>
			<td><form:input path="price"/></td>
		</tr>
		<tr>
			<td><form:hidden path="id"/><form:hidden path="mobile_number"/></td>
			<td><input type="submit" value="Save Changes"/></td>
		</tr>
</table>
</form:form>
</div>
</body>
</html>