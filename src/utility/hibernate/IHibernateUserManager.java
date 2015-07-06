package utility.hibernate;

import java.util.List;

import medical.PhysicalActivity;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import users.Doctor;
import users.Patient;
import users.User;
import utility.Consultation;

public interface IHibernateUserManager {

	/**
	 * Authenticates a given username and a given password
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean login(String username, String password);
	public void signup(User user);
	public void update(User user);

	
	public static List<Object> getAllDoctorsList() {
		
		BasicConfigurator.configure();

//		System.out.println("here I am... I am here to fetch all doctors!");

		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		/**
		 * TODO understand what the hell is wrong with Transaction; it should be instantiated though not being used!
		 */
		@SuppressWarnings("unused")
		Transaction tx = session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Object> list = session.createCriteria(Doctor.class).list();
		
		System.err.println(list.size());		

		session.close();
		return list;
	}
	
	public static List<Object> getAllPatientsList() {
		
		BasicConfigurator.configure();

//		System.out.println("here I am... I am here to fetch all Patients!");

		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		/**
		 * TODO understand what the hell is wrong with Transaction; it should be instantiated though not being used!
		 */
		@SuppressWarnings("unused")
		Transaction tx = session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Object> list = session.createCriteria(Patient.class).list();
				
		System.err.println(list.size());		

    	session.close();
		return list;
	}
	
	public static Object getDoctor(int ID) {
		
		BasicConfigurator.configure();

//		System.out.println("here I am... I am here to fetch a Doctor!");

		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		/**
		 * TODO understand what the hell is wrong with Transaction; it should be instantiated though not being used!
		 */
		@SuppressWarnings("unused")
		Transaction tx = session.beginTransaction();
		
		Doctor doctor =  (Doctor) session.load(Doctor.class, ID);

//    	session.close();
		return (Object) doctor;	
	}
	public static Object getPatient(int ID) {
		
		BasicConfigurator.configure();
		
//		System.out.println("here I am... I am here to fetch a Patient!");

		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		/**
		 * TODO understand what the hell is wrong with Transaction; it should be instantiated though not being used!
		 */
		@SuppressWarnings("unused")
		Transaction tx = session.beginTransaction();
		
		Object patient =  session.load(Patient.class, ID);

    	session.close();
		return (Object) patient;	
	}
	
	public static void makeConultation(Doctor doctor, Patient patient, String question, String answer, int date) {
		
		BasicConfigurator.configure();
    	
		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
    
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Consultation consultation = new Consultation(doctor.getID(), patient.getID());
      	consultation.setQuestion(question);
       	consultation.setAnswer(answer);
       	consultation.setdate(date);
       	
    	session.saveOrUpdate(consultation);                
        tx.commit();
		
	}

	public static Object getConsultation(int doctorID, int patientID) {
		
		BasicConfigurator.configure();
		
		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("unused")
		Transaction tx = session.beginTransaction();
		
		Consultation consultation = (Consultation) session.createQuery(
				"from Consultation where ID.doctorID = " + doctorID + " and ID.patientID = " + patientID).uniqueResult();
		
    	session.close();
		return (Object) consultation;
		
	}
	
	public static void addPhysicalActivity(Patient patient,int type, int measurement, int date) {
		
		BasicConfigurator.configure();

//		System.out.println("here I am... I am here to fetch an Illness!");

		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		PhysicalActivity physicalActivity = new PhysicalActivity(patient.getID(),date);
		physicalActivity.setMeasurement(measurement);
		physicalActivity.setType(type);
		
		session.saveOrUpdate(physicalActivity);
		tx.commit();
		
		System.out.println("PhysicalActivity " + physicalActivity.toString() + " has been added to PhysicalActivity_Patient table");
		
	}

	
	
	
	
	
	/*
	 * some local tests here...
	 */
	public static void main(String[] args) {
		Doctor d = (Doctor) getDoctor(1);
		System.out.println("getDoctor with ID = 1 gives " + d.toString() + "\n" 
				+"username is: " + d.getUsername() + "\n"
				+"password is: " + d.getPassword() + "\n"
				+"adress is: " + d.getAddress() + "\n"
				+"specialty is: " + d.getSpecialty() 
				);
		System.out.println("passed here!");
		Patient p = (Patient) getPatient(1);
		System.out.println("getPatient with ID = 1 gives " + p.toString() + "\n" 
				+"username is: " + p.getUsername() + "\n"
				+"password is: " + p.getPassword() + "\n"
				+"adress is: " + p.getAddress() + "\n"
				+"rfkdslksd is: " + p.getRequestedSupervisorID() 
				);
		System.out.println("passed here too!");

		List<Object> doctorsList = getAllDoctorsList();
		int i = 0;
		for(Object o : doctorsList) {
			d = (Doctor) o;
			System.out.println("get all doctorsList with i = " + i + " gives " + d.toString() + "\n" 
					+"username is: " + d.getUsername() + "\n"
					+"password is: " + d.getPassword() + "\n"
					+"adress is: " + d.getAddress() + "\n"
					+"specialty is: " + d.getSpecialty() 
					);
			i++;
		}
		
	}
	
}
