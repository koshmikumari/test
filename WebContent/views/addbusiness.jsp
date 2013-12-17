<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
    <%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
  <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
  <script src="jquery/development-bundle/ui/jquery.ui.timepicker-addon.js"></script>
  <script>
  $(document).ready(function() {
    $("#datepicker").datepicker();
  });


  </script>
</head>
<body>

<form action="/webstore/controller/addbusiness" method="POST" >
<p>adding business</p>
<!--  <input id="firstname" class="" name="firstname" type="text"  
value="First Name" onfocus="if (this.value == 'First Name') {this.value = '';}" 
onblur="if (this.value == '') {this.value = 'First Name';}" /> -->

business name: <input type="text" name="businessname" ><br>
business id: <input type="text" name="businessid"><br>
address: <input type="text" name="address"><br>
city: <input type="text" name="city"><br>
phone: <input type="text" name="phone"><br>
latitude: <input type="text" name="latitude"><br>
longitude: <input type="text" name="longitude"><br>
<input type="submit" value="Submit">
<br>
<%
Object answer = request.getAttribute("answer");
if (answer!=null)
out.println( answer+ "<br/>\n" );
%>
<!-- <Button name="subbmit" href="/webstore/controller/coupon" name="coupon">COUPON</Button> -->
</form>
<a href="../controller/logout">התנתק</a>
<a href="../controller/back">חזרה</a></body>
