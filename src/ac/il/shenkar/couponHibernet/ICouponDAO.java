package ac.il.shenkar.couponHibernet;

import java.util.Iterator;

public interface ICouponDAO {
   public abstract Coupon getCoupon(int id);
   public abstract boolean updateCoupon(Coupon ob);
   public abstract Iterator<Coupon> getAllCoupons();
   public abstract boolean deleteCoupon(int id);
   public abstract boolean addCoupon(Coupon ob);
}
