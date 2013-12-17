<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
    <%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>

<form action="/webstore/controller/loggedin" method="POST" >
<p>login</p>
user name: <input type="text" name="username"><br>
password: <input type="text" name="password"><br>
<input type="submit" value="Submit">
<br>
<%
Object answer = request.getAttribute("answer");
if (answer != null)
out.println( answer+ "<br/>\n" );
%>
<!-- <Button name="subbmit" href="/webstore/controller/coupon" name="coupon">COUPON</Button> -->
</form>
<a href="../controller/index">חזור לדף הבית</a>
</body>
</html>