<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The Elite</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>

<jsp:include page="Header.jsp"></jsp:include>
<div id="wrapper">
<jsp:include page="SideBar.jsp"></jsp:include>
<div id="content">
<%-- <jsp:include page="SideBar.jsp"></jsp:include> --%>
<script>
function validate() {
	var x=document.getElementsByClassName("valid");
	var count=0;
	var l=[20,20,10]
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

</script>
	<div id="content">
			<div class="search"><span>Search</span> <input type="text" /></div>
			<div class="bg">
				
<form action="LoginServlet" method="post">
<input type="hidden" name="operation" value="login">
<table center="center">
<tr>
<td>Type</td>
<td><input type="radio" name="type" value="user" >User
	<input type="radio" name="type" value="admin" >Admin</td>
</tr>

<tr>
<td>Login id</td>
<td><input type="text" name="userid"></td>
</tr>

<tr>
<td>Password</td>
<td><input type="password" name="password"></td>
</tr>

<tr>
<td><input type="submit" value="submit" onclick="return validate()"></td>
<td><input type="reset" value="clear"></td>
</tr>

<tr>
<td><input type ="button" value ="ChangePassword.jsp" ></td>
</tr>
</table>
</form>


<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>