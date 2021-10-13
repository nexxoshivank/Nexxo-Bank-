package dao;

import models.UserDetails;

public class ActivateButtonDao {
	
	public static void activateCustomer(UserDetails userDetails){
		DbConnector.save(userDetails);
	}
}
