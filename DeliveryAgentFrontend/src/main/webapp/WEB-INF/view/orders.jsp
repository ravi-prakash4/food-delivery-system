<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FOOD KA MOOD | Delivery</title>
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
          <div><a href="/orders"><button>See Orders</button></a></div>
          <div><a href="/logout"><button>Logout</button></a></div>
        </div>
      </nav>
<div class=page-title><h1>Orders</h1></div>
<div class=page-table>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>OrderId</th><th>Items</th><th>Status</th><th>Pickup Address</th><th>Delivery Address</th></tr>
    <c:forEach var="order" items="${orders}"> 
    <tr>
    <td>${order.orderId}</td>
    <td>${order.items}</td>
    <td>${order.status}</td>
    <td>${order.restaurantAddress}</td>
	<td>${order.buyerAddress}</td>
    
    </tr>
    </c:forEach>
    </table>
</div>
    <br/>

</body>
</html>