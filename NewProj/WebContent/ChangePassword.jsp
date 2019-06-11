<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script>
		function validate() {
			var x = document.getElementsByClassName("valid");
			var count = 0;
			var l = [ 20, 20, 20, 20 ];
			for (var i = 0; i < x.length; i++) {
				if (x[i].value == "") {
					x[i].nextElementSibling.innerHTML = "Field cannot be empty";
					x[i].nextElementSibling.style.color = "Red";
					count++;
				}
			}

			for (var i = 0; i < x.length; i++) {
				if (x[i].value.length > l[i]) {
					x[i].nextElementSibling.innerHTML = "large";
					x[i].nextElementSibling.style.color = "Red";
					count++;
				}
			}

			if (x[2].value!=x[3].value)
			{
				
				x[3].nextElementSibling.innerHTML = "Password Do not Match";
				x[3].nextElementSibling.style.color = "Red";
				count++;
			}
			console.log("chet");
			if (count > 0)
				return false;
			else
				return true;

		}
	</script>
<jsp:include page="Header.jsp"></jsp:include>
<div id="wrapper">
<jsp:include page="SideBar.jsp"></jsp:include>

	<div id="content">
			<div class="search"><span>Search</span> <input type="text" /></div>
			<div class="bg">
			</div>

	<form action="LoginServlet" method="post">
		<input type="hidden" name="operation" value="changeP">
		<table>
			<tr>
				<td>Admin</td>
				<td><input type="text" name="email" class="valid"><span></span></td>
			</tr>

			<tr>
				<td>Old Pass</td>
				<td><input type="password" name="oldPass" class="valid"><span></span></td>
			</tr>


			<tr>
				<td>New Pass</td>
				<td><input type="password" name="newPass" class="valid"><span></span></td>
			</tr>

			<tr>
				<td>Conf Pass</td>
				<td><input type="password" name="confPass" class="valid"><span></span></td>
			</tr>


			<tr>
				<td><input type="submit" name="change Password"	onclick="return validate()"><span></span></td>
			</tr>
		</table>

	</form>
	</div>
	</div>
	

<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>