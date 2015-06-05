package utility.hibernate;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import users.Doctor;
import users.Patient;
import users.User;
import users.management.PatientUserManager;

public class HibernatePatientUserManager implements IHibernateUseManager {

	@Override
	public boolean login(String username, String password) {

		BasicConfigurator.configure();
		
//    	System.out.println("here I am... I am here to login!");
    	
		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
        Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unused")
        Transaction tx = session.beginTransaction();
        
        int ID = (int) session.createQuery(
			    "select ID from users.Patient where username = '" + username + "'")
			    .uniqueResult();
		
		Patient patient =  (Patient) session.load(Patient.class, ID);
		
        if( patient.getPassword().equals(password) ) {
        	new PatientUserManager().setLoggedInUser(patient); 
        	Hibernate.initialize(patient);
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
	public void signup(User patient) {

		BasicConfigurator.configure();
		
    	System.out.println("here I am!... I am here to sign-up a new Patient");
    	
		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
    
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

//      ((Patient) patient).setSupervisor((Doctor)(IHibernateUseManager.getDoctor(1)));
    	    	
    	session.save(patient);                
        tx.commit();
        
        System.out.println 
        		("The Patient " + patient.getFirstname()+ " " 
        		+ patient.getSurname()+" is successfully added to your database");
	}

	public void issueRequest(Patient patient, Doctor doctor) {
		
		BasicConfigurator.configure();
		
		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
    
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        
        //System.err.println("updating patient to be " + patient.toString() + " with requested supervisor as " + patient.getRequestedSupervisor());
   	
    	session.update(patient);                
        tx.commit();

        System.out.println 
        		("updating patient to be " + patient.toString() + " with requested supervisor as " + patient.getRequestedSupervisor());

	}

	@Override
	public void update(User patient) {

			BasicConfigurator.configure();

			SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
   
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			
			session.update((Patient) patient);                
			tx.commit();

			System.out.println 
					("updating patient to be " + patient.toString() );

	}

}
