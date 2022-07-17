<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
          <div><a href="/seeRestaurants"><button>See Restaurants</button></a></div>
          <div><a href="/seeOrders"><button>See Orders</button></a></div>
          <div><a href="/editProfile"><button>Edit Profile</button></a></div>
          <div><a href="/logout"><button>Logout</button></a></div>
        </div>
      </nav>
<div class=page-title><h1>Restaurant Menu : ${restaurantName} </h1></div>
<div class=page-table>
<form:form modelAttribute="orderItems" action="placeOrder?mobileNumber=${mobileNumber}" method="POST">
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Dish</th><th>Price</th><th>Quantity</th></tr>
	<c:forEach var="orderItem" items="${orderItems.orderItemsList}" varStatus="status">
		<tr>
			<td>${orderItem.name}</td>
			<td>Rs.${orderItem.price}</td>
			<td>
			<form:hidden path="orderItemsList[${status.index}].dishId" name="dishId" id="dishId" value="${orderItem.dishId}" />
			<form:hidden path="orderItemsList[${status.index}].name" name="name" id="name" value="${orderItem.name}" />
			<form:input path="orderItemsList[${status.index}].quantity" name="quantity" id="quantity" value="${orderItem.quantity}" />
			<form:hidden path="orderItemsList[${status.index}].price" name="price" id="price" value="${orderItem.price}" />
			</td>
		</tr>
	</c:forEach>
	</table>
	<input type="submit" value="Place Order"/>
</form:form>
</div>

</body>
</html>