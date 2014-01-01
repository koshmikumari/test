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



<!-- Bootstrap core CSS -->
<link href="../views/css/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="justified-nav.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy this line! -->
<!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
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
			<h1>Delete Business</h1>
			<p class="lead"></p>
			<p>
				<form action="../controller/deletebusiness" method="POST">
		business id: <input type="text" name="businessid"><br> 
		<input type="submit" value="Submit">
	</form>
<%
		Object answer = request.getAttribute("answer");
		if (answer != null)
			out.println(answer + "<br/>\n");
%>
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
