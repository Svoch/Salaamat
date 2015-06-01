package users;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * 
 * @author siavashnazari
 *
 */
@Entity
@Table(name = "User")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {

	private int ID;
	private String firstname;
	private String surname;
	private String username;
	private String password;
	private String address;
	private boolean confirmed = false;
	
	public User(String firstname, String surname, String username, String password, String address) {
		this.firstname = firstname;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.address = address;
	}
	public User() {
		this.firstname = null;
		this.surname = null;
		this.username = null;
		this.password = null;
		this.address = null;
	}
	
	public boolean isConfirmed() { 
		return confirmed;
	}
	public void confirm() {
		confirmed = true;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	
	@Override
	public String toString() {
		return firstname+" "+surname;
	}
}
