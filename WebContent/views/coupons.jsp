<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<%@ page
	import="ac.il.shenkar.couponHibernet.* , java.util.Iterator,java.text.*,java.util.* , antlr.collections.impl.Vector;"%>
<%@ page errorPage="error.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
	<h2>coupons</h2>

	<%
		Object list = request.getAttribute("list");
		Vector v = (Vector) list;
		if (v != null) {
			for (int i = 0; i < v.size(); i++) {

				Coupon tempOb = (Coupon) v.elementAt(i);
	%>

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
			out.println("<br/>"+" <a href=\"shoppingcart.jsp?id="+tempOb.get_id()+"\">buy</a>");
		%>
	</div>

	<%
		}
	}

		Object ob = request.getAttribute("timestamp");
		out.println("<br/>\n" + ob);
	%>
	<br>
	<a href="../controller/index">חזור לדף הראשי</a>
</body>
</html>