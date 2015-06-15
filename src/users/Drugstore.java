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
@Table(name="Drugstore")
@AttributeOverrides({
	@AttributeOverride(name="firstname", column=@Column(name="Name")),
	@AttributeOverride(name="surname", column=@Column(name="Certificate")),
	@AttributeOverride(name="username", column=@Column(name="Username")),
	@AttributeOverride(name="password", column=@Column(name="Password")),
	@AttributeOverride(name="address", column=@Column(name="Address")),
})
public class Drugstore extends User {

	public Drugstore(String name, String certificateNumber, String username,	String password, String address) {
		super(name, certificateNumber, username, password, address);
	}
	public Drugstore(){
		super();
	}
	
	@Override
	public String toString() {
		return "Drugstore " + getFirstname();
	}
	@Override
	public boolean equals(Object obj) {
		return ((Drugstore) obj).getID()==getID();
	}
	
	/**
	 * TODO implement this
	 */
	public void deliverPrescription() {
		
	}
}
