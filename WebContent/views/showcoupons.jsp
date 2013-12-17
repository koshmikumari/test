<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
 <%@ page import="ac.il.shenkar.couponHibernet.* , java.util.Iterator,java.text.*,java.util.* , antlr.collections.impl.Vector;" %>
    <%@ page errorPage="error.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
<title></title>
</head>
<body>
	<h2>show coupons</h2>

	<%
		Object size = request.getAttribute("size");
		Object list = request.getAttribute("vec");
		Vector v = (Vector)list;
		out.println(size+" coupons founded:<br>");
		if (v != null){
		for (int i = 0; i < v.size(); i++) {
			Coupon tempOb = (Coupon)v.elementAt(i);
	%>
	
	<br>
	<br>
	<br>

	<h3>Coupon details</h3>
	<%
			out.print("image: "+(tempOb).get_image()+"<br>");
			out.print("category: "+(tempOb).get_category()+"<br>");
			out.print("price: "+(tempOb).get_price()+"<br>");
			out.print("expire date: "+(tempOb).get_expire_date()+"<br>");
	%>
	<div>
		<img src="../views/<%out.print((tempOb).get_image());%>" width="10">
	</div>

	<div>
		<%
			out.print("coupon id: "+(tempOb).get_id()+"<br>");
			out.print("description: "+(tempOb).get_description());
		%>
	</div>

	<form action="../controller/updateCouponPreview" method="get">
		<input type="hidden" name="couponId"
			value="<%out.print((tempOb).get_id());%>"> 
			<input type="submit" value="update">
	</form>

	<form action="../controller/deleteCouponPreview" method="get">
		<input type="hidden" name="couponid"
			value="<%out.print((tempOb).get_id());%>"> 
			<input type="submit" value="delete">
	</form>

	<br>
	<br>

	<%
			}
		}
	%>
<a href="../controller/logout">התנתק</a>
<a href="../controller/back">חזרה</a></body>
</html>