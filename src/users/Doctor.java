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
	}
	public Doctor(String firstname, String surname, String username, String password, String address, String specialty) {
		super(firstname, surname, username, password, address);
		this.specialty = specialty;
	}
	
	private String specialty;
	
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
	/**
	 * TODO implement this
	 * @param patient
	 */
	public void answerSupervisionRequest(Patient patient) {
		
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
}
