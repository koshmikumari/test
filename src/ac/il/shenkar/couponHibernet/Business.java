package ac.il.shenkar.couponHibernet;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * Busniess class
 * @author limor elad avishay
 *
 */
@Entity
public class Business {

	int _id;
	String _name;
	String _phone;
	String _address;
	String _city;
	long _longitude;
	long _latitude;


	/**
     * Business default constructor
     */
	public Business() { } 
	
	  // Constractors
    /**
     * Business constructor
     * @param businessId                        Business's ID number.                
     * @param businessName                        Business's name.
     * @param length                                Business's location length.
     * @param width                                        Business's location width.
     * @param city                                        Business's city.
     * @param name                                        Business's name.
     * @param address                                        Business's address.
     */
	public Business (int id , String name,String city,String address, String phone,long longitude,long latitude)
	{
		_id= id;
		_name= name;
		_city=city;
		_address=address;
		_phone = phone;
		_longitude= longitude;
		_latitude= latitude;
	}
	 /**
     * Get method for "businessName"
     * @return businessName
     */
	public String get_name() {
		return _name;
	}
	/**
     * Set method for "businessName"
     * @param businessName
     */
	public void set_name(String _name) {
		this._name = _name;
	}
	 /**
     * Get method for "businessId"
     * @return businessId
     */
	@Id
	public int get_id() {
		return _id;
	}
	 /**
     * Set method for "businessId"
     * @param businessId
     */
	public void set_id(int _id) {
		this._id = _id;
	}
	
	
	public String get_phone() {
		return _phone;
	}

	public void set_phone(String _phone) {
		this._phone = _phone;
	}

	
	public String get_address() {
		return _address;
	}

	public void set_address(String _address) {
		this._address = _address;
	}

	
	public String get_city() {
		return _city;
	}

	public void set_city(String _city) {
		this._city = _city;
	}
	  /**
     * Get method for "longitude"
     * @return width
     */
	public long get_longitude()
	{
		return _longitude;
	}
	 /**
     * Set method for "longitude"
     * @param width
     */
	public void set_longitude(long _longitude)
	{
		this._longitude = _longitude;
	}
	/**
     * Get method for "latitude"
     * @return length
     */
	public long get_latitude()
	{
		return _latitude;
	}
	 /**
     * Set method for "latitude"
     * @param length
     */
	public void set_latitude(long _latitude)
	{
		this._latitude = _latitude;
	}

}
