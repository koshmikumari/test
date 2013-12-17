package ac.il.shenkar.couponHibernet;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Business {

	int _id;
	String _name;
	String _phone;
	String _address;
	String _city;
	long _longitude;
	long _latitude;



	public Business() { } 
	
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
	
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	
	@Id
	public int get_id() {
		return _id;
	}
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
	public long get_longitude()
	{
		return _longitude;
	}

	public void set_longitude(long _longitude)
	{
		this._longitude = _longitude;
	}

	public long get_latitude()
	{
		return _latitude;
	}

	public void set_latitude(long _latitude)
	{
		this._latitude = _latitude;
	}

}
