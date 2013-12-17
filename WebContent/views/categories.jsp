<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
 <%@ page import="ac.il.shenkar.couponHibernet.* , java.util.Iterator,java.text.*,java.util.* , antlr.collections.impl.Vector;" %>
    <%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
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

<%! String submit; %>

<div id="tabs">
<form action="/webstore/controller/couponcategories" method="GET">
  <ul>
    <li id = "#tabs-1"><input type="submit" value="sport" name="Submit">	</li>
    <li id = "#tabs-2"><input type="submit" value="travel" name="Submit"></li>
    <li id = "#tabs-3"><input type="submit" value="restaurant" name="Submit"></li>
  </ul>
  </form>
  <div id="tabs-1">
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
	</div>

 
</div>
<br>
<a href="../controller/index">חזור לדף הראשי</a>

</body>
</html>