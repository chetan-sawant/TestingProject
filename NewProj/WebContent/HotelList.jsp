<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import ="java.util.List,com.onlineHotel_21718.pojo.Hotel"%>
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
List<Hotel> hlist=(List<Hotel>) session.getAttribute("hotel_List");
//int hotelId= (Integer)session.getAttribute("hotelID");
%>
<jsp:include page="Header.jsp"></jsp:include>
<div id="wrapper">
<jsp:include page="SideBar.jsp"></jsp:include>


			
			<div id="content">
			<div class="search"><span>Search</span> <input type="text" /></div>
			<div class="bg">
			<div class="column1">
			
<div align="center" style:color="black" font-size=50">		
<form>
<table style=color:black ;font-size=50">
<tr>
<td>ID</td>
<td>Name</td>
<td>Location</td>
<td>COntact</td>
</tr>
<%for(Hotel h:hlist) {%>
<tr>
<td><%=h.getHotelId()%></td>
<td><a href="RoomServlet?hotelId=<%=h.getHotelId()%>&operation=getRooms"><%=h.getHotelName()%></a></td>
<%-- <%session.setAttribute("hotelID", hotelId); %> --%>
<td><%=h.getHotelLocation()%></td>
<td><%=h.getHotelContact()%></td>
<td>
<%if(user==null && admin!=null) {%>
<a href="HotelServlet?hotelId=<%=h.getHotelId()%>&operation=update">update</a>
	<a href="HotelServlet?hotelId=<%=h.getHotelId()%>&operation=delete">Delete</a>
<%} %>
<%if (user!=null || admin!=null) {%>
	<a href="HotelServlet?hotelId=<%=h.getHotelId()%>&operation=book">Book</a>
<%} %>
</td>
<td>
<img src="img?hotelId=<%=h.getHotelId() %>"height ="75" width="75">
</tr>
	

<%} %>
</table>
</form>
</div>
	</div>
<%
String status=(String)request.getAttribute("AddSuccess");
if(status!=null){
out.write(status);
}
%>
</div>
	</div>
	</div>



<%-- <jsp:include page="Column2.jsp"></jsp:include> --%>



<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>