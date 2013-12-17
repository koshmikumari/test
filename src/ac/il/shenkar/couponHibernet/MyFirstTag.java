package ac.il.shenkar.couponHibernet;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class MyFirstTag extends SimpleTagSupport
{
	private String firstName, lastName;

	public void setFirstName(String str)
	{
		firstName = str;
	}

	public void setLastName(String str)
	{
		lastName = str;
	}

	public void doTag() throws JspException, IOException
	{
		
		JspWriter out = getJspContext().getOut();
		out.print("<p>"+firstName + " " + lastName + "</p>");
		
	}

}
