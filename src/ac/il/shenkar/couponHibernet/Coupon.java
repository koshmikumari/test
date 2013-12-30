package ac.il.shenkar.couponHibernet;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coupon {
	int _id;
	int _busniess_id;
	String _description;
	String _category;
	double _price;
	String _image;
	String _expire_date;
	String _time;
	String _name;
	
	public Coupon (int id, int busniessid, String des,String cat, double price,String image,String expire_date,String time,String name)
	{
		
		_id=id;
		_busniess_id=busniessid;
		_description=des;
		_category=cat;
		_price=price;
		_image=image;
		_expire_date= expire_date;
		_time = time;
		_name = name;
	}

	@Id
	public int get_id() {
		return _id;
	}


	public void set_id(int _id) {
		this._id = _id;
	}


	public int get_busniess_id() {
		return _busniess_id;
	}


	public void set_busniess_id(int _busniess_id) {
		this._busniess_id = _busniess_id;
	}


	public String get_description() {
		return _description;
	}


	public void set_description(String _description) {
		this._description = _description;
	}


	public String get_category() {
		return _category;
	}


	public void set_category(String _category) {
		this._category = _category;
	}


	public double get_price() {
		return _price;
	}


	public void set_price(double _price) {
		this._price = _price;
	}

	public String get_image()
	{
		return _image;
	}

	public void set_image(String _image)
	{
		this._image = _image;
	}

	public String get_expire_date()
	{
		return _expire_date;
	}

	public void set_expire_date(String _expire_date)
	{
		this._expire_date = _expire_date;
	}
	
	public Coupon (){
		super();
	}
	

	public String get_time()
	{
		return _time;
	}



	public void set_time(String _time)
	{
		this._time = _time;
	}
	
	@Override
	public String toString()
	{
		return ("coupon name: "+_name+" coupon id: "+_id+" description: "+_description+" price: "+_price);
		
	}

	public String get_name()
	{
		return _name;
	}
 

	public void set_name(String _name)
	{
		this._name = _name;
	}
	

}
