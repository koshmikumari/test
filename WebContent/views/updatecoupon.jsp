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
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    var availableTags = [
      "resterant",
      "travel",
      "sport"
    ];
    $( "#tags" ).autocomplete({
      source: availableTags
    });
  });
  </script>
  <script>
  $(document).ready(function() {
    $("#datepicker").datepicker();
  });


  </script>
</head>
<body>


<form action="/webstore/controller/updatecoupon" method="POST" >
<p>update coupon</p>
<!--  <input id="firstname" class="" name="firstname" type="text"  
value="First Name" onfocus="if (this.value == 'First Name') {this.value = '';}" 
onblur="if (this.value == '') {this.value = 'First Name';}" /> -->

coupon id: <input type="text" name="couponid" value="(importent)" onfocus="if (this.value == '(importent)') {this.value = '';}" 
onblur="if (this.value == '') {this.value = '(importent)';}"><br>
business id: <input type="text" name="businessid"><br>
description: <input type="text" name="description"><br>
<label for="tags">category: </label> <input type="text" id="tags" name="category"><br>
price: <input type="text" name="price"><br>
image: <input type="text" name="image"><br>
<!-- expire date: <input type="text" name="expiredate" value="dd-mm-yyyy" onfocus="if (this.value == 'dd-mm-yyyy') {this.value = '';}" 
onblur="if (this.value == '') {this.value = 'dd-mm-yyyy';}"><br>-->
expire date: <input id="datepicker" name= "expiredate"/><br>
time :<input type="text" name="time" value="HH-MM-SS" onfocus="if (this.value == 'HH-MM-SS') {this.value = '';}" 
onblur="if (this.value == '') {this.value = 'HH-MM-SS';}"><br>
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
<a href="../controller/back">חזרה</a>
</body>
