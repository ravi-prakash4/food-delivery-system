<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
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
        </div>
      </nav>
      <div class=page-title>
     <div class="loginContainer">
      <form method="post" action="/login">
        <h2 >Please log in</h2>
        
        <c:if test="${param.error != null}">
        	The mobile number or password entered is incorrect.<br>
        	Please try again.
        </c:if>
          <!--<label for="username" >Username</label>-->
          <input type="number" id="username" name="username" class="form-control" placeholder="Mobile Number" required="" autofocus="">
          <!--  <label for="password" >Password</label>-->
          <input type="password" id="password" name="password" class="form-control" placeholder="Password" required="">
<input name="_csrf" type="hidden" value="${_csrf.token}">
        <button type="submit">Login</button>
      </form>
</div>
</div>
</body>
</html>