package users;

public class UserManager {

	private UserManager instance = null;
	private User loggedInUser = null;
	
	
	public UserManager getInstance() {
		return instance;
	}
	public void login(User user) {
		setLoggedInUser(user);
	}
	public void logout() {
		setLoggedInUser(null);
	}
	
	/**
	 * TODO implement this
	 */
	public void register() {
		
	}
	public User getLoggedInUser() {
		return loggedInUser;
	}
	private void setLoggedInUser(User loggedInUser) {
		this.loggedInUser = loggedInUser;
	}
	
}
