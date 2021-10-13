package dao;

import models.UserDetails;
import models.UserPasswords;

public class UserDao {
	public static void saveUserDetails(UserDetails userDetails) {
		DbConnector.save(userDetails);
	}
	
	
}
