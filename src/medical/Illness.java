package medical;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;


import users.Patient;

@Entity
@Table(name="Illness")
public class Illness {

	private int ID;
	private String title;
	private String description;

	private Set<Patient> patients;
	
	
	public Illness(String title) {
		this.title = title;
		patients = new HashSet<Patient>();
	}
	public Illness() {
		this.title = null;
		patients = new HashSet<Patient>();
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * TODO bad for coupling
	 * @return
	 */
	public Set<Patient> getPatients() {
		return patients;
	}
	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}
	public void addPatient(Patient patient) {
		patients.add(patient);
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return "Illness " + title;
	}
	
	
	public static void main(String[] args) {
		
//		BasicConfigurator.configure();
//
//    	System.out.println("here I am... I am here to sign-up a doctor!");
//
//		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
//        Session session = sessionFactory.getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        
//		Illness illness1 = new Illness("Maraz");
//		Illness illness2 = new Illness("Dard");
//		
//		Patient patient1 = new Patient("Benyamin","Mazaheri","lanatbeOODlanatbeOOD","ghoromsagh","Khiaban Valiasr, Kooche Minu");
//		Patient patient2 = new Patient("Milad", "Khorsand", "blueDanoob", "123", "Khiaban Sani, Meydoon 18, Pelak 20");
//		Patient patient3 = new Patient("Jessie","J","JJ","123","King street, North York, UK");
//		
//		patient1.addIllness(illness2); //dard
//		patient1.addIllness(illness1);
//		patient2.addIllness(illness2); //dard
//		patient3.addIllness(illness1);
//		
//		session.save(patient1);
//		session.save(patient2);
//		session.save(patient3);
//		
//		System.err.println("fuck");
//		
//		String input = "Dard";
//		Illness illness = (Illness) session.createQuery("from Illness where Title = '" + input + "'" ).uniqueResult();
//		
//		System.out.println("-------------------------------------------------------");
//		System.out.println("illness is " + illness);
//		
//		System.out.println( ((Patient) session.createQuery(
//				"from Patient where ID = 2").uniqueResult()).toString() );
//
//		patient1.addIllness(illness);
//		
//		List patientIDs = (session.createQuery(
//				"from Diagnosis").list());
//		
//		for(Object i : patientIDs) {
//			System.out.println("Patient with ID of " + i + " has " + illness.getTitle());
//			session.delete(i);
//		}
//		
//		session.delete(illness);
//		session.delete(patient3);
//		session.delete(patient2);
//		session.delete(patient1);
//		session.delete(illness2);
//		session.delete(illness1);
//		
//		
//		tx.commit();
//		session.close();

		System.err.println("nothing to see here...");
		
	}
	
	
	
	
}
