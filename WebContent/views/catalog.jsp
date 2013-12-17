<%@ page import="ac.il.shenkar.couponHibernet.* , java.util.Iterator,java.text.*,java.util.* , antlr.collections.*;" %>
<%@ page errorPage="error.jsp"%>
<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>products catalog</title>
</head>
<body>
	<h3>products catalog</h3>
	<%
	 
		Iterator<Coupon> iterator =  DAO.getInstance().getAllCoupons();
		while(iterator.hasNext())
		{
			Coupon coupon = iterator.next();
			out.println("<br/>"+coupon.get_name()+" "+coupon.get_description()+" $"+coupon.get_price()+" <a href=\"shoppingcart.jsp?id="+coupon.get_id()+"\">buy</a>");
		}
	
	
	
	%>
</body>
</html>