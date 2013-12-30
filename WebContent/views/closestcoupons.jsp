<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
    <%@ page errorPage="error.jsp" %>
    <%@ page import="ac.il.shenkar.couponHibernet.* , java.util.Iterator,java.text.*,java.util.* , antlr.collections.impl.Vector;" %>
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
    <link href="/webstore/views/css/bootstrap.css" rel="stylesheet">

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
          <li class="active"><a href="../controller/index">Home</a></li>
          <li><a href="../controller/selectcoupon" name="selectcoupon">SELECT-COUPON</a></li>
          <li><a href="../controller/coupons" name="coupons">COUPONS</a></li>
          <li><a href="../controller/closestcoupons" name="closestcoupons">CLOSEST-COUPONS</a></li>
		  <li><a href="../controller/categories" name="categories">CATEGORIES</a></li>
          <li><a href="../controller/help" name="help">HELP</a></li>
		  <li><a href="../controller/about" name="about">ABOUT</a></li>
		  <li><a href="../controller/contact" name="contact">CONTACT</a></li>
        </ul>
      </div>


      <!-- Jumbotron -->
      <div class="jumbotron">
        <h1></h1>
        <p class="lead"></p>
        <p>
        	<form action="/webstore/controller/closestcoupons" method="POST">
		longitude: <input type="text" name="longitude"><br> 
		latitude: <input type="text" name="latitude"><br>
		<!-- radius (m): <input type="text" name="radius" value="1000" onfocus="if (this.value == '1000') {this.value = '';}" 
		onblur="if (this.value == '') {this.value = '1000';}"><br> -->
		<input type="submit" value="Submit">
		<!-- <Button name="subbmit" href="/webstore/controller/coupon" name="coupon">COUPON</Button> -->
	</form>
	<%
		Object answer = request.getAttribute("answer");
		Object list = request.getAttribute("list");
		Vector v = (Vector)list;
		String ans = (String)answer;
		if (ans != null)
			out.println(answer + "<br/>\n ");
		if (v != null)
		{
			for (int i=0; i < v.size();i++)
			{
	
				Coupon tempOb = (Coupon)v.elementAt(i);
			%>
			
				<h3>Coupon details</h3>
	<%
			out.print("image: "+(tempOb).get_image()+"<br>");
			out.print("category: "+(tempOb).get_category()+"<br>");
			out.print("price: "+(tempOb).get_price()+"<br>");
			out.print("expire date: "+(tempOb).get_expire_date()+"<br>");
	%>
	<div>
		<img src="../views/<%out.print((tempOb).get_image());%>" width="10">
	</div>

	<div>
		<%
			out.print("coupon id: "+(tempOb).get_id()+"<br>");
			out.print("description: "+(tempOb).get_description());
			out.println("<br/>"+"<a href=\"shoppingcart.jsp?id="+tempOb.get_id()+"\">buy</a>"+"<br/>");

		%>
	</div>
			
			
			<%
			}
		}
		
	%>
        
        </p>
      </div>

      <!-- Example row of columns -->
      <div class="row">
        <div class="col-lg-4">
        </div>
      </div>

      <!-- Site footer -->
      <div class="footer">
        <%@ taglib uri="/WEB-INF/tlds/mytld.tld" prefix="test" %>
<test:myname firstName="avishay" lastName="hajbi"> developer</test:myname>
<test:myname firstName="elad" lastName="silvering"> developer</test:myname>
      </div>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>
