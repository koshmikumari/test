package ac.il.shenkar.couponHibernet;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * User class
 * @author avishay limor elad
 *
 */

@Entity
public class User {

	String _username;
	String _password;
	int _id;

	/**
     * User default constructor
     */
	public User() { } 
	
	 /**
     * User class constructor
     * 
     * @param userName                User's Username.
     * @param password                User's password.
     * @param id                User's id.
     */
	public User (int id, String name,String pass)
	{
		_username= name;
		_password=pass;
		_id=id;

	}

	 /**
     * 
     * @return id
     */	
	public int get_id() {
		return _id;
	}

	/**
     * 
     * @param id
     */
	public void set_id(int _id) {
		this._id = _id;
	}
	
	 /**
     * 
     * @return userName
     */
	@Id
	public String get_username() {
		return _username;
	}
	/**
     * 
     * @param userName
     */
	public void set_username(String _name) {
		this._username = _name;
	}
	 /**
     * 
     * @return password
     */
	public String get_password() {
		return _password;
	}
	 /**
     * 
     * @param password
     */
	public void set_password(String _pass) {
		this._password = _pass;
	}
	




	

}
