<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<%@ page errorPage="error.jsp"%>
 <%@ page import="ac.il.shenkar.couponHibernet.* , java.util.Iterator,java.text.*,java.util.* , antlr.collections.impl.Vector;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>

	<form action="/webstore/controller/closestcoupons" method="POST">
		longitude: <input type="text" name="longitude"><br> 
		latitude: <input type="text" name="latitude"><br>
		<!-- radius (m): <input type="text" name="radius" value="1000" onfocus="if (this.value == '1000') {this.value = '';}" 
		onblur="if (this.value == '') {this.value = '1000';}"><br> -->
		<input type="submit" value="Submit">
		<!-- <Button name="subbmit" href="/webstore/controller/coupon" name="coupon">COUPON</Button> -->
	</form>
	<%
		Object answer = request.getAttribute("answer");
		Object list = request.getAttribute("list");
		Vector v = (Vector)list;
		String ans = (String)answer;
		if (ans != null)
			out.println(answer + "<br/>\n ");
		if (v != null)
		{
			for (int i=0; i < v.size();i++)
			{
	
				Coupon tempOb = (Coupon)v.elementAt(i);
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
			out.println("<br/>"+"<a href=\"shoppingcart.jsp?id="+tempOb.get_id()+"\">buy</a>"+"<br/>");

		%>
	</div>
			
			
			<%
			}
		}
		
	%>
	<a href="../controller/index">חזור לדף הראשי</a> 

</body>
</html>