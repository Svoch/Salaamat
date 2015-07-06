package utility;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


class ConsultationID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 927745753175177570L;
	
	private int patientID;
	private int doctorID;
	
	public ConsultationID() {
		
	}

	public ConsultationID(int doctorID, int patientID) {
		this.patientID = patientID;
		this.doctorID = doctorID;
	}
	
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public int getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}
	
}

@Entity
@Table(name="Doctor_Patient")
public class Consultation {
	
	@Id
	private ConsultationID ID;
	private String question;
	private String answer;
	private int date;
	
	public Consultation() {
		
	}
	
	public Consultation(int doctorID, int patientID) {
		ID = new ConsultationID(doctorID,patientID);
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getdate() {
		return date;
	}
	public void setdate(int d) {
		System.out.println(d);
		date = d;
	}
	public ConsultationID getID() {
		return ID;
	}
	public void setID(ConsultationID ID) {
		this.ID = ID;
	}
	
	
	@Override
	public String toString() {
		return "Consultation between Patient with ID of " + ID.getPatientID() + " and Doctor with ID of " + ID.getDoctorID() + ". Question is " + question + " and answer is " + answer;
	}
	
//	public static void main(String[] args) {
//		
//		BasicConfigurator.configure();
//
//		System.out.println("here I am... I am here to test Consultation!");
//
//		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
//		Session session = sessionFactory.getCurrentSession();
//		Transaction tx = session.beginTransaction();
//
//		Consultation consultation1 = new Consultation(1,3);
//		Consultation consultation2 = new Consultation(1,5);
//		
//		consultation1.setQuestion("Hi, I have stomach ache!");
//		consultation1.setAnswer("Hi, use the pills I prescribed for Amraaz-e Kohan.");
//		
//		consultation2.setQuestion("Hi, when can I come by to your office and give you shirini? :)");
//
//		System.out.println("-------------------------------------------------------");
//		
//		session.saveOrUpdate(consultation1);
//		session.saveOrUpdate(consultation2);
//
//		List<Object> list = session.createQuery(
//				"from Consultation where ID.patientID = 1").list();
//		
////		Consultation consultation = (Consultation) session.createQuery(
////				"from Consultation where doctorID = " + 1 + " and patientID = " + 5).uniqueResult();
//		
//		for(Object consultation: list)
//			System.out.println("Consultation is: " + ((Consultation) consultation).toString());
//		
//		tx.commit();
//
//		System.err.println("nothing to see here...");
//
//	}

}
