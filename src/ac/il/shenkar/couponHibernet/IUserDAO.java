package ac.il.shenkar.couponHibernet;

import java.util.Iterator;

public interface IUserDAO {

		   public abstract User getUser(String username);
		   public abstract boolean updateUser(User ob);
		   public abstract Iterator<User> getAllUser();
		   public abstract boolean deleteUser(String id);
		   public abstract boolean addUser(User ob);
		

}
