package utility.hibernate;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import utility.Diagnosis;
import medical.BodyState;
import medical.Illness;
import medical.Medicine;

public interface IHibernateMedicalEntityManager {

	public static List<Object> getAllIllnesses() {
		
		BasicConfigurator.configure();

//		System.out.println("here I am... I am here to fetch all Illnesses!");

		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		/**
		 * TODO understand what the hell is wrong with Transaction; it should be instantiated though not being used!
		 */
		@SuppressWarnings("unused")
		Transaction tx = session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Object> list = session.createCriteria(Illness.class).list();

		session.close();
		return list;
		
	}

	public static Object getIllnessByID(int ID) {

		BasicConfigurator.configure();

//		System.out.println("here I am... I am here to fetch an Illness!");

		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		/**
		 * TODO understand what the hell is wrong with Transaction; it should be instantiated though not being used!
		 */
		@SuppressWarnings("unused")
		Transaction tx = session.beginTransaction();
		
		Illness illness =  (Illness) session.load(Illness.class, ID);

    	session.close();
		return (Object) illness;
		
	}

	public static Object getIllnessByTitle(String title) {
		
		BasicConfigurator.configure();

//		System.out.println("here I am... I am here to fetch an Illness!");

		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		/**
		 * TODO understand what the hell is wrong with Transaction; it should be instantiated though not being used!
		 */
		@SuppressWarnings("unused")
		Transaction tx = session.beginTransaction();
		
		Illness illness =  (Illness) session.createQuery(
				"from Illness where title = '" + title + "'").uniqueResult();

    	session.close();
		return (Object) illness;
		
	}

	/**
	 * TODO handle exceptions here... or there!
	 * @param illness
	 */
	public static void addIllness(Illness illness) {
		
		BasicConfigurator.configure();

//		System.out.println("here I am... I am here to fetch an Illness!");

		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		session.saveOrUpdate(illness);
		tx.commit();
		
		System.out.println("Illness " + illness.toString() + " has been added to Illness table");
		
	}

	public static List<Object> getAllMedicines() {
		
		BasicConfigurator.configure();

//		System.out.println("here I am... I am here to fetch all Illnesses!");

		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		/**
		 * TODO understand what the hell is wrong with Transaction; it should be instantiated though not being used!
		 */
		@SuppressWarnings("unused")
		Transaction tx = session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Object> list = session.createCriteria(Medicine.class).list();

		session.close();
		return list;

	}

	public static void update(Diagnosis diagnosis) {
		
		BasicConfigurator.configure();

		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		session.update(diagnosis);   

		System.out.println 
			("updating diagnosis to be " + diagnosis.toString() );
		System.out.println
			("this diagnosis has ");
		for(Medicine med : diagnosis.getMedicines())
			System.out.println(med.toString());
		
		tx.commit();
		
	}

	public static Object getDiagnosis(int patientID, int illnessID) {
		
		BasicConfigurator.configure();

//		System.out.println("here I am... I am here to fetch an Illness!");

		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		/**
		 * TODO understand what the hell is wrong with Transaction; it should be instantiated though not being used!
		 */
		@SuppressWarnings("unused")
		Transaction tx = session.beginTransaction();
		
		Diagnosis diagnosis = (Diagnosis) session.createQuery(
				"from Diagnosis where patientID = " + patientID + " and illnessID = " + illnessID ).uniqueResult();
		
    	session.close();
		return (Object) diagnosis;
		
	}

	public static Object getMedicineByName(String name) {
		
		BasicConfigurator.configure();

//		System.out.println("here I am... I am here to fetch an Illness!");

		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		/**
		 * TODO understand what the hell is wrong with Transaction; it should be instantiated though not being used!
		 */
		@SuppressWarnings("unused")
		Transaction tx = session.beginTransaction();
		
		Medicine medicine =  (Medicine) session.createQuery(
				"from Medicine where name = '" + name + "'").uniqueResult();

    	session.close();
		return (Object) medicine;
		
	}

	public static void addBodyState(BodyState bodyState) {
		
		BasicConfigurator.configure();

//		System.out.println("here I am... I am here to fetch an Illness!");

		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		session.saveOrUpdate(bodyState);
		tx.commit();
		
		System.out.println("BodyState " + bodyState.toString() + " has been added to BodyState_Patient table");
		
	}

	
}
