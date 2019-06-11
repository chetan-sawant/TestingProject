<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
	<script>
		
	</script>
	<jsp:include page="Header.jsp"></jsp:include>
	<div id="wrapper">
		<jsp:include page="SideBar.jsp"></jsp:include>



		<div id="content">
			<div class="search">
				<span> Search</span> <input type="text" />
			</div>
			<div align="center" style="color: blue; font-size: 50">
				<%--  <%
					String status = (String) request.getAttribute("success");
					if (status != null) {
						out.write(status);
					}
				%> --%> 
				<h2 align="left">${success }</h2>
			</div>
			<div class="bg">
				<div class="column1">
					<img src="images/title2.gif" alt="" width="258" height="21" /><br />
					<p>Lorem ipsum dolor sit amet, sectetu adip scing varius
						interdum incid unt quis, libero. Aenean mturpis. Maecenas
						hendrerit masa laoreet iaculipede mnisl ulamcorper. Tellus er
						sodales enim, in tincidunt mauris in odio. Massa ac laoreet
						iaculipede nisl ullamcorpermassa, ac consectetuer feipsum eget
						pede. Proin nunc. Donec massa. Nulla pulvinar, nisl ac convallis
						nonummy, tellus eros sodales enim, in tincidunt mauris in odio.
						massa ac laoreet iaculipede nisl ullamcorpermassa,consectetuer
						feipsum eget pede. Proin nunc. Donec massa. Nulla pulvinar, nisl
						ac convallis nonummy, tellus eros sodales enim, in tincidunt
						mauris in odi. Lorem ipsum dolor sit amet, consectetuer adipi
						scing elit.Mauris u tincidunt quis, libero.</p>
					<img src="images/title3.gif" alt="" width="258" height="21" /><br />
					<div id="items">
						<div class="item">
							<a href="#"><img src="images/pic1.jpg" alt="" /></a> <span><a
								href="#">Australia</a></span>
						</div>
						<div class="item">
							<a href="#"><img src="images/pic2.jpg" alt="" /></a> <span><a
								href="#">Miami</a></span>
						</div>
						<div class="item">
							<a href="#"><img src="images/pic3.jpg" alt="" /></a> <span><a
								href="#">Canada</a></span>
						</div>
						<div class="item">
							<a href="#"><img src="images/pic3.jpg" alt="" /></a> <span><a
								href="#">Maldives</a></span>
						</div>
					</div>
				</div>
				<div class="column2">
					<img src="images/title4.gif" alt="" width="133" height="18" /><br />
					<div class="news">
						<span>24 may 0000</span><br />
						<p>Lorem ipsum dolor sit amet, sectetu adip scing varius
							interdum incid unt quis, libero. Aenean mturpis. Maecenas
							hendrerit masa laoreet iaculipede mnisl ulamcorper. Tellus er
							sodales enim, in tincidunt mauris in odio. Massa ac laoreet
							iaculipede nisl.</p>
						<a href="#" class="more">more info</a>
					</div>
					<div class="news">
						<span>12 may 0000</span><br /> <img src="images/pic5.jpg" alt=""
							width="183" height="97" />
						<p>Proin nunc. Donec massa. Nulla pulvinar, nisl ac convallis
							nonummy, tellus eros sodales enim, in tincidunt mauris in odio.
							massa ac laoreet iaculipede nisl ullamcorpermassa,consectetuer</p>
						<a href="#" class="more">more info</a>
					</div>
				</div>
			</div>
		</div>
	</div>



	<%-- <jsp:include page="Column2.jsp"></jsp:include> --%>



	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>