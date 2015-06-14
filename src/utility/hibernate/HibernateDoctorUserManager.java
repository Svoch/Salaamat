package utility.hibernate;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import users.Doctor;
import users.Patient;
import users.User;
import users.management.DoctorUserManager;


public class HibernateDoctorUserManager implements IHibernateUserManager {

	/**
	 * TODO check uniqueness of username
	 * TODO add and manage exceptions
	 */
	public boolean login(String username, String password) {

		BasicConfigurator.configure();

//		System.out.println("here I am... I am here to login!");

		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		/**
		 * TODO understand what the hell is wrong with Transaction; it should be instantiated though not being used!
		 */
		@SuppressWarnings("unused")
		Transaction tx = session.beginTransaction();

		int ID = (int) session.createQuery(
			    "select ID from users.Doctor where username = '" + username + "'")
			    .uniqueResult();
		
		Doctor doctor =  (Doctor) session.load(Doctor.class, ID);

		// TODO ummm... what can be done to improve the performance
		//tx.setTimeout(0);
		//tx.commit();

		if( doctor.getPassword().equals(password) ) {
			new DoctorUserManager().setLoggedInUser(doctor); 
        	session.close();
			return true;
		}
		else {
        	session.close();
			return false;        
		}

	}

	@Override
	public void signup(User doctor) {

		BasicConfigurator.configure();

//    	System.out.println("here I am... I am here to sign-up a doctor!");

		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		session.save(doctor);
		tx.commit();
		
	}
	
	@Override
	public void update(User doctor) {

		BasicConfigurator.configure();

		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
    
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        
    	session.update((Doctor) doctor);                
        tx.commit();

        System.out.println 
        		("updating patient to be " + doctor.toString() );
			
	}

	/**
	 * Wohooooo! This one works flawless... I finally figured out how to handle this
	 * @param doctor
	 * @return
	 */
	public List<Object> getPatientsList(Doctor doctor) {
		
		BasicConfigurator.configure();

//		System.out.println("here I am... I am here to fetch some patients!");

		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		/**
		 * TODO understand what the hell is wrong with Transaction; it should be instantiated though not being used!
		 */
		@SuppressWarnings("unused")
		Transaction tx = session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Object> list = session.createQuery(
			    "from users.Patient where supervisorID = " + doctor.getID())
			    .list();	

		session.close();
		return list;
	}

	public List<Object> getPatientApplicantsList(Doctor doctor) {
		BasicConfigurator.configure();

//		System.out.println("here I am... I am here to fetch some patients!");

		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		/**
		 * TODO understand what the hell is wrong with Transaction; it should be instantiated though not being used!
		 */
		@SuppressWarnings("unused")
		Transaction tx = session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Object> list = session.createQuery(
			    "from users.Patient where requestedSupervisorID = " + doctor.getID())
			    .list();	

		session.close();
		return list;
	}
	
	public List<Object> getPatientsWithQuestionsList(Doctor doctor) {
		BasicConfigurator.configure();

//		System.out.println("here I am... I am here to fetch some patients!");

		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		/**
		 * TODO understand what the hell is wrong with Transaction; it should be instantiated though not being used!
		 */
		@SuppressWarnings("unused")
		Transaction tx = session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Object> list = session.createQuery(
			    "from users.Patient where ID in (select ID.patientID from utility.Consultation where ID.doctorID = " + doctor.getID() + " )")
			    .list();	

		session.close();
		return list;
	}

	
	
	
	
	
	
	/*
	 * some local tests here...
	 */
	public static void main(String[] args) {
		List<Object> patientsList = (new HibernateDoctorUserManager()).getPatientsList(((Doctor)IHibernateUserManager.getDoctor(1)));
		System.out.println("I am here!");
		int i = 0;
		for(Object o : patientsList) {
			Patient p = (Patient) o;
			System.out.println("get all doctorsList with i = " + i + " gives " + p.toString() + "\n" 
					+"username is: " + p.getUsername() + "\n"
					+"password is: " + p.getPassword() + "\n"
					+"adress is: " + p.getAddress() + "\n"
					+"supervisorID is: " + p.getSupervisorID() + "\n"
					+"confirmed is: " + p.getConfirmed() + "\n --------------------------------------"
					);
			i++;
		}
		System.out.println("I am here too!");
	}

	
	

}
