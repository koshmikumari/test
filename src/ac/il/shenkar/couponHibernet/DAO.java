package ac.il.shenkar.couponHibernet;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

public class DAO implements IBusinessDAO,ICouponDAO,IUserDAO
{
        /**
        * Log4j logger
        */
        static Logger log4j = Logger.getLogger("ac.il.shenkar.couponHibernet");
        
        private static SessionFactory sessionFactory = null;
        private Session session = null;
        String cr = "\n----------------";
        
        //**Singleton***************************************************************
        private static DAO instance;
        

         private DAO() {
                  sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
                  //sessionFactory = new Configuration().configure().buildSessionFactory();
          }

          public static DAO getInstance() {
                  if (instance==null)
                          instance=new DAO();
                  return instance;
          }
          

        // Not Working
        @Override
        public boolean updateUser(User ob) {
                try {
                        session = sessionFactory.openSession();
                        session.beginTransaction();
                        //-------------
                        session.update(ob);
                        //-------------
                        session.getTransaction().commit();
                        session.close();
                                                                        System.out.println("update User "+ob.get_username()+"completed."+cr);
                } catch (Exception e) {
                                                                        System.out.println("error: update User "+ob.get_username()+cr);
                        e.printStackTrace();
                        return false;
                }
                log4j.debug("update user" + ob._username);
                return true;
        }

        @Override
        public boolean deleteUser(String username) {
                User UserToDel = null;
                try {
                        session = sessionFactory.openSession();
                        session.beginTransaction();
                        //-------------
                        UserToDel = new User();
                        UserToDel.set_username(username);
                        
                        System.out.println(UserToDel);
           session.delete(UserToDel);
                        //-------------
                        session.getTransaction().commit();
                        session.close();
                                                                System.out.println("deleting User "+username+" completed.");
                } catch (HibernateException e) {
                                                       System.out.println("error: deleting User: "+username);
           return false;
       }
                log4j.debug("delete user" + username);
                return true;
        }

        @Override
        public User getUser(String username) {
                User user = null;
                try {
                        session = sessionFactory.openSession();
                        session.beginTransaction();
                        //-------------
                        user =  (User) session.get(User.class, username);
                        //-------------
                        session.getTransaction().commit();
                        session.close();
                                                                        System.out.println("get Username completed."+cr);
                } catch (Exception e) {
                                                                        System.out.println("error: get Username."+cr);
                        e.printStackTrace();
                        return null;
                }
                log4j.debug("get user" + username);
                return user;
        }

        
        @Override
        public boolean addUser(User ob) {

                try {
                        session = sessionFactory.openSession();
                        session.beginTransaction();
                        //----------------------
                        System.out.println(ob);
                        session.save(ob);
                        //----------------------
                        session.getTransaction().commit();
                        session.close();
                                                                System.out.println("add User "+ob.get_id()+" "+ob.get_username()+""+cr);
                } catch (Exception e) {
                                                                System.out.println("error: add User"+cr);
                        return false;
                }
                log4j.debug("add user" + ob._username);
                return true;
        }
        
        @Override
        public Iterator<User> getAllUser() {
                Iterator iterator = null;
                try {
                        session = sessionFactory.openSession();
                        session.beginTransaction();
                        //-------------
                        List User = session.createCriteria(User.class).list();
                        System.out.println("There are " + User.size() + " User(es):");
                        iterator = User.iterator();
//                        while(iterator.hasNext()) 
//                        {
//                                System.out.println(iterator.next());
//                        }
//                        //-------------
                        session.getTransaction().commit();
                        session.close();
                                                                System.out.println("getting all User completed."+cr);
                } catch (HibernateException e) {
                                                       System.out.println("error: deleting User"+cr);
                        return null;
       }
                log4j.debug("get users iterator");
                return iterator;
        }
        


        // Not Working
        @Override
        public boolean updateBusniess(Business ob) {
                try {
                        session = sessionFactory.openSession();
                        session.beginTransaction();
                        //-------------
                        session.update(ob);
                        //-------------
                        session.getTransaction().commit();
                        session.close();
                                                                        System.out.println("update Business "+ob.get_id()+"completed."+cr);
                } catch (Exception e) {
                                                                        System.out.println("error: update Business "+ob.get_id()+cr);
                        e.printStackTrace();
                        return false;
                }
                log4j.debug("update business" + ob._name);
                return true;
        }

        @Override
        public boolean deleteBusiness(int id) {
                Business businessToDel = null;
                try {
                        session = sessionFactory.openSession();
                        session.beginTransaction();
                        //-------------
                        businessToDel = new Business();
                        businessToDel.set_id(id);
                        
                        System.out.println(businessToDel);
          session.delete(businessToDel);
                        //-------------
                        session.getTransaction().commit();
                        session.close();
                                                                System.out.println("deleting Business "+id+" completed.");
                } catch (HibernateException e) {
                                                      System.out.println("error: deleting Business: "+id);
          return false;
      }
                log4j.debug("delete business " + id);
                return true;
        }

