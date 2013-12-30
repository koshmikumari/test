<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
 <%@ page import="ac.il.shenkar.couponHibernet.* , java.util.Iterator,java.text.*,java.util.* ;" %>
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
		if (size == null)
		out.println("0 coupons found:<br>");
		else out.println(size+" coupons found:<br>");

		if (v != null){
		for (int i = 0; i < v.size(); i++) {
			Coupon tempOb = (Coupon)v.elementAt(i);
	%>
	
	<br>
	<br>
	<br>

	<h3>Coupon details</h3>
			image: <img src="../views/<%out.print((tempOb).get_image());%>" width="100" height="100"><br>
	
	<%
			out.print("category: "+(tempOb).get_category()+"<br>");
			out.print("price: "+(tempOb).get_price()+"<br>");
			out.print("expire date: "+(tempOb).get_expire_date()+"<br>");
	%>


	<div>
		<%
			out.print("coupon id: "+(tempOb).get_id()+"<br>");
			out.print("description: "+(tempOb).get_description());
		%>
	</div>
	
	<form action="/webstore/controller/updateCouponPreview" method="POST">
		<input type="hidden" name="couponid"
			value="<%out.print((tempOb).get_id());%>"> 
			<input type="submit" value="update">
	</form>

	<form action="/webstore/controller/deleteCouponPreview" method="POST">
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