package users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import medical.Illness;
import medical.Medicine;
import medical.management.IMedicalEntityManager;
import users.management.DoctorUserManager;
import users.management.PatientUserManager;
import utility.Diagnosis;

/**
 * 
 * @author siavashnazari
 *
 */
@Entity
@Table(name="Doctor")
@AttributeOverrides({
	@AttributeOverride(name="firstname", column=@Column(name="Firstname")),
	@AttributeOverride(name="surname", column=@Column(name="Surname")),
	@AttributeOverride(name="username", column=@Column(name="Username")),
	@AttributeOverride(name="password", column=@Column(name="Password")),
	@AttributeOverride(name="address", column=@Column(name="Address")),

})
public class Doctor extends User {

	public Doctor(String firstname, String surname, String username, String password, String address) {
		super(firstname, surname, username, password, address);
		specialty = null;
		appliedPatientsList = new ArrayList<Patient>();
	}
	public Doctor(String firstname, String surname, String username, String password, String address, String specialty) {
		super(firstname, surname, username, password, address);
		this.specialty = specialty;
		appliedPatientsList = new ArrayList<Patient>();
	}
	public Doctor() {
		super();
		specialty = null;
		appliedPatientsList = new ArrayList<Patient>();
	}

	/**
	 * TODO handle exceptions 
	 * @return
	 */
	public List<Object> getPatientsList() {
		List<Object> list = new DoctorUserManager().getPatientsList(this);
		return list;
	}
	/**
	 * TODO handle exceptions 
	 * @return
	 */
	public List<Object> getPatientApplicantsList() {
		List<Object> list = new DoctorUserManager().getPatientApplicantsList(this);
		return list;
	}

	public void approveRequest(Patient patient) {
		patient.setRequestedSupervisor(null);
		patient.setSupervisor(this);
		new PatientUserManager().update(patient);
	}
	public void rejectRequest(Patient patient) {
		patient.setRequestedSupervisor(null);
		new PatientUserManager().update(patient);		
	}
	public void prescribe(Diagnosis diagnosis, Medicine medicine) {
		diagnosis.addMedicine(medicine);
		IMedicalEntityManager.update(diagnosis);
	}
	public void addIllness(Patient patient, Illness illness) {
		patient.addIllness(illness);
		new PatientUserManager().update(patient);
	}
	
	
	private String specialty;
	private ArrayList<Patient> appliedPatientsList;

	/**
	 * TODO implement this
	 * @param patient
	 * @param doctor
	 */
	public void referPatientToSpecialist(Patient patient, Doctor doctor) {

	}
	/**
	 * TODO implement this
	 * @param patient
	 */
	public void answerDiscussion(Patient patient) {

	}

	public String setSpecialty(String specialty) {
		return this.specialty=specialty;
	}
	public String getSpecialty() {
		return specialty;
	}

	@Override
	public String toString() {
		return "Doctor "+super.toString();
	}
	
	/**
	 * TODO find a better name for this method
	 * @param patient
	 */
	public void recieveApplication(Patient patient) {
		appliedPatientsList.add(patient);
	}
	@Deprecated
	public void setAppliedPatientsList(ArrayList<Patient> appliedPatientsList) {
		this.appliedPatientsList = appliedPatientsList;
	}
	
	
	
}
