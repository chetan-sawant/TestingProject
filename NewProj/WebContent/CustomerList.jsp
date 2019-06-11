<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import ="java.util.List,com.onlineHotel_21718.pojo.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String user=(String)session.getAttribute("user");
String admin=(String)session.getAttribute("admin");

%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div id="wrapper">
<jsp:include page="SideBar.jsp"></jsp:include>
<div id="content">
	<div id="content">
			<div class="search"><span>Search</span> <input type="text" /></div>
			<div class="bg">
			</div>
<%
List<Customer> clist=(List<Customer>) session.getAttribute("customer_List");
%>

<form>
<table style=color:black>
<tr>
<td>ID</td>
<td>Name</td>
<td>Location</td>
<td>COntact</td>
</tr>
<%for(Customer c:clist) {%>
<tr>
<td><%=c.getCustId()%></td>
<td><%=c.getCustName()%></td>
<td><%=c.getCustEmail() %></td>
<td><%=c.getCustAddress()%></td>
<td><%=c.getCustContact()%></td>
<td>
<%-- <% if(user==null && admin!=null) {%>
	<a href="CustomerServlet?custEmail=<%=c.getCustEmail()%>&operation=update">update</a>
	<%} %> --%>
	<a href="CustomerServlet?custId=<%=c.getCustId()%>&operation=delete"> >Deletes</a>
</tr>
<%} %>
</table>
</form>
<div align="center" style="color: blue; font-size: 50">
<h2>${Success }</h2>
</div>
</div>
</div>
</div>


<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>