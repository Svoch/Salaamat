package users;

public class Patient extends User {

	private Doctor supervisor = null;
	private Doctor requestedSupervisor = null;
	
	public void requestSupervisor(Doctor doctor) {
		requestedSupervisor = doctor;
	}
	
	/**
	 * TODO implement this
	 * was named 'makeDiscussion' in Class Diagram
	 */
	public void consult(String question) {
		
	}

	
	public Doctor getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Doctor supervisor) {
		this.supervisor = supervisor;
	}
	public Doctor getRequestedSupervisor() {
		return requestedSupervisor;
	}

}
