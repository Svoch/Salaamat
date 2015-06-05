package users.management;

import users.Doctor;
import users.Patient;
import users.User;
import utility.hibernate.HibernatePatientUserManager;

public class PatientUserManager implements IUserManager {

	private static Patient loggedInPatient;
	
	/**
	 * TODO connect to DB here
	 * TODO handle exceptions 
	 */
	@Override
	public boolean login(String username, String password) {

		return new HibernatePatientUserManager().login(username, password);
 
	}

	/**
	 * TODO connect to DB here
	 * TODO handle exceptions 
	 */
	@Override
	public void signup(User patient) {
		
		new HibernatePatientUserManager().signup(patient);
		
	}
	
	/**
	 * TODO connect to DB here
	 * TODO handle exceptions 
	 */
	@Override	
	public void update(User patient) {
		
		new HibernatePatientUserManager().update(patient);
		
	}

	@Override
	public User getLoggedInUser() {
		return loggedInPatient;
	}

	@Override
	public void setLoggedInUser(User user) {
		PatientUserManager.loggedInPatient = (Patient) user;		
	}

	public void issueRequest(Patient patient, Doctor doctor) {
		
		new HibernatePatientUserManager().issueRequest(patient,doctor);
		
	}

	

}
