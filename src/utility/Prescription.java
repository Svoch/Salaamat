package utility;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * This is a dummy class, only exists so that contents of Medicine_Illness table can be accessible
 * So basically this class belongs to utility package; she does no "defining" job
 * 
 * TODO think of possibility of placing this class in or in a sub-package of medical package
 * 
 * TODO I assume as professor Rouhani would say, Date should be part of this entity's primary key
 * 
 * @author siavashnazari
 *
 */
@Entity
@Table(name="Medicine_Illness_Patient")
public class Prescription implements Serializable {
	
	private static final long serialVersionUID = 668305974476546831L;

	@Id
	private int medicineID;
//	@Id
	private int illnessID;
//	@Id
	private int patientID;
	

	@Id
	private Diagnosis diagnosisID;

	private Prescription ID;
	
	public Prescription(){
		
	}
	
	public Diagnosis getDiagnosisID() {
		return diagnosisID;
	}
	public void setDiagnosisID(Diagnosis diagnosisID) {
		this.diagnosisID = diagnosisID;
	}
	public int getMedicineID() {
		return medicineID;
	}
	public void setMedicineID(int medicineID) {
		this.medicineID = medicineID;
	}
	
	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public int getIllnessID() {
		return illnessID;
	}
	public void setIllnessID(int illnessID) {
		this.illnessID = illnessID;
	}
	public Prescription getID() {
		return ID;
	}
	public void setID(Prescription iD) {
		this.ID = iD;
		this.medicineID = iD.medicineID;
		this.diagnosisID = iD.diagnosisID;
//		this.illnessID = diagnosisID.getIllnessID();
//		this.patientID = diagnosisID.getPatientID();
	}
	
	@Override
	public String toString() {
		return "Diagnosis with ID " + diagnosisID + " has Medicine with medicineID " + medicineID ;
	}
	
	/**
	 * TODO if equality check is necessary, you may need to implement this
	 */
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	
	public static void main(String[] args) {
		
//		BasicConfigurator.configure();
//
//		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
//        Session session = sessionFactory.getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        
//        Diagnosis diagnosis1;
//        
//        diagnosis1 = (Diagnosis) session.createQuery(
//        		"from Diagnosis where illnessID = 2 and patientID = 5"
//        		).uniqueResult();
//        
//        System.err.println("diagnosis1 has been retrieved as " + diagnosis1);
//
//        Diagnosis diagnosis2;
//        
//        diagnosis2 = (Diagnosis) session.createQuery(
//        		"from Diagnosis where illnessID = 3 and patientID = 9"
//        		).uniqueResult();
//        
//        System.err.println("diagnosis2 has been retrieved as " + diagnosis2);
//        
//        Medicine medicine1 = new Medicine();
//        medicine1.setName("Dava");
//        medicine1.setDescription("This is a perfect cure for some diseases...");
//        
//        
//        Medicine medicine2 = new Medicine();
//        medicine2.setName("Darmun");
//        medicine2.setDescription("This is a perfect cure for some other diseases...");
//        
//        diagnosis1.addMedicine(medicine1);
//        diagnosis1.addMedicine(medicine2);
//        diagnosis2.addMedicine(medicine2);
//        diagnosis1.addMedicine(medicine1);
//        
//        session.saveOrUpdate(diagnosis1);
//        session.saveOrUpdate(diagnosis2);
//		
//		System.err.println("fuck");
//		
//		
//		List patientIDs = (session.createQuery(
//				"from Prescription").list());
//		
//		for(Object i : patientIDs) {
//			System.out.println("Prescription with ID of " + i + " has " + ((Prescription) i).getMedicineID());
//		}
//		
//		tx.commit();
//
		System.err.println("nothing to see here...");
		
		
	}

}
