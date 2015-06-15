package users.management;


import users.Drugstore;

import users.User;
import utility.hibernate.HibernateDrugstoreUserManager;

public class DrugstoreUserManager implements IUserManager {

	private static Drugstore LoggedInDrugstore;
	
	@Override
	/**
	 * TODO connect to DB here
	 */
	public boolean login(String username, String password) {
		
		return new HibernateDrugstoreUserManager().login(username, password);

	}

	@Override
	public void signup(User drugstore) {

		new HibernateDrugstoreUserManager().signup(drugstore);
		
	}

	@Override
	public User getLoggedInUser() {
		return LoggedInDrugstore;
	}

	@Override
	public void setLoggedInUser(User user) {
		DrugstoreUserManager.LoggedInDrugstore = (Drugstore) user;
	}

	@Override
	public void update(User drugstore) {

		new HibernateDrugstoreUserManager().update(drugstore);

		
	}

}
