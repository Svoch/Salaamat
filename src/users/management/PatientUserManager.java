package users.management;

import java.util.ArrayList;
import java.util.List;

import medical.BodyState;
import medical.PhysicalActivity;
import users.Doctor;
import users.Patient;
import users.User;
import utility.hibernate.HibernatePatientUserManager;
import utility.hibernate.IHibernateUserManager;

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

	public List<BodyState> getBodyStatesList(Patient patient) {
		
		List<Object> objectBodyStates = new HibernatePatientUserManager().getBodyStates(patient);
		List<BodyState> result = new ArrayList<BodyState>();
		
		for(Object obj : objectBodyStates)
			result.add((BodyState) obj);

		return result; 
	
	}
	
	public List<PhysicalActivity> getPhysicalActivitiesList(Patient patient) {
		
		List<Object> objectPhysicalActivities = new HibernatePatientUserManager().getPhysicalActivities(patient);
		List<PhysicalActivity> result = new ArrayList<PhysicalActivity>();
		
		for(Object obj : objectPhysicalActivities)
			result.add((PhysicalActivity) obj);

		return result; 

	}

	

	public void makeConsultation(Doctor doctor, Patient patient,String question, int date) {
		IHibernateUserManager.makeConultation(doctor,patient,question,null, date);
	}

	public static void addPhysicalActivity(Patient patient, int type, int measurement, int date) {
		IHibernateUserManager.addPhysicalActivity(patient,type, measurement,date);
	}

	public List<Object> getConsultingDoctorsList(Patient patient) {
		List<Object> list = new HibernatePatientUserManager().getConsultingDoctorsList(patient);
		return list;
	}

	

}
