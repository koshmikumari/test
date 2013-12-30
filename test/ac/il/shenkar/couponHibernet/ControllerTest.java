package ac.il.shenkar.couponHibernet;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Iterator;
import java.util.Vector;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest
{
        private Controller tester;
        
         
        @Before
        public void setUp() throws Exception {
                tester = new Controller();
        }
        @Test
        public void testFilterBYdate()
        {
                
                Vector vec = new Vector();
                Object ob;
                Coupon c= new Coupon (000, 000, "aaa","bbb", 111,"ur","3/5/2016","HH:mm","test");
                ob=c;
                vec.addElement(ob);
                Iterator itrator=vec.iterator();
                vec.removeAllElements();
                
                
                try
                {
                        assertEquals("filterByDate method works", vec, tester.filterBYdate(itrator));
                        
                }
                catch (ParseException e)
                {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                
        }

}