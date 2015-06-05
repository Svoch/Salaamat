package users;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import medical.Illness;
import users.management.IUserManager;
import users.management.PatientUserManager;

/**
 * 
 * @author siavashnazari
 *
 */
@Entity
@Table(name="Patient")
@AttributeOverrides({
	@AttributeOverride(name="firstname", column=@Column(name="Firstname")),
	@AttributeOverride(name="surname", column=@Column(name="Surname")),
	@AttributeOverride(name="username", column=@Column(name="Username")),
	@AttributeOverride(name="password", column=@Column(name="Password")),
	@AttributeOverride(name="address", column=@Column(name="Address")),
})

public class Patient extends User {

	public Patient(String firstname, String surname, String username, String password, String address) {
		super(firstname, surname, username, password, address);
		setSupervisor(null);
		setIllnesses(new HashSet<Illness>());
	}
	public Patient(String firstname, String surname, String username, String password, String address, Doctor supervisor) {
		super(firstname, surname, username, password, address);
		setSupervisor(supervisor);
		setIllnesses(new HashSet<Illness>());
	}
	public Patient(){
		super();
		setIllnesses(null);
	}

	private Doctor supervisor = null;
	private Doctor requestedSupervisor = null;

	private int supervisorID = 0;
	private int requestedSupervisorID = 0;
	
	private Set<Illness> illnesses;

	
	public void requestSupervisor(Doctor doctor) {
		setRequestedSupervisor(doctor);
//		doctor.recieveApplication(this);
		new PatientUserManager().update(this);
	}

	/**
	 * TODO implement this
	 * was named 'makeDiscussion' in Class Diagram
	 */
	public void consult(String question) {

	}




	@Override
	public String toString() {
		return super.toString();
	}

	public Doctor getRequestedSupervisor() {
		return requestedSupervisor;
	}
	public int getRequestedSupervisorID() {
		return requestedSupervisorID;
	}
	/**
	 * TODO implement a decent setter
	 * TODO handle exceptions
	 * @param requestedSupervisorID
	 */
	void setRequestedSupervisorID(int requestedSupervisorID) {
		if(requestedSupervisorID <= 0) {
			this.requestedSupervisorID = 0;
			requestedSupervisor = null;
		}
		else {
			this.requestedSupervisorID = requestedSupervisorID;	
			requestedSupervisor = (Doctor) IUserManager.getDoctor(requestedSupervisorID);
		}
	}
	public void setRequestedSupervisor(Doctor requestedSupervisor) {
		this.requestedSupervisor = requestedSupervisor;
		if(requestedSupervisor == null)
			requestedSupervisorID = 0;
		else
			requestedSupervisorID = requestedSupervisor.getID();
	}


	public Doctor getSupervisor() {
		return supervisor;
	}
	public int getSupervisorID() {
		return supervisorID;
	}
	/**
	 * TODO implement a decent setter
	 * TODO handle exceptions
	 * @param supervisorID
	 */
	public void setSupervisorID(int supervisorID) {
		if(supervisorID == 0) {
			this.supervisorID = 0;
			supervisor = null;
		}
		else {
			this.supervisorID = supervisorID;	
			supervisor = (Doctor) IUserManager.getDoctor(supervisorID);
		}
	}
	public void setSupervisor(Doctor supervisor) {
		this.supervisor = supervisor;
		if(supervisor == null)
			supervisorID = 0;
		else
			supervisorID = supervisor.getID();
	}
	
	/**
	 * TODO handle methods in wrong classes
	 * @return
	 */
	public Set<Illness> getIllnesses() {
		return illnesses;
	}
	public void setIllnesses(Set<Illness> illnesses) {
		this.illnesses = illnesses;
	}
	public void addIllness(Illness illness) {
		illnesses.add(illness);
	}



}
