<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>

	<form action="/webstore/controller/selectcoupon" method="POST">
		coupon id: <input type="text" name="couponId"><br> <input
			type="submit" value="Submit">
		<!-- <Button name="subbmit" href="/webstore/controller/coupon" name="coupon">COUPON</Button> -->
	</form>
	<%
		Object answer = request.getAttribute("answer");
		Object couponid = request.getAttribute("couponid");
		String ans = (String) answer;
		if (ans != null)
		{
			out.println(answer);
			if(couponid != null)
			out.println(" <a href=\"shoppingcart.jsp?id="+couponid+"\">buy</a>"+"<br/>");
		}
	%>
	<a href="../controller/index">חזור לדף הראשי</a>
</body>
</html>