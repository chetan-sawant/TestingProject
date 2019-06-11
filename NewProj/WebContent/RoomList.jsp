<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import ="java.util.List,com.onlineHotel_21718.pojo.Room"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style.css" />
<title>Insert title here</title>
 <%
String user=(String)session.getAttribute("user");
String admin=(String)session.getAttribute("admin");

%>
</head>
<body>

<%
List<Room> rlist=(List<Room>) session.getAttribute("Room_List");
int hotelId= (Integer)session.getAttribute("hotelID");

%>
<jsp:include page="Header.jsp"></jsp:include>
<div id="wrapper">
<jsp:include page="SideBar.jsp"></jsp:include>
			
			<div id="content">
			<div class="search"><span>Search</span> <input type="text" /></div>
			<div class="bg">
			<div class="column1">
			<div align="center" style="color: blue; font-size: 50">
			<h2>${AddSucces }</h2>
			<h2>${Failed }</h2>
			</div>
<div align="center" style:color="black" font-size=50">		
<form action ="AddRooms.jsp">
<%if(rlist.size()>0) {%>

<input type="hidden" name="hotelId" value=<%=hotelId%>>

<table style=color:black ;font-size=50">

<tr>
<td>ID</td>
<td>Room Type</td>
<td>Room Charges</td>
<td>Room Number</td>
</tr>
<%for(Room r:rlist) {%>
<tr>
<td><%=r.getRoomId()%></td>
<td><%=r.getRoomType()%></td>
<td><%=r.getRoomCharge()%></td>
<td><%=r.getRoomNumbers()%></td>
<td>
<%if(user==null && admin!=null) {%>
<a href="RoomServlet?hotelId=<%=r.getHotelId()%>&operation=update">update</a>
	<a href="RoomServlet?hotelId=<%=r.getHotelId()%>&operation=delete">Delete</a>
<%} %>
<%if (user!=null || admin!=null) {%>
	<a href="Booking.jsp?roomId=<%=r.getRoomId() %>">Book</a>
<%} %>
</tr>
<%} %>
</table>

<%} %>
<%if(user==null && admin!=null) {%>
<input type="submit" value="Add New">
<%} %>
</form>
</div>
	</div>
<%-- <%
String status=(String)request.getAttribute("AddSuccess");
if(status!=null){
out.write(status);
}
%> --%>

</div>
	</div>
	</div>



<%-- <jsp:include page="Column2.jsp"></jsp:include> --%>



<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>