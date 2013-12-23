<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
    <%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>

<%@ taglib uri="/WEB-INF/tlds/mytld.tld" prefix="test" %>
<test:myname firstName="avishay" lastName="hajbi"> developer</test:myname>
<test:myname firstName="elad" lastName="silvering"> developer</test:myname>

<body>
<a href="../controller/help" name="help">HELP</a><br>
<a href="../controller/about" name="about">ABOUT</a><br>
<a href="../controller/selectcoupon" name="selectcoupon">SELECT-COUPON</a><br>
<a href="../controller/register" name="register">REGISTER</a><br>
<a href="../controller/login" name="login">LOGIN</a><br>
<a href="../controller/contact" name="contact">CONTACT</a><br>
<a href="../controller/coupons" name="coupons">COUPONS</a><br>
<a href="../controller/closestcoupons" name="closestcoupons">CLOSEST-COUPONS</a><br>
<a href="../controller/categories" name="categories">CATEGORIES</a><br>
<a href="../controller/shoppingcart" name="shoppingcart">SHOPPING-CART</a><br>


</body>
</html>