<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Rooms</title>
</head>
<body>
<%
//int hotelId=Integer.parseInt(request.getParameter("hotelId"));
int hotelId= (Integer)session.getAttribute("hotelID");
%>
<script type="text/javascript">

</script>



<form action="RoomServlet" method="post">
<input type="hidden" name="hotelId" value="<%=hotelId%>">
<input type="hidden" name="hotelId" value="addRoom">
<div align="center">
<table>
<caption> Registration Form </caption> 
<tr>
<td> Hotel Id</td>
<!-- <td> <input type="text" id="hname" > <span id="nameErr" style="color: red"> </span> </td> -->
<td><input type="text" class="valid" name="hId" value="<%=hotelId%>" readonly="readonly"><span></span>
<%System.out.println(hotelId); %>

</tr>

<tr>
<td> room Type </td>
<td><select name="type">
<option value="Standard">Standard</option>
<option value="Deluxe">Deluxe</option>
 

</select>
</td>
</tr>

<tr>
<td> Room charge </td>
<td><input type="text" class="valid" name="charge"><span></span>
</tr>

<tr>
<td> Number of rooms </td>
<td><input type="text" class="valid" name="number"><span></span> 

</tr>


<tr>
<td><input type="submit" name="submit" value="Add rooms" onclick="RoomServlet"></td>
<td><input type="reset" name="reset" value="reset"></td>

</table>
</div>
</form>


</body>
</html>