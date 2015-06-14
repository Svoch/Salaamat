package users.management;


import java.util.List;

import users.Doctor;
import users.Patient;
import users.User;
import utility.hibernate.HibernateDoctorUserManager;
import utility.hibernate.IHibernateUserManager;

/**
 * @author siavashnazari
 *
 */
public class DoctorUserManager implements IUserManager {

	private static Doctor loggedInDoctor;
	
	@Override
	/**
	 * TODO connect to DB here
	 * TODO handle exceptions 
	 */
	public boolean login(String username, String password) {

		return new HibernateDoctorUserManager().login(username, password);
      
	}
	
	/**
	 * @param doctor
	 */
	@Override
	public void signup(User doctor) {
		
		new HibernateDoctorUserManager().signup(doctor);
		
	}
	
	/**
	 * TODO connect to DB here
	 * TODO handle exceptions 
	 */
	@Override	
	public void update(User doctor) {
		
		new HibernateDoctorUserManager().update(doctor);
		
	}


	@Override
	public User getLoggedInUser() {
		return loggedInDoctor;
	}

	@Override
	public void setLoggedInUser(User user) {
		DoctorUserManager.loggedInDoctor = (Doctor) user;
	}


	public List<Object> getPatientsList(Doctor doctor) {
		
		return new HibernateDoctorUserManager().getPatientsList(doctor);
	
	}
	public List<Object> getPatientApplicantsList(Doctor doctor) {

		return new HibernateDoctorUserManager().getPatientApplicantsList(doctor);
	
	}
	public List<Object> getPatientsWithQuestionsList(Doctor doctor) {

		return new HibernateDoctorUserManager().getPatientsWithQuestionsList(doctor);
		
	}
	

	public void answerConsultation(Doctor doctor, Patient patient, String question, String answer) {
		
		IHibernateUserManager.makeConultation(doctor, patient, question, answer);
		
	}

	

}
