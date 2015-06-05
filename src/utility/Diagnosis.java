package utility;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import medical.Medicine;
import medical.management.IMedicalEntityManager;

/**
 * This is a dummy class, only exists so that contents of Illness_Patient table can be accessible
 * So basically this class belongs to utility package; she does no "defining" job
 * 
 * TODO think of possibility of placing this class in Illness.java file
 * 		=> UPDATE: this class can be named "Diagnosis" or something similar having diagnosis dates whit...
 * 
 * TODO I assume as professor Rouhani would say, Date should be part of this entity's primary key
 *
 * @author siavashnazari
 *
 */
@Entity
@Table(name="Illness_Patient")
public class Diagnosis implements Serializable{
	
	private static final long serialVersionUID = -1496057449263236429L;
	
	
	@Id
	private int patientID;
	@Id
	private int illnessID;
	
	private Diagnosis ID;
	
	private Set<Medicine> medicines;
	
	public Diagnosis(){
		
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
	public Diagnosis getID() {
		return ID;
	}
	public void setID(Diagnosis iD) {
		this.ID = iD;
		this.patientID = iD.patientID;
		this.illnessID = iD.illnessID;
	}
	public Set<Medicine> getMedicines() {
		return medicines;
	}
	public void setMedicines(Set<Medicine> medicines) {
		this.medicines = medicines;
	}
	public void addMedicine(Medicine medicine) {
		medicines.add(medicine);
		IMedicalEntityManager.update(this);
	}
	
	
	@Override
	public String toString() {
		return "Patient with patientID " + patientID + " has Illness with illnessID " + illnessID ;
	}
	
	/**
	 * TODO if equality check is necessary, you may need to implement this
	 */
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	

}
