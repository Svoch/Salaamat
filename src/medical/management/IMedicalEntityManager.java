package medical.management;

import java.util.List;

import medical.BodyState;
import medical.Illness;
import utility.Diagnosis;
import utility.hibernate.IHibernateMedicalEntityManager;

public interface IMedicalEntityManager {
	
	public static List<Object> getAllIllnesses() {
		return IHibernateMedicalEntityManager.getAllIllnesses();
	}
	public static Object getIllness(int ID) {
		return IHibernateMedicalEntityManager.getIllnessByID(ID);
	}
	public static Object getIllness(String title) {
		return IHibernateMedicalEntityManager.getIllnessByTitle(title);
	}
	public static void addIllness(Illness illness) {
		IHibernateMedicalEntityManager.addIllness(illness);
	}
	public static List<Object> getAllMedicines() {
		return IHibernateMedicalEntityManager.getAllMedicines();
	}
	public static void update(Diagnosis diagnosis) {
		IHibernateMedicalEntityManager.update(diagnosis);
	}
	public static Object getDiagnosis(int patientID, int illnessID) {
		return IHibernateMedicalEntityManager.getDiagnosis(patientID,illnessID);
	}
	public static Object getMedicine(String name) {
		return IHibernateMedicalEntityManager.getMedicineByName(name);
	}
	public static void addBodyState(BodyState bodyState) {
		IHibernateMedicalEntityManager.addBodyState(bodyState);
	}
	
//	public static List<Object> getAllBodyStateTypes() {
//		return BodyState.getAllBodyStateTypes();
//	}
	
}
