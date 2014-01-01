<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
     <%@ page import="ac.il.shenkar.couponHibernet.* , java.util.Iterator,java.text.*,java.util.* , antlr.collections.*;" %>
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
        
        
        <%
		//getting our dao
		ICouponDAO dao = DAO.getInstance();
	
		//checking if a shopping cart exists, if not then create one
		IShoppingCart cart = (IShoppingCart)session.getAttribute("cart");
		if(cart==null)
		{
			cart = new BasicShoppingCart();
			session.setAttribute("cart",cart);
		}
	
		//adding the product if id was sent
		String str = request.getParameter("id");
		if(str!=null)
		{
			int id = Integer.parseInt(str);
			cart.addCouponToCart(dao.getCoupon(id));
		}
		
		//printing out the content of the shopping cart
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>name-----</th><th>quantity-----</th><th>price-----</th><th>total</th></tr>");
		Collection<ShoppingCartRow> rows = cart.getShoppingCartRows();
		Iterator<ShoppingCartRow> iterator = rows.iterator();
		while(iterator.hasNext())
		{
			ShoppingCartRow current = iterator.next();
			double price = current.getCoupon().get_price();
			int quantity = current.getQuantity();
			out.println("<tr>");
			out.println("<td>"+current.getCoupon().get_name()+"</td>	");
			out.println("<td>"+quantity+"</td>	");
			out.println("<td>"+price+"</td>	");
			out.println("<td>"+(price*quantity)+"</td>	");
			out.println("</tr>");
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
 

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>
