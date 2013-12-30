<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
     <%@ page import="ac.il.shenkar.couponHibernet.* , java.util.Iterator,java.text.*,java.util.* ;" %>
    <%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <style type="text/css">
    .container form ul li {
	display:inline;
    list-style:none;
   
    }
    </style>

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
    
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title></title>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#tabs" ).tabs();
  });
  </script>
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
        <h1>Choose a Category</h1>
        <p class="lead"></p>
        <p><%! String submit; %>


<form action="/webstore/controller/couponcategories" method="GET">
  <ul >
    <li id = "#tabs-1"><input type="submit" value="sport" name="Submit"></li>
    <li id = "#tabs-2"><input type="submit" value="travel" name="Submit"></li>
    <li id = "#tabs-3"><input type="submit" value="restaurant" name="Submit"></li>
  </ul>
  </form>

  <br>
  <%
   submit = request.getParameter("Submit");
  if (submit != null)
  {
  	Object list = request.getAttribute("vec");
  	Vector v = (Vector)list;
  	if (v != null){
  		for (int i = 0; i < v.size(); i++) {
  			Coupon tempOb = (Coupon)v.elementAt(i);
  			if(tempOb.get_category().equals(submit))
  			{
  				out.println(tempOb.toString());
  				out.println(" <a href=\"shoppingcart.jsp?id="+tempOb.get_id()+"\">buy</a>"+"<br/>");

  			}
  		}
  	}
  }
  %>


 

<br>
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
