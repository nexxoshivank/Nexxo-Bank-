package dao;

import models.UserPasswords;

public class PasswordDao {
	
	public static void saveUserPasswords(UserPasswords userPasswords) {
		DbConnector.save(userPasswords);
	}
}
