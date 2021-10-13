package dao;

import models.UserDetails;

public class DeactivateButtonDao {
	
	public static void deactivateCustomer(UserDetails userDetails) {
		DbConnector.save(userDetails);
	}
}
