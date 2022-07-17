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
<div class=page-title><h1>Add Dish</h1></div>
<div class=page-title>
<form:form action="add" method="post">
<table>
<!-- Id : <input type="text" name="id">
Mobile_Number : <input type="number" name="mobile_number"> -->
<tr><td>Dish Name : </td><td><input type="text" name="name" /> </td></tr>
<tr><td>Price :</td><td><input type="number" name="price" />  </td><tr>
<tr><td></td><td><input type="submit" value="Add Dish" /></td></tr>
</table>			
</form:form>			
</div>
</body>
</html>