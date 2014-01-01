<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
<title></title>
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<script src="jquery/development-bundle/ui/jquery.ui.timepicker-addon.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<!-- Bootstrap core CSS -->
<link href="../views/css/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="justified-nav.css" rel="stylesheet">

<script>
	$(function() {
		var availableTags = [ "restaurant", "travel", "sport" ];
		$("#tags").autocomplete({
			source : availableTags
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
	<div class="container">

		<div class="masthead">
			<h3 class="text-muted">Coupon System</h3>
			<ul class="nav nav-justified">
				<li class="active"><a href="../controller/back">Home</a></li>
				<li><a href="../controller/addcoupon" name="addcoupon">ADD-COUPON</a></li>
				<li><a href="../controller/updatecoupon" name="updatecoupon">UPDATE-COUPON</a></li>
				<li><a href="../controller/addbusiness" name="addbusiness">ADD-BUSINESS</a></li>
				<li><a href="../controller/deletebusiness"
					name="deletebusiness">DELETE-BUSINESS</a></li>
				<li><a href="../controller/updatebusiness"
					name="updatebusiness">UPDATE-BUSINESS</a></li>
				<li><a href="../controller/showcoupons" name="showcoupons">SHOW-COUPONS</a></li>
				<li><a href="../controller/logout" name="logout">LOG-OUT</a></li>
			</ul>
		</div>


		<!-- Jumbotron -->
		<div class="jumbotron">
			<h1>Add Coupon</h1>
			<p class="lead"></p>
			<p>
			<form action="../controller/addcoupon" method="POST">
				<p></p>
				<!--  <input id="firstname" class="" name="firstname" type="text"  
value="First Name" onfocus="if (this.value == 'First Name') {this.value = '';}" 
onblur="if (this.value == '') {this.value = 'First Name';}" /> -->
				coupon name: <input type="text" name="couponname"><br>
				coupon id: <input type="text" name="couponid"><br>
				business id: <input type="text" name="businessid"><br>
				description: <input type="text" name="description"><br>
				<!-- category: <input type="text" name="category"><br> -->
				<label for="tags">category: </label> <input type="text" id="tags"
					name="category"><br> price: <input type="text"
					name="price"><br> image: <input type="text"
					name="image"><br>
				<!-- expire date: <input type="text" name="expiredate" value="dd-mm-yyyy" onfocus="if (this.value == 'dd-mm-yyyy') {this.value = '';}" 
onblur="if (this.value == '') {this.value = 'dd/mm/yyyy';}"><br> -->
				expire date: <input id="datepicker" name="expiredate" /><br>
				time :<input type="text" name="time" value="HH-MM-SS"
					onfocus="if (this.value == 'HH-MM-SS') {this.value = '';}"
					onblur="if (this.value == '') {this.value = 'HH-MM-SS';}"><br><br>
				<input type="submit" value="Submit"> <br>
				<%
					Object answer = request.getAttribute("answer");
					if (answer != null)
						out.println(answer + "<br/>\n");
				%>
				<!-- <Button name="subbmit" href="/webstore/controller/coupon" name="coupon">COUPON</Button> -->
			</form>
			
			</p>

		</div>

		<!-- Example row of columns -->
		<div class="row">
			<div class="col-lg-4"></div>
		</div>

		<!-- Site footer -->
		<div class="footer">
			<%@ taglib uri="/WEB-INF/tlds/mytld.tld" prefix="test"%>
			<test:myname firstName="avishay" lastName="hajbi"> developer</test:myname>
			<test:myname firstName="elad" lastName="silvering"> developer</test:myname>
		</div>

	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
</body>
</html>
