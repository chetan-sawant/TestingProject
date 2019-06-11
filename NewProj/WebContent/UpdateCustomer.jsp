<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.onlineHotel_21718.pojo.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Registration</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div id="wrapper">
<jsp:include page="SideBar.jsp"></jsp:include>
<div id="content">
<div class="search"><span>Search</span> <input type="text" /></div>
</div>
			<div class="bg">
			<div align="center" style="color:blue;font-size:50">	
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
<%Customer c=(Customer)session.getAttribute("customer"); %>
<form action="CustomerServlet" method="post">
<input type="hidden" name="operation" value="updateCustomer">
<center>
<table>
<caption> Update Customer Form </caption> 

<tr>
<td> Customer ID </td>
<td><input type="text" class="valid" name="cid" readonly="readonly" value=<%=c.getCustId() %>><span></span>
</tr>
<tr>
<td> Customer Name</td>
<!-- <td> <input type="text" id="hname" > <span id="nameErr" style="color: red"> </span> </td> -->
<td><input type="text" class="valid" name="cname" value="<%=c.getCustName()%>"><span></span>

</tr>

<tr>
<td> Customer Email </td>
<td><input type="text" class="valid" name="cemail" value=<%=c.getCustEmail() %>><span></span>
</tr>

<tr>
<td> Set New Password </td>
<td><input type="password" class="valid" name="password" value=<%=c.getCustPass() %> ><span></span>
</tr>

<tr>
<td> Address </td>
<td><input type="text" class="valid" name="address" value=<%=c.getCustAddress() %>><span></span> 

</tr>

<tr>
<td> contact </td>
<td><input type="text" class="valid" name="contact" value=<%=c.getCustContact() %>><span></span>
</tr>

<tr>
<td><input type="submit" name="submit" value="Add Customer" onclick="return validate()"></td>
<td><input type="reset" name="reset" value="reset"></td>

</table>
</center>
</form>
</div>
</div>
</div>


<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>