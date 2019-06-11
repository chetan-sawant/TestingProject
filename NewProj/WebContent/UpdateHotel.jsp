<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.onlineHotel_21718.pojo.Hotel"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Hotel</title>
</head>
<body>
	<script>
		function validate() {
			var x = document.getElementsByClassName("valid");
			var count = 0;
			var l = [ 20, 20, 10 ]
			for (var i = 0; i < x.length; i++) {
				if (x[i].value == "") {
					x[i].nextElementSibling.innerHTML = "Field cannot be empty";
					x[i].nextElementSibling.style.color = "Red";
					count++;
				}
			}
			if (count == 0) {
				for (var i = 0; i < x.length; i++) {
					if (x[i].value.length > l[i]) {
						x[i].nextElementSibling.innerHTML = "large";
						x[i].nextElementSibling.style.color = "Red";
						count++;
					}
				}
			}
			if (count > 0)
				return false;
			else
				return true;

		}
	</script>

	<%
		Hotel h = (Hotel) session.getAttribute("hotel");
	%>
	<form action="HotelServlet" method="post" enctype="multipart/form-data">
		<input type="hidden" name="operation" value="updateHotel">
		<div align="center">
			<table>
				<caption>Hotel Details</caption>
				<tr>
					<td>Hotel ID</td>
					<td><input type="text" class="valid" name="hid"
						readonly="readonly" value=<%=h.getHotelId()%>><span></span>
				</tr>

				<tr>
					<td>Hotel Name</td>
					<!-- <td> <input type="text" id="hname" > <span id="nameErr" style="color: red"> </span> </td> -->
					<td><input type="text" class="valid" name="hname"
						value="<%=h.getHotelName()%>"><span></span>
				</tr>
				<tr>
					<td>Hotel Location</td>
					<td><input type="text" class="valid" name="location"
						value="<%=h.getHotelLocation()%>"><span></span>
				</tr>

				<tr>
					<td>Contact Number</td>
					<td><input type="text" class="valid" name="contactnumber"
						value="<%=h.getHotelContact()%>"><span></span>
				</tr>

				<tr>
					<td>Hotel Image</td>
					<td><img src="img?hotelId=<%=h.getHotelId() %>"height ="75" width="100"></td>
					<td><input type="file" size=300 name="hotelImage"><span></span></td>
				</tr>

				<tr>
					<td><input type="submit" name="submit" value="Update Hotel"
						onclick="return validate()"></td>
					<td><input type="reset" name="reset" value="reset"></td>
			</table>
		</div>
	</form>


</body>
</html>