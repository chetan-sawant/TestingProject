<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Booking</title>
</head>
<body>

<jsp:include page="Header.jsp"></jsp:include>
<div id="wrapper">
<jsp:include page="SideBar.jsp"></jsp:include>
<div id="content">
<script type="text/javascript">
function validate() {
	var x=document.getElementsByClassName("valid");
	var count=0;
	var l=[11,30,10,10,11]
	for(var i=0;i<x.length;i++)
		{
		if(x[i].value=="")
			{
			x[i].nextElementSibling.innerHTML="Field cannot be empty";
			x[i].nextElementSibling.style.color="Red";
			count++;
			}
		}
	if(count==0)
		{
			for(var i=0;i<x.length;i++)
				{
				if(x[i].value.length>l[i])
					{
					x[i].nextElementSibling.innerHTML="large";
					x[i].nextElementSibling.style.color="Red";
					count++;
					}
				}
		}
	if(count>0)
		return false;
	else 
		return true;
	
}

function clearup(c)
{
	if(c.value!="")
		{
		c.nextElementSibling.innerHTML="";
		}
	
}

</script>


<div id="content">
			<div class="search"><span>Search</span> <input type="text" /></div>
			<div class="bg">
</div>
<%
int roomId=Integer.parseInt(request.getParameter("roomId"));
%>
<form action="BookingServlet" method="post">
<input type="hidden" name="roomId" value="<%=roomId %>">
<div align="center">
<table>
<caption> Registration Form </caption> 
<tr>
<!-- <td> Room Id</td>
<td> <input type="text" id="hname" > <span id="nameErr" style="color: red"> </span> </td>
<td><input type="text" class="valid" onblur="clearup(this)"><span></span>

</tr> -->

<tr>
<<!-- td> customer Email </td>
<td><input type="text" class="valid" onblur="clearup(this)"><span></span> -->
<!-- <td><select>
<option value="Standard">Standard</option>
<option value="Deluxe">Deluxe</option>
 
</td>
</select> -->

</tr>

<tr>
<td> StartDate </td>
<td><input type="text" class="valid" name="start" ><span></span>
</tr>

<tr>
<td> EndDate </td>
<td><input type="text" class="valid" name="end"><span></span> 

</tr>

<tr>
<td> Number of rooms </td>
<td><input type="text" class="valid" min=1 name="roomsCount"><span></span> 

</tr>
<tr>
<td><input type="submit" name="submit" value="Add booking" onclick="return validate()"></td>
<td><input type="reset" name="reset" value="reset"></td>

</table>
</div>
</form>
</div>



<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>