package users.management;

import java.util.List;

import users.User;
import utility.hibernate.IHibernateUserManager;

public interface IUserManager {
	
	/**
	 * Authenticates a given username and a given password
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean login(String username, String password);
	public void signup(User user);
	public void update(User user);
	
	public User getLoggedInUser();
	public void setLoggedInUser(User user);
	
	public static List<Object> getAllDoctorsList() {
		return IHibernateUserManager.getAllDoctorsList();
	}
	public static List<Object> getAllPatientsList() {
		return IHibernateUserManager.getAllPatientsList();
	}
	public static Object getDoctor(int ID) {
		return IHibernateUserManager.getDoctor(ID);
	}
	public static Object getPatient(int ID) {
		return IHibernateUserManager.getPatient(ID);
	}
	public static Object getConsultation(int doctorID, int patientID) {
		return IHibernateUserManager.getConsultation(doctorID,patientID);
	}
	
}
