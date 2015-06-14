package medical;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import utility.hibernate.HibernateUtility;

class PhysicalActivityID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -130669174155634780L;
	
	private int patientID;
	private int date;
	
	public PhysicalActivityID() {
		
	}
	public PhysicalActivityID(int patientID, int date) {
		this.setPatientID(patientID);
		this.setDate(date);
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
@Table(name="PhysicalActivity_Patient")
public class PhysicalActivity {

	@Id
	private PhysicalActivityID ID;
	private int measurement;
	
	public PhysicalActivity() {
		
	}
	public PhysicalActivity(int patientID, int date) {
		ID = new PhysicalActivityID(patientID,date);
	}

	
	public PhysicalActivityID getID() {
		return ID;
	}
	public void setID(PhysicalActivityID iD) {
		ID = iD;
	}
	public int getMeasurement() {
		return measurement;
	}
	public void setMeasurement(int measurement) {
		this.measurement = measurement;
	}
	public int getDate() {
		return ID.getDate();
	}
	
	@Override
	public String toString() {
		return "PhysicalActivity of " + measurement + " at date " + ID.getDate();
	}
	
	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		
		    	System.out.println("here I am... I am here to test BodyState!");
		
				SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
		        Session session = sessionFactory.getCurrentSession();
		        Transaction tx = session.beginTransaction();
		        
				PhysicalActivity physicalActivity1 = new PhysicalActivity(3,40);
				PhysicalActivity physicalActivity2 = new PhysicalActivity(3,50);
		
				physicalActivity1.setMeasurement(41);
				physicalActivity2.setMeasurement(23);
				
				session.saveOrUpdate(physicalActivity1);
				session.saveOrUpdate(physicalActivity2);
				
				System.err.println("fuck");
				
				List<PhysicalActivity> patientBodyStates = (List<PhysicalActivity>) session.createQuery("from PhysicalActivity where ID.patientID = 3" ).list();
				
				System.out.println("-------------------------------------------------------");
				
				for(PhysicalActivity i : patientBodyStates) {
					System.out.println("PhysicalActivity of patient " + i.toString());
				}
				
				tx.commit();
		
				System.err.println("nothing to see here...");
		
				
		
		
	}
	
	
}
