<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    
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
<div class=page-title><h1>Edit Food Menu</h1></div>
<div class=page-table>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Name</th><th>Price</th><th></th><th></th></tr>
    <c:forEach var="food" items="${list}"> 
    <tr>
    <td>${food.name}</td>
    <td>Rs.${food.price}</td>
    <td><a href="editfood?id=${food.id}">Edit</a></td>
    <td><a href="deletefood/${food.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
</div>
<div class="page-title"><a href="addmenu"><button class="link-button">Add New Dish</button></a></div>

</body>
</html>