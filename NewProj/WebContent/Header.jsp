<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<%
String user=(String)session.getAttribute("user");
String admin=(String)session.getAttribute("admin");

%>
</head>
<body>
	<div id="header">
		<div class="login">
			<!-- <input type="text" class="input" value="Login" /> <input type="text" class="input" value="Password" /> -->


			<c:if test="${user==null&&admin==null }">
				<div class="enter">
					<a href="Login.jsp">Login</a>
				</div>
				<a href="CustReg.jsp">Registration</a>
		</div>

			</c:if>


		<c:if test="${ user!=null||admin!=null}">
			<div>
				<a href="LoginServlet">Log out</a>
			</div>
		</c:if>
	</div>
	<ul id="menu">
		<li><a href="index.jsp">Home page</a></li>
		<li><a href="HotelServlet">Hotels</a></li>
		
		<c:if test="${admin!=null}">
		
		<li><a href="HotelReg.jsp">Add Hotels</a></li>
		<li><a href="CustomerServlet">Customer List</a></li>
		<li><a href="ChangePassword.jsp">Change Password</a></li>

		
		</c:if>



		<%if(user!=null && admin==null) {%>
		<li><a href="CustomerServlet?operation=getCust">Edit Profile</a></li>
		<% }%>
		<li><a href="index.jsp">Contact us</a></li>
	</ul>

</body>
</html>