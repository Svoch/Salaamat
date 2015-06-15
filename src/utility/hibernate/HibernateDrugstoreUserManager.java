package utility.hibernate;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import users.Drugstore;
import users.User;
import users.management.DrugstoreUserManager;

public class HibernateDrugstoreUserManager implements IHibernateUserManager {

	@Override
	public boolean login(String username, String password) {
		
		BasicConfigurator.configure();
    	
		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
        Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unused")
        Transaction tx = session.beginTransaction();
        
        int ID = (int) session.createQuery(
			    "select ID from users.Drugstore where username = '" + username + "'")
			    .uniqueResult();
		
        Drugstore drugstore =  (Drugstore) session.load(Drugstore.class, ID);
		
        if( drugstore.getPassword().equals(password) ) {
        	new DrugstoreUserManager().setLoggedInUser(drugstore); 
        	Hibernate.initialize(drugstore);
//        	tx.commit();
        	session.close();
        	return true;
        }
        else {
        	session.close();
        	return false; 
        }
		
	}

	@Override
	public void signup(User drugstore) {

		BasicConfigurator.configure();

		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		session.save(drugstore);
		tx.commit();
		
	}

	@Override
	public void update(User drugstore) {

		BasicConfigurator.configure();

		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
    
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        
    	session.update((Drugstore) drugstore);                
        tx.commit();

	}

}
