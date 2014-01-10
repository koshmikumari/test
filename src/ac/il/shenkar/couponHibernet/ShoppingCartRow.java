package ac.il.shenkar.couponHibernet;

/**
 * ShoppingCartRow class
 * @author limor elad avishay
 *
 */
public class ShoppingCartRow {
	
	private Coupon coupon;
	private int quantity;
	/**
     * ShoppingCartRow constructor
     * @param coupon        Coupon object
     * @param quantity        Quantity of coupons
     */
	public ShoppingCartRow(Coupon coupon, int quantity) {
		super();
		this.coupon = coupon;
		this.quantity = quantity;
	}
	/**
     * Get method for "coupon".
     * @return        Coupon object.
     */
	public Coupon getCoupon() {
		return coupon;
	}
	 /**
     * Set mthod for "coupon".
     * @param coupon        Coupon object
     */
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}
	 /**
     * Get mehod for "quantity"
     * @return        quantity of coupon objects in the shopping cart row.
     */
	public int getQuantity() {
		return quantity;
	}
	/**
     * Set method for quantity
     * @param quantity        quantity of coupon objects in the shopping cart row.
     */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
