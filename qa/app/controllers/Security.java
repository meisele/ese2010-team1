package controllers;

import models.User;

public class Security extends Secure.Security {

	/**
	 * Check the user for login.
	 * 
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 * @return true, if successful
	 */
	static boolean authenticate(String username, String password) {
		if (User.connect(username, password) != null)
			return true;
		else
			return false;
	}

	/**
	 * Switch to the home screen after logout.
	 */
	static void onDisconnected() {
		Application.index();
	}
}