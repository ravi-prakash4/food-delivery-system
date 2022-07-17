<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<div class=page-title><h1>Restaurants In Your City : ${userCity}</h1></div>
<div class=page-table>
<table border="2" width="70%" cellpadding="2">
	<c:forEach var="restaurant" items="${restaurants}">
		<tr>
			<td><a href="seeRestaurant?mobileNumber=${restaurant.mobileNumber}&name=${restaurant.name}">${restaurant.name}</a></td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>