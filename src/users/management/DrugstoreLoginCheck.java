package users.management;


import users.Drugstore;
import users.User;

public class DrugstoreLoginCheck implements IUserManager {

	private static Drugstore LoggedInDrugstore;
	
	@Override
	/**
	 * TODO connect to DB here
	 */
	public boolean login(String username, String password) {
		if(username.equals("drugstore") && password.equals("123"))
			return true;
		return false;
	}

	@Override
	public void signup(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getLoggedInUser() {
		// TODO Auto-generated method stub
		return LoggedInDrugstore;
	}

	@Override
	public void setLoggedInUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

}
