package ac.il.shenkar.couponHibernet;


import java.util.Collection;


public interface IShoppingCart {
	public void addCouponToCart(Coupon coupon);
	public Collection<ShoppingCartRow> getShoppingCartRows();
}
