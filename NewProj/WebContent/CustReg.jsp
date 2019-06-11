<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Registration</title>
</head>
<body>
<script type="text/javascript">
function validate() {
	var x=document.getElementsByClassName("valid");
	var count=0;
	for(var i=0;i<x.length;i++)
		{
		if(x[i].value=="")
			{
			x[i].nextElementSibling.innerHTML="Field cannot be empty";
			x[i].nextElementSibling.style.color="Red";
			count++;
			}
		}
	if(count>0)
		return false;
	else 
		return true;
	
}

</script>

<jsp:include page="Header.jsp"></jsp:include>
<div id="wrapper">
<jsp:include page="SideBar.jsp"></jsp:include>
<div id="content">
	<div id="content">
			<div class="search"><span>Search</span> <input type="text" /></div>
			<div class="bg">
<form action="CustomerServlet" method="post">
<input type="hidden" name="operation" value="addCustomer">
<div>
<table>
<caption> Registration Form </caption> 
<tr>
<td> Customer Name</td>
<!-- <td> <input type="text" id="hname" > <span id="nameErr" style="color: red"> </span> </td> -->
<td><input type="text" class="valid" name="cname"><span></span>

</tr>

<tr>
<td> Customer Email </td>
<td><input type="text" class="valid" name="cemail"><span></span>
</tr>

<tr>
<td> Password </td>
<td><input type="password" class="valid" name="password"><span></span>
</tr>

<tr>
<td> Address </td>
<td><input type="text" class="valid" name="address"><span></span> 

</tr>

<tr>
<td> contact </td>
<td><input type="text" class="valid" name="contact"><span></span>
</tr>


<tr>
<td><input type="submit" name="submit" value="Add Customer" onclick="return validate()"></td>
<td><input type="reset" name="reset" value="reset"></td>

</table>
</div>
</form>
</div>
</div>
</div>
</div>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>