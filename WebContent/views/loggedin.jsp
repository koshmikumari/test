<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
    <%@ page errorPage="error.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>login</title>
</head>
<body>
	<h2>logged in</h2>
<%
	Object usernameweb = request.getAttribute("usernameweb");
	if (usernameweb != null)
	{
		out.println("wellcom " +usernameweb);
	}

	Object time = request.getAttribute("timestamp");
	if (time != null)
	out.println( " now is "+time);
%>

<br>
<a href="../controller/addcoupon" name="addcoupon">ADD-COUPON</a><br>
<a href="../controller/deletecoupon" name="deletecoupon">DELETE-COUPON</a><br>
<a href="../controller/updatecoupon" name="updatecoupon">UPDATE-COUPON</a><br>
<a href="../controller/addbusiness" name="addbusiness">ADD-BUSINESS</a><br>
<a href="../controller/deletebusiness" name="deletebusiness">DELETE-BUSINESS</a><br>
<a href="../controller/updatebusiness" name="updatebusiness">UPDATE-BUSINESS</a><br>
<a href="../controller/showcoupons" name="showcoupons">SHOW-COUPONS</a><br>
<a href="../controller/logout" name="logout">LOG-OUT</a><br>
<%
	Object actionAnswer = request.getAttribute("actionAnswer");
	if (actionAnswer!=null)
	out.println( actionAnswer+ "<br/>\n" );
	
%>
</body>
</html>