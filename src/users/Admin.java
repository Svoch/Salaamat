package users;

import users.management.PatientUserManager;

/**
 * 
 * @author siavashnazari
 *
 */
public class Admin extends User {

	public Admin(String firstname, String surname, String username, String password, String address) {
		super(firstname, surname, username, password, address);
	}
	public Admin() {
		
	}
	
	public static String username = "admin";
	public static String password = "";
	
	/**
	 * TODO implement this
	 * @param user
	 */
	public void confirmRegistration(User user){
		/**
		 * TODO
		 * 1) Does it need to be generalized for all Users?
		 * 2) It is a little bit hard-coded and... dirty, but I...
		 * 
		 */
		user.setConfirmed(true);
		new PatientUserManager().update((Patient)user);
	}
}