        @Override
        public Business getBusiness(int id) {
                Business business = null;
                try {
                        session = sessionFactory.openSession();
                        session.beginTransaction();
                        //-------------
                        business =  (Business) session.get(Business.class, id);
                        //-------------
                        session.getTransaction().commit();
                        session.close();
                                                                        System.out.println("get Business completed."+cr);
                } catch (Exception e) {
                                                                        System.out.println("error: get Business."+cr);
                        e.printStackTrace();
                        return null;
                }
                log4j.debug("get business " + id);
                return business;
        }
        
        @Override
        public boolean addBusiness(Business ob) {

                try {
                        session = sessionFactory.openSession();
                        session.beginTransaction();
                        //----------------------
                        System.out.println(ob);
                        session.save(ob);
                        //----------------------
                        session.getTransaction().commit();
                        session.close();
                                                                System.out.println("add Business "+ob.get_id()+" "+ob.get_name()+""+cr);
                } catch (Exception e) {
                                                                System.out.println("error: add Business."+cr);
                        return false;
                }
                log4j.debug("add business " + ob._name);
                return true;
        }
        
        @Override
        public Iterator<Coupon> getAllBusiness() {
                Iterator iterator = null;
                try {
                        session = sessionFactory.openSession();
                        session.beginTransaction();
                        //-------------
                        List Business = session.createCriteria(Business.class).list();
                        System.out.println("There are " + Business.size() + " Business(es):");
                        iterator = Business.iterator();
//                        while(iterator.hasNext()) 
//                        {
//                                System.out.println(iterator.next());
//                        }
//                        //-------------
                        session.getTransaction().commit();
                        session.close();
                                                                System.out.println("getting all Business completed."+cr);
                } catch (HibernateException e) {
                                                      System.out.println("error: deleting Business"+cr);
                        return null;
      }
                log4j.debug(" business iterator");
                return iterator;
        }


        
        @Override
        public boolean updateCoupon(Coupon ob) {
                try {
                        session = sessionFactory.openSession();
                        session.beginTransaction();
                        //-------------
                        session.update(ob);
                        //-------------
                        session.getTransaction().commit();
                        session.close();
                                                                        System.out.println("update coupon "+ob.get_id()+"completed."+cr);
                } catch (Exception e) {
                                                                        System.out.println("error: update coupon "+ob.get_id()+cr);
                        e.printStackTrace();
                        return false;
                }
                log4j.debug("update coupon " + ob._name);
                return true;
        }

        @Override
        public boolean deleteCoupon(int id) {
                Coupon couponToDel = null;
                try {
                        session = sessionFactory.openSession();
                        session.beginTransaction();
                        //-------------
                        couponToDel = new Coupon();
                        couponToDel.set_id(id);
                        
                        System.out.println(couponToDel);
            session.delete(couponToDel);
                        //-------------
                        session.getTransaction().commit();
                        session.close();
                                                                System.out.println("deleting coupon "+id+" completed.");
                } catch (HibernateException e) {
                                                        System.out.println("error: deleting coupon: "+id);
            return false;
        }
                log4j.debug("delete coupon " + id);
                return true;
        }

        @Override
        public Coupon getCoupon(int id) {
                Coupon coupon = null;
                try {
                        session = sessionFactory.openSession();
                        session.beginTransaction();
                        //-------------
                        coupon =  (Coupon) session.get(Coupon.class, id);
                        //-------------
                        session.getTransaction().commit();
                        session.close();
                                                                        System.out.println("get coupon completed."+cr);
                } catch (Exception e) {
                                                                        System.out.println("error: get coupon."+cr);
                        e.printStackTrace();
                        return null;
                }
                log4j.debug("get coupon " + id);
                return coupon;
        }
        
        @Override
        public boolean addCoupon(Coupon ob) {

                try {
                        session = sessionFactory.openSession();
                        session.beginTransaction();
                        //----------------------
//                        Calendar c = Calendar.getInstance();
//                        c.add(Calendar.DATE,0); 
//                        Criteria criteria = session.createCriteria(Coupon.class);
//                        criteria.add(Restrictions.ge("DATE", c.getTime()));
//                        List results = criteria.list();
//                        System.out.println(results);
                        System.out.println(ob);
                        session.save(ob);
                        //----------------------
                        session.getTransaction().commit();
                        session.close();
                                                                System.out.println("add coupon "+ob.get_id()+" "+ob.get_busniess_id()+""+cr);
                } catch (Exception e) {
                                                                System.out.println("error: add coupon."+cr);
                        return false;
                }
                log4j.debug("add coupon " + ob._name);
                return true;
        }
        
        @Override
        public Iterator<Coupon> getAllCoupons() {
                Iterator iterator = null;
                try {
                        session = sessionFactory.openSession();
                        session.beginTransaction();
                        //-------------
                        List coupons = session.createCriteria(Coupon.class).list();
                        System.out.println("There are " + coupons.size() + " coupon(s):");
                        iterator = coupons.iterator();
//                        while(iterator.hasNext()) 
//                        {
//                                System.out.println(iterator.next());
//                        }
//                        //-------------
                        session.getTransaction().commit();
                        session.close();
                                                                System.out.println("getting all coupons completed."+cr);
                } catch (HibernateException e) {
                                                        System.out.println("error: deleting coupon"+cr);
                        return null;
        }
                log4j.debug("get coupons iterator ");
                return iterator;
        }
}