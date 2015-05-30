package users;

public abstract class User {

	private String firstname;
	private String surname;
	private String password;
	private String address;
	private boolean confirmed = false;
	
	
	
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
	
}
