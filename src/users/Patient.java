package users;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
		supervisor = null;
		supervisorName = null;
	}
	public Patient(String firstname, String surname, String username, String password, String address, Doctor supervisor) {
		super(firstname, surname, username, password, address);
		this.supervisor = supervisor;
		supervisorName = this.supervisor.toString();
	}

	private Doctor supervisor = null;
	private Doctor requestedSupervisor = null;
	
	private String supervisorName = null;
	
	public void requestSupervisor(Doctor doctor) {
		requestedSupervisor = doctor;
	}
	
	/**
	 * TODO implement this
	 * was named 'makeDiscussion' in Class Diagram
	 */
	public void consult(String question) {
		
	}

	
	public Doctor getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Doctor supervisor) {
		this.supervisor = supervisor;
		if(supervisor != null)
			supervisorName = supervisor.toString();
		else
			supervisorName = null;
	}
	public Doctor getRequestedSupervisor() {
		return requestedSupervisor;
	}

	
	@Override
	public String toString() {
		return super.toString();
	}
	public String getSupervisorName() {
		return supervisorName;
	}
	void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}

}
