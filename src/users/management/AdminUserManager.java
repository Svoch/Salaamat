package users.management;

import users.Admin;
import users.User;

public class AdminUserManager implements IUserManager {

	@Override
	public boolean login(String username, String password) {
		if( username.equals(Admin.username) && password.equals(Admin.password) )
			return true;
		return false;
	}

	@Override
	public void signup(User user) {

	}

	@Override
	public void update(User user) {

	}

	@Override
	public User getLoggedInUser() {
		return new Admin();
	}

	@Override
	public void setLoggedInUser(User user) {
		
	}

}
