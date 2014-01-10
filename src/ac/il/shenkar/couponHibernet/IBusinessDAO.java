package ac.il.shenkar.couponHibernet;

import java.util.Iterator;
/**
 * 
 * @author Avishay Elad Limor
 * 
 */
public interface IBusinessDAO {

		   public abstract Business getBusiness(int id);
		   public abstract boolean updateBusniess(Business ob);
		   public abstract Iterator<Coupon> getAllBusiness();
		   public abstract boolean deleteBusiness(int id);
		   public abstract boolean addBusiness(Business ob);
		

}
