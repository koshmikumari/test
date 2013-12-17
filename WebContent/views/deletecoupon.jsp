<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
	<%@ page import="ac.il.shenkar.couponHibernet.*"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
	<h1>delete coupon</h1>

	<form action="/webstore/controller/deletecoupon" method="POST">
		coupon id: <input type="text" name="couponId"><br> <input
			type="submit" value="Submit">
	</form>
<%
		Object answer = request.getAttribute("answer");
		if (answer != null)
			out.println(answer + "<br/>\n");
%>
<a href="../controller/logout">התנתק</a>
<a href="../controller/back">חזרה</a>
</body>
</html>