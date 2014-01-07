<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
    <%@ page errorPage="error.jsp" %>
    <%@ page import ="javax.servlet.http.*" %>
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
    
   <script type="text/javascript">
function loadXMLDoc(url)//the parameter url for our resource
{
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();//creating a new object for ajax
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");//creating a new object for ajax
  }
xmlhttp.onreadystatechange=function()//Stores a function (or the name of a function) to be called //automatically each time the readyState property changes
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)//if status is succes and request is processed
    {
    document.getElementById('p1').innerHTML=new Date();//getting all response data
//alert(xmlhttp.getResponseHeader('Content-Type'));//getting specific response data
//alert(xmlhttp.responseText);
    }
  }
xmlhttp.open("GET",url,true);//it is making a get request with our url asynchronously
xmlhttp.send();
}
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
        <h1></h1>
        <p class="lead"></p>
       
        <p id="p1">  </p>
        <button onclick="loadXMLDoc('xmlhttp_info.txt')">Get Date</button>

        <p>
	<br/>
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
