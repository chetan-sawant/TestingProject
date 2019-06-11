<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hotel Registration</title>
</head>
<body>
	<script>
		/* function validate() 
		 {
		 var name=document.getElementById("hname").value;
		 var count=0;
		 if(name=="")
		 {
		 document.getElementById("nameErr").innerHTML="Hotel name cannot be empty";
		 count++;
		 }
		 if(count>0)
		 return false;
		 else 
		 return true;
		
		
		 } */

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

	<jsp:include page="Header.jsp"></jsp:include>
	<div id="wrapper">
		<jsp:include page="SideBar.jsp"></jsp:include>



		<div id="content">
			<div class="search">
				<span>Search</span> <input type="text" />
			</div>
			<div class="bg">
				<div class="column1">

					<div align="center" style:color="black" font-size=50">
						<form action="HotelServlet" method="post" enctype="multipart/form-data">
							<input type="hidden" name="operation" value="addHotel">
							<div align="center">
								<table>
									<caption>Registration Form</caption>
									<tr>
										<td>Hotel Name</td>
										<!-- <td> <input type="text" id="hname" > <span id="nameErr" style="color: red"> </span> </td> -->
										<td><input type="text" class="valid" name="hname"><span></span>
									</tr>

									<tr>
										<td>Hotel Location</td>
										<td><input type="text" class="valid" name="location"><span></span>
									</tr>

									<tr>
										<td>Contact Number</td>
										<td><input type="text" class="valid" name="contactnumber"><span></span>
									</tr>
		
									<tr>
										<td>Hotel Image</td>
										<td><input type="file" size=300 name="hotelImage"><span></span>
									</tr>
									<tr>
										<td><input type="submit" name="submit" value="Update"
											onclick="return validate()"></td>
										<td><input type="reset" name="reset" value="reset"></td>
								</table>
							</div>
						</form>

					</div>
				</div>
			</div>



			<%-- <jsp:include page="Column2.jsp"></jsp:include> --%>


</div>
</div>
			<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>