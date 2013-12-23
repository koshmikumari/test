package ac.il.shenkar.couponHibernet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import antlr.collections.impl.*;

/**
 * Servlet implementation class CouponsPlatformController
 * control the web application
 */
@WebServlet("/controller/*")
public class Controller extends HttpServlet
{

	// Create db Singleton
	// Shotcut
	private static final long serialVersionUID = 1L;

	// org.apache.el.parser.COERCE_TO_ZERO to = true;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/* start do get */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		/**
		 * @parem str getting the url path 
		 */
		String str = request.getPathInfo();
		
		//index page
		if (str.equals("/*"))
		{
			/* cookies */
			// get cookie and check if the user exist
			Cookie[] cookies = request.getCookies();
			if (cookies != null && cookies.length>1)
			{
				for (int i = 0; i < cookies.length; i++)
				{
					String name = cookies[i].getName();
					String value = cookies[i].getValue();
					System.out.println("name = " + name + " value = " + value);
					User user = DAO.getInstance().getUser(value);
					if (user != null)
					{
						response.addCookie(cookies[i]);
						request.setAttribute("usernameweb", cookies[i].getValue());
						request.setAttribute("timestamp", new java.util.Date());
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher("/views/loggedin.jsp");
						dispatcher.forward(request, response);
					}
				}
			}
			/* end cookies */
			else
			{
				request.setAttribute("timestamp", new java.util.Date());
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/index.jsp");
				dispatcher.forward(request, response);
			}
		}
		// about page
		else if (str.equals("/about"))
		{
			
			request.setAttribute("timestamp", new java.util.Date());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/about.jsp");
			dispatcher.forward(request, response);
		}
		// back link to loggedin
		else if (str.equals("/back"))
		{
			
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/loggedin.jsp");
			dispatcher.forward(request, response);
		}
		// logout form the system
		else if (str.equals("/logout"))
		{
			/* cookies */
			// get cookie and set max age 0
			Cookie[] cookies = request.getCookies();

			if (cookies != null)
			{
				for (Cookie c : cookies)
				{
					if(c.getName().equals("usernameweb"))
					{
						request.getSession().setMaxInactiveInterval(60*10);
						c.setMaxAge(0);
						response.addCookie(c);
						System.out.println(c.getName()+" " +c.getValue()+" cookie was deleted");
						break;
					}
				}

			}
			/* end cookies */
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/index.jsp");
			dispatcher.forward(request, response);
		}
		// Help page
		else if (str.equals("/help"))
		{
			request.setAttribute("timestamp", new java.util.Date());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/help.jsp");
			dispatcher.forward(request, response);
		}

		// Contact page
		else if (str.equals("/contact"))
		{
			request.setAttribute("timestamp", new java.util.Date());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/contact.jsp");
			dispatcher.forward(request, response);
		}

		// getting all coupons 
		else if (str.equals("/coupons"))
		{
			request.setAttribute("timestamp", new java.util.Date());

			// getting all coupons
			Vector list=null;
			
				try
				{
					list= filterBYdate(DAO.getInstance().getAllCoupons());
					request.setAttribute("list", list);
				}
				catch (ParseException e)
				{
					System.out.println("error: could not found any coupons.");
					e.printStackTrace();
				}
				
		
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/coupons.jsp");
			dispatcher.forward(request, response);
		}

		// select coupon
		else if (str.equals("/selectcoupon"))
		{

			request.setAttribute("timestamp", new java.util.Date());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/selectcoupon.jsp");
			dispatcher.forward(request, response);

		}

		// login page
		else if (str.equals("/login"))
		{
			request.setAttribute("timestamp", new java.util.Date());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/login.jsp");
			dispatcher.forward(request, response);

		}
		// register page
		else if (str.equals("/register"))
		{
			request.setAttribute("timestamp", new java.util.Date());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/register.jsp");
			dispatcher.forward(request, response);

		}
		// add new coupun
		else if (str.equals("/addcoupon"))
		{
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/addcoupon.jsp");
			dispatcher.forward(request, response);

		}
		// delete coupon
		else if (str.equals("/deletecoupon"))
		{
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/deletecoupon.jsp");
			dispatcher.forward(request, response);

		}
		// update coupon
		else if (str.equals("/updatecoupon"))
		{
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/updatecoupon.jsp");
			dispatcher.forward(request, response);

		}
		// add business
		else if (str.equals("/addbusiness"))
		{
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/addbusiness.jsp");
			dispatcher.forward(request, response);

		}
		// delete business
		else if (str.equals("/deletebusiness"))
		{
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/deletebusiness.jsp");
			dispatcher.forward(request, response);

		}
		// update business
		else if (str.equals("/updatebusiness"))
		{
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/updatebusiness.jsp");
			dispatcher.forward(request, response);

		}
		// shopping cart
		else if (str.contains("/shoppingcart"))
		{
			String id = request.getParameter("id");
			request.setAttribute("id", id);
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/shoppingcart.jsp");
			dispatcher.forward(request, response);

		}
		// show all coupons
		else if (str.equals("/showcoupons"))
		{
			Vector vector = new Vector();
			Vector vec = new Vector();
			try
			{
				vector = filterBYdate(DAO.getInstance().getAllCoupons());
			}
			catch (ParseException e)
			{
				e.printStackTrace();
			}
			
			System.out.println(vector.size()+"coupons found: ");
			for (int i = 0; i < vector.size(); i++)
			{
				Coupon c = (Coupon) vector.elementAt(i);
				System.out.println(c.get_id());
				vec.appendElement(c);
			}
			request.setAttribute("size", vec.size());
			request.setAttribute("vec", vec);
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/showcoupons.jsp");
			dispatcher.forward(request, response);

		}
		//category page
		else if (str.equals("/categories"))
		{
			
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/categories.jsp");
			dispatcher.forward(request, response);

		}
		// update coupon after preview
		else if (str.equals("/updateCouponPreview"))
		{
			
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/updatecoupon.jsp");
			dispatcher.forward(request, response);

		}
		// delete coupon after preview
		else if (str.equals("/deleteCouponPreview"))
		{
			
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/deletecoupon.jsp");
			dispatcher.forward(request, response);

		}
		// coupon categories page
		else if (str.equals("/couponcategories"))
		{
			Vector vector = new Vector();
			Vector vec = new Vector();
			try
			{
				vector = filterBYdate(DAO.getInstance().getAllCoupons());
			}
			catch (ParseException e)
			{
				e.printStackTrace();
			}
			
			System.out.println(vector.size()+"coupons found: ");
			for (int i = 0; i < vector.size(); i++)
			{
				Coupon c = (Coupon) vector.elementAt(i);
				System.out.println(c.get_id());
				vec.appendElement(c);
			}
			request.setAttribute("vec", vec);
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/categories.jsp");
			dispatcher.forward(request, response);

		}
		//closest coupon page
		else if (str.equals("/closestcoupons"))
		{
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/closestcoupons.jsp");
			dispatcher.forward(request, response);

		}
		//if nothing match go to the index page
		else
		{
			/* cookies */
			// get cookie and check if the user exist
			/*Cookie[] cookies = request.getCookies();
			if (cookies != null && cookies.length>1)
			{
				for (int i = 0; i < cookies.length; i++)
				{
					String name = cookies[i].getName();
					String value = cookies[i].getValue();
					System.out.println("name = " + name + " value = " + value);
					User user = DAO.getInstance().getUser(value);
					if (user != null)
					{
						response.addCookie(cookies[i]);
						request.setAttribute("usernameweb", cookies[i].getValue());
						request.setAttribute("timestamp", new java.util.Date());
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher("/views/loggedin.jsp");
						dispatcher.forward(request, response);
					}
				}
			}
			else
			{*/
			request.setAttribute("timestamp", new java.util.Date());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/index.jsp");
			dispatcher.forward(request, response);
			//}
		}
	}

	/* end do get */

	/* start do post */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String str = request.getPathInfo();

		//after loggedin
		if (str.equals("/loggedin"))
		{

			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if (username.length() < 1 || password.length() < 1)
			{
				request.setAttribute("answer", "please fill all the tabs");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/login.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				System.out.println("try to login");
				User u = null;
				u = DAO.getInstance().getUser(username);
				System.out.println("check user match..");
				if (u != null)
				{
					if (u.get_password().equals(MD5.encryptMD5(password)))
					{
						/* cookies */
						// add cookie
						String data = request.getParameter("username");
						Cookie cookie = new Cookie("usernameweb", data);
						cookie.setMaxAge(-1);
						cookie.setPath("/");
						response.addCookie(cookie);
						request.setAttribute("usernameweb", data);
						/* end cookies */

						request.setAttribute("answer", u._username);
						System.out.println("password  match");
						request.setAttribute("timestamp", new java.util.Date());
						System.out.println("username: " + u.get_username()
								+ " logged in");
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher("/views/loggedin.jsp");
						dispatcher.forward(request, response);

					}
					else
					{
						request.setAttribute("answer", "incorrect password");
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher("/views/login.jsp");
						dispatcher.forward(request, response);
					}
				}

				else
				{
					request.setAttribute("answer", "user does not exist");
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/login.jsp");
					dispatcher.forward(request, response);
				}
			}

		}
		//after registered
		else if (str.equals("/register"))
		{
			String password = request.getParameter("password");
			String username = request.getParameter("username");
			String id = request.getParameter("id");
			if (username.length() < 1 || password.length() < 1
					&& id.length() < 1)
			{
				request.setAttribute("answer", "please fill all the tabs");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/register.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				User u = null;
				u = DAO.getInstance().getUser(username);
				if (u != null)
				{
					request.setAttribute("answer", "user is already exist");
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/register.jsp");
					dispatcher.forward(request, response);
				}
				else if (id.matches(".*\\d.*"))
				{
					String MD5Password = MD5.encryptMD5(password);
					User newuser = new User(Integer.parseInt(id), username,
							MD5Password);
					DAO.getInstance().addUser(newuser);

					/* cookies */
					// add cookie
					String data = request.getParameter("username");
					Cookie cookie = new Cookie("usernameweb", data);
					cookie.setMaxAge(-1);
					cookie.setPath("/");
					response.addCookie(cookie);
					request.setAttribute("usernameweb", data);
					/* end cookies */

					request.setAttribute("answer", newuser.get_username());
					request.setAttribute("timestamp", new java.util.Date());
					request.setAttribute("actionAnswer", "user registered");
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/loggedin.jsp");
					dispatcher.forward(request, response);
				}
				else
				{
					request.setAttribute("answer", "id must be only digits");
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/register.jsp");
					dispatcher.forward(request, response);
				}
			}

		}

		/*
		 * coupon action
		 */
		
		//select specific coupon
		else if (str.equals("/selectcoupon"))
		{
			String couponId = (String) request.getParameter("couponId");
			
			if (couponId.length() > 0 && couponId.matches(".*\\d.*"))
			{
				Vector v = new Vector();
				try
				{
					v = filterBYdate(DAO.getInstance().getAllCoupons());
				}
				catch (ParseException e)
				{
					e.printStackTrace();
				}
				Coupon coupon = null;
				for (int i = 0; i < v.size(); i++)
				{
					if (((Coupon) v.elementAt(i)).get_id() == Integer
							.parseInt(couponId))
					{
						coupon = ((Coupon) v.elementAt(i));
					}
				}
				if (coupon != null) {
					request.setAttribute(
							"answer",
							"Your coupon id request is: " + coupon.get_id()
									+ "<br/> description: "
									+ coupon.get_category() + "<br/>\n");
					request.setAttribute("couponid",coupon.get_id());
				}
				else
					request.setAttribute("answer", "error: Your coupon id "
							+ couponId + " was not found!" + "<br/>\n");

				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/selectcoupon.jsp");
				dispatcher.forward(request, response);
			}
			else if (couponId.isEmpty())
			{
				request.setAttribute("answer", "please fill the tabs <br/>\n");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/selectcoupon.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				request.setAttribute("answer",
						"please insert only digits <br/>\n");
				request.setAttribute("timestamp", new java.util.Date());
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/selectcoupon.jsp");
				dispatcher.forward(request, response);
			}
		}
		// add new coupon
		else if (str.equals("/addcoupon"))
		{
			String coupunname = request.getParameter("couponname");
			String couponid = request.getParameter("couponid");
			String businessid = request.getParameter("businessid");
			String description = request.getParameter("description");
			String category = request.getParameter("category");
			String price = request.getParameter("price");
			String image = request.getParameter("image");
			String expiredate = request.getParameter("expiredate");
			String time = request.getParameter("time");

			if (coupunname.length() < 1 || couponid.length() < 1
					|| businessid.length() < 1 || description.length() < 1
					|| category.length() < 1 || price.length() < 1
					|| image.length() < 1 || expiredate.length() < 1
					|| time.length() < 1)
			{
				request.setAttribute("answer", "please fill all the tabs");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/addcoupon.jsp");
				dispatcher.forward(request, response);

			}
			else if (!price.matches("^[-+]?\\d+(\\.{0,1}(\\d+?))?$"))
			{
				request.setAttribute("answer", "please insert correct price");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/addcoupon.jsp");
				dispatcher.forward(request, response);
			}
			
			else if (!(couponid.matches(".*\\d.*") || businessid
					.matches(".*\\d.*")))
			{
				request.setAttribute("answer",
						"please insert only numbers in coupon and business id");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/addcoupon.jsp");
				dispatcher.forward(request, response);
			}
			else if (businessid.length() > 0 && couponid.length() > 0)
			{

				Coupon c = DAO.getInstance().getCoupon(
						Integer.parseInt(couponid));
				Business b = DAO.getInstance().getBusiness(
						Integer.parseInt(businessid));
				if (c != null)
				{
					request.setAttribute("answer", "coupon id is already exist");
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/addcoupon.jsp");
					dispatcher.forward(request, response);
				}
				else if (b == null)
				{
					request.setAttribute("answer", "business is don't exist");
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/addcoupon.jsp");
					dispatcher.forward(request, response);
				}
				else
				{

					try
					{
						SimpleDateFormat sdf = new SimpleDateFormat(
								"mm/dd/yyyy");
						sdf.setLenient(false);
						sdf.parse(expiredate);
						Coupon c1 = new Coupon(Integer.parseInt(couponid),
								Integer.parseInt(businessid), description,
								category, Double.parseDouble(price), image,
								expiredate, time,coupunname);
						DAO.getInstance().addCoupon(c1);
						request.setAttribute("actionAnswer", "coupon id: "
								+ couponid + " added to business id: "
								+ businessid);
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher("/views/loggedin.jsp");
						dispatcher.forward(request, response);

					}
					catch (ParseException ex)
					{
						request.setAttribute("answer",
								"please insert a valid date format");
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher("/views/addcoupon.jsp");
						dispatcher.forward(request, response);
					}
				}
			}

		}

		//delete coupon
		else if (str.equals("/deletecoupon"))
		{
			String couponId = (String) request.getParameter("couponId");

			if (couponId.length() > 0 && couponId.matches(".*\\d.*"))
			{

				Coupon coupon = DAO.getInstance().getCoupon(
						Integer.parseInt(couponId));
				if (coupon != null)
				{
					request.setAttribute("actionAnswer", "Your coupon id : "
							+ coupon.get_id() + " was deleted");
					DAO.getInstance().deleteCoupon(Integer.parseInt(couponId));
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/loggedin.jsp");
					dispatcher.forward(request, response);
				}
				else
				{
					request.setAttribute("answer", "error: Your coupon id "
							+ couponId + " was not found!" + "<br/>\n");

					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/deletecoupon.jsp");
					dispatcher.forward(request, response);
				}
			}
			else if (couponId.isEmpty())
			{
				request.setAttribute("answer", "please fill the tabs <br/>\n");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/deletecoupon.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				request.setAttribute("answer",
						"please insert only digits <br/>\n");
				request.setAttribute("timestamp", new java.util.Date());
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/deletecoupon.jsp");
				dispatcher.forward(request, response);
			}
		}
		//update coupon
		else if (str.equals("/updatecoupon"))
		{

			String couponid, businessid, description, category, price, image, expiredate = null;
			couponid = request.getParameter("couponid");
			businessid = request.getParameter("businessid");
			description = request.getParameter("description");
			category = request.getParameter("category");
			price = request.getParameter("price");
			image = request.getParameter("image");
			expiredate = request.getParameter("expiredate");
			String time = request.getParameter("time");
			Coupon c = null;

			if (!(couponid.matches(".*\\d.*")))
			{

				request.setAttribute("answer", "please insert only numbers");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/updatecoupon.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				c = DAO.getInstance().getCoupon(Integer.parseInt(couponid));
				if (c == null)
				{
					request.setAttribute("answer", "coupon was not found");
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/updatecoupon.jsp");
					dispatcher.forward(request, response);
				}
				else
				{
					if (price.length() > 1)
					{
						if (price.matches("^[-+]?\\d+(\\.{0,1}(\\d+?))?$"))
							c.set_price(Double.parseDouble(price));
					}
					if (businessid.length() > 1)
					{

						if (businessid.matches(".*\\d.*"))
						{
							c.set_busniess_id(Integer.parseInt(businessid));
						}
					}
					if (category.length() > 1)
					{
						c.set_category(category);
					}

					if (description.length() > 1)
					{
						c.set_description(description);
					}
					if (image.length() > 1)
					{
						c.set_image(image);
					}
					if (expiredate.length() > 1)
					{
						 try
						 {
						 SimpleDateFormat sdf = new SimpleDateFormat(
						 "dd-mm-yyyy");
						 sdf.setLenient(false);
						 sdf.parse(expiredate);
						 c.set_expire_date(expiredate);
						 }
						 catch (ParseException ex)
						 {
							 System.out.println("expire date crashed");
						 }
					}
					if (time.length() > 1)
					{
						c.set_time(time);
					}
					DAO.getInstance().updateCoupon(c);
					request.setAttribute("actionAnswer", "coupon was updated");
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/loggedin.jsp");
					dispatcher.forward(request, response);

				}
			}

		}

		/*
		 * business action
		 */
		
		//add business
		else if (str.equals("/addbusiness"))
		{
			String businessname = request.getParameter("businessname");
			String businessid = request.getParameter("businessid");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String phone = request.getParameter("phone");
			String latitude = request.getParameter("latitude");
			String longitude = request.getParameter("longitude");

			if (businessname.length() < 1 || businessid.length() < 1
					|| address.length() < 1 || city.length() < 1
					|| phone.length() < 1 || latitude.length() < 1
					|| longitude.length() < 1)
			{
				request.setAttribute("answer", "please fill all the tabs");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/addbusiness.jsp");
				dispatcher.forward(request, response);

			}

			else if (!(longitude.matches(".*\\d.*")
					|| businessid.matches(".*\\d.*") || (latitude
						.matches(".*\\d.*"))))
			{
				request.setAttribute("answer",
						"please insert only numbers in longitude latitude business id");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/addbusiness.jsp");
				dispatcher.forward(request, response);
			}
			else if (businessid.length() > 0)
			{

				Business b = DAO.getInstance().getBusiness(
						Integer.parseInt(businessid));
				if (b != null)
				{
					request.setAttribute("answer",
							"business id is already exist");
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/addbusiness.jsp");
					dispatcher.forward(request, response);
				}

				else
				{
					b = new Business();
					b.set_address(address);
					b.set_city(city);
					b.set_id(Integer.parseInt(businessid));
					b.set_latitude(Integer.parseInt(latitude));
					b.set_longitude(Integer.parseInt(longitude));
					b.set_name(businessname);
					b.set_phone(phone);
					DAO.getInstance().addBusiness(b);
					request.setAttribute("actionAnswer", "business id: "
							+ businessid + " added ");
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/loggedin.jsp");
					dispatcher.forward(request, response);

				}
			}
		}

		// delete business
		else if (str.equals("/deletebusiness"))
		{
			String businessid = (String) request.getParameter("businessid");
			if (businessid.length() > 0 && businessid.matches(".*\\d.*"))
			{

				Business business = DAO.getInstance().getBusiness(
						Integer.parseInt(businessid));
				if (business != null)
				{
					request.setAttribute("actionAnswer", "Your business id : "
							+ business.get_id() + " was deleted");
					DAO.getInstance()
							.deleteCoupon(Integer.parseInt(businessid));
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/loggedin.jsp");
					dispatcher.forward(request, response);
				}
				else
				{
					request.setAttribute("answer", "error: Your coupon id "
							+ businessid + " was not found!" + "<br/>\n");

					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/deletebusiness.jsp");
					dispatcher.forward(request, response);
				}
			}
			else if (businessid.isEmpty())
			{
				request.setAttribute("answer", "please fill the tabs <br/>\n");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/deletebusiness.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				request.setAttribute("answer",
						"please insert only digits <br/>\n");
				request.setAttribute("timestamp", new java.util.Date());
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/deletebusiness.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		//update business
		else if (str.equals("/updatebusiness"))
		{

			String businessname = request.getParameter("businessname");
			String businessid = request.getParameter("businessid");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String phone = request.getParameter("phone");
			String latitude = request.getParameter("latitude");
			String longitude = request.getParameter("longitude");
			Business b = null;

			if (!(businessid.matches(".*\\d.*")))
			{

				request.setAttribute("answer", "please insert only numbers");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/updatebusiness.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				b = DAO.getInstance().getBusiness(Integer.parseInt(businessid));
				if (b == null)
				{
					request.setAttribute("answer", "business was not found");
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/updatebusiness.jsp");
					dispatcher.forward(request, response);
				}
				else
				{
					if (businessname.length() > 1)
					{

						b.set_name(businessname);
					}
					if (businessid.length() > 1)
					{

						if (businessid.matches(".*\\d.*"))
						{
							b.set_id(Integer.parseInt(businessid));
						}
					}

					if (phone.length() > 1)
					{
						b.set_phone(phone);
					}
					if (longitude.length() > 1)
					{
						b.set_longitude(Integer.parseInt(longitude));
					}
					if (latitude.length() > 1)
					{
						b.set_latitude(Integer.parseInt(latitude));
					}
					if (address.length() > 1)
					{
						b.set_address(address);
					}
					if (city.length() > 1)
					{
						b.set_city(city);
					}
					DAO.getInstance().updateBusniess(b);
					request.setAttribute("actionAnswer", "business was updated");
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/loggedin.jsp");
					dispatcher.forward(request, response);
				}
			}

		}
		
		//getting closest coupons
		else if (str.equals("/closestcoupons"))
		{
			String latitude = request.getParameter("latitude");
			String longitude = request.getParameter("longitude");
			// String radius = request.getParameter("radius");

			// matches(".*\\d.*")
			if (/* (radius.length()<1 && radius.matches(".*\\d.*")) || */(longitude
					.length() < 1 && longitude.matches(".*\\d."))
					|| (latitude.length() < 1 || latitude.matches(".*d\\*")))
			{
				request.setAttribute("answer", "please insert only numbers");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/closestcoupons.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				int lo, la, num = 0;
				lo = Integer.parseInt(longitude);
				la = Integer.parseInt(latitude);
				// ra = Integer.parseInt(radius);
				Vector v = new Vector();

				Iterator Biterator = null;

				Biterator = DAO.getInstance().getAllBusiness();

				while (Biterator.hasNext())
				{
					Business b = (Business) Biterator.next();
					if (((b.get_latitude() == la) && (b.get_longitude() == lo)))
					{
						/* inside the business */
						Vector Citerator = new Vector();
						try
						{
							Citerator = filterBYdate(DAO.getInstance()
									.getAllCoupons());
						}
						catch (ParseException e)
						{
							e.printStackTrace();
						}

						for (int i = 0; i < Citerator.size(); i++)
						{
							Coupon c = (Coupon) Citerator.elementAt(i);
							if (c.get_busniess_id() == b._id)
							{
								num++;
								v.appendElement(c);
								System.out.println("coupon id: " + c.get_id()
										+ " business id: "
										+ c.get_busniess_id());
							}
						}
					}
				}

				request.setAttribute("answer", num + " coupons found: ");
				request.setAttribute("list", v);
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/closestcoupons.jsp");
				dispatcher.forward(request, response);

			}

		}

	}

	/* end do post */

	/**
	 * this function returns coupon after filter by date
	 * @param iterator
	 * @return vector
	 * @throws ParseException
	 */
	public Vector filterBYdate(Iterator iterator) throws ParseException
	{
		Vector v = new Vector();
		// iterator = DAO.getInstance().getAllCoupons();
		Object tempOb;
		Date currDate = new Date();
		System.out.println("cuur date:" + currDate);
		while (iterator.hasNext())
		{
			tempOb = iterator.next();
			String expireDate = ((Coupon) tempOb).get_expire_date();
			DateFormat df = new SimpleDateFormat("MM/dd/yyy", Locale.ENGLISH);
			Date expDate = df.parse(expireDate);
			System.out.println(((Coupon) tempOb).get_expire_date());
			if ((expDate.after(currDate)))
			{
				System.out.println("db valid dates:" + expDate);
				v.appendElement(tempOb);
			}
			
			
		}
		return v;
	}

	/**
	 * this function convert vector to iterator
	 * @param v
	 * @return Iretator
	 */
	public Iterator vectorToIterator(Vector v)
	{

		if (v != null)
		{
			Iterator<String[]> iterator = (Iterator) v;
			return iterator;
		}
		else
			return null;
	}
}
