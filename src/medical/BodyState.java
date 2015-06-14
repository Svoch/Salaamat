package medical;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


enum BodyStateType {
    Height, Weight, BloodPreasure, BloodSugar
}

class BodyStateID implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2924026230841541200L;
	
	private BodyStateType bodyStateType;
	private int patientID;
	
	/**
	 * TODO convert date to class Date
	 */
	private int date;
	
	public BodyStateID() {
		
	}
	
	public BodyStateID(String type, int patientID, int date) {
		this.bodyStateType = BodyStateType.valueOf(type);
		this.patientID = patientID;
		this.date = date;
	}
	
	public medical.BodyStateType getBodyStateType() {
		return bodyStateType;
	}
	public void setBodyStateType(BodyStateType bloodsugar) {
		this.bodyStateType = bloodsugar;
	}
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	
	
}

@Entity
@Table(name="BodyState_Patient")
public class BodyState {
	
	@Id
	private BodyStateID ID;
	private int measurement;
	
	public BodyState() {
	
	}
	
	/**
	 * TODO move this piece of shit to management classes
	 * @return
	 */
	public static List<BodyStateType> getAllBodyStateTypes() {
		List<BodyStateType> list = new ArrayList<BodyStateType>(EnumSet.allOf(BodyStateType.class));
		return list;
	}

	public BodyStateID getID() {
		return ID;
	}
	public void setID(BodyStateID ID) {
		this.ID = ID;
	}
	
	public BodyStateID getBodyStateID() {
		return ID;
	}
	public void setBodyStateID(BodyStateID ID) {
		this.ID = ID;
	}
	public void setBodyStateID(String type , int patientID , int date ) {
		BodyStateID ID = new BodyStateID(type,patientID,date);
		this.ID = ID;
	}

	public BodyStateType getType() {
		return ID.getBodyStateType();
	}
	public int getDate() {
		return ID.getDate();
	}
	public int getPatientID() {
		return ID.getPatientID();
	}
	public int getMeasurement() {
		return measurement;
	}
	public void setMeasurement(int measurement) {
		this.measurement = measurement;
	}
	
	@Override
	public String toString() {
		return "BodyState " + getType() + " of " + measurement + " at date " + getDate()  ;
	}

	
//	public static void main(String[] args) {
//		
//		BasicConfigurator.configure();
//
//    	System.out.println("here I am... I am here to test BodyState!");
//
//		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
//        Session session = sessionFactory.getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        
//		BodyState bodyState1 = new BodyState();
//		BodyState bodyState2 = new BodyState();
//
//		BodyStateID bodyStateID1 = new BodyStateID("BloodSugar", 3, 10);
//		BodyStateID bodyStateID2 = new BodyStateID("Weight" , 3 , 14);
//		
//		
//		Patient p3 = (Patient) session.createQuery(
//				"from Patient where ID = 3").uniqueResult();
//		Patient p1 = (Patient) session.createQuery(
//				"from Patient where ID = 1").uniqueResult();
//
//		bodyState1.setBodyStateID(bodyStateID1);
//		bodyState2.setBodyStateID(bodyStateID2);
//
//		
////		p5.addBodyState(bodyState2,7);
////		p7.addBodyState(bodyState2,10);
//		
////		session.saveOrUpdate(p5);
////		session.saveOrUpdate(p7);
//
//		session.saveOrUpdate(bodyState2);
//		session.saveOrUpdate(bodyState1);
//		
//		System.err.println("fuck");
//		
//		BodyStateType inputType = BodyStateType.Height;
//		List<BodyState> patientBodyStates = (List<BodyState>) session.createQuery("from BodyState where ID.bodyStateType = 'Height'" ).list();
//		
//		System.out.println("-------------------------------------------------------");
//		
//		for(BodyState i : patientBodyStates) {
//			System.out.println("BodyState of patient " + i.toString());
//		}
//		
//		tx.commit();
//
//		System.err.println("nothing to see here...");
//
//		
//	}

	
}
