package ac.il.shenkar.couponHibernet;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	String _username;
	String _password;
	int _id;


	public User() { } 
	
	public User (int id, String name,String pass)
	{
		_username= name;
		_password=pass;
		_id=id;

	}


	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}
	
	@Id
	public String get_username() {
		return _username;
	}
	public void set_username(String _name) {
		this._username = _name;
	}

	public String get_password() {
		return _password;
	}
	public void set_password(String _pass) {
		this._password = _pass;
	}
	




	

}
