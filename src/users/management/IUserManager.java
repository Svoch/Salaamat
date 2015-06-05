package users.management;

import java.util.List;

import users.User;
import utility.hibernate.IHibernateUseManager;

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
		return IHibernateUseManager.getAllDoctorsList();
	}
	public static List<Object> getAllPatientsList() {
		return IHibernateUseManager.getAllPatientsList();
	}
	public static Object getDoctor(int ID) {
		return IHibernateUseManager.getDoctor(ID);
	}
	public static Object getPatient(int ID) {
		return IHibernateUseManager.getPatient(ID);
	}
	
}
