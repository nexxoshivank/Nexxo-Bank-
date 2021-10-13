package services;

import dao.ActivateButtonDao;
import dto.ActivateButtonRequest;
import dto.ActivateButtonResponse;
import models.Statuses;
import models.UserDetails;

import java.util.regex.Pattern;

public class ActivateButtonService {
	
	public static ActivateButtonResponse activateCustomer(ActivateButtonRequest activateButtonRequest) {
		
		ActivateButtonResponse activateButtonResponse = new ActivateButtonResponse();
		
		try {
			if (Pattern.matches("[0-9]{3}", activateButtonRequest.getUserId().toString())) {
				UserDetails userDetails = UserDetails.find.byId(activateButtonRequest.getUserId());
				
				if (userDetails.getStatusId().getStatusId() == Statuses.statusEnum.INACTIVE.getId()) {
					userDetails.setStatusId(Statuses.getInstanceof(Statuses.statusEnum.ACTIVE.getId()));
					ActivateButtonDao.activateCustomer(userDetails);
					activateButtonResponse.setStatusName("Customer Activated");
					activateButtonResponse.setStatusCode(200);
					
				} else {
					activateButtonResponse.setStatusCode(414);
					activateButtonResponse.setStatusName("User is already Active");
				}
			} else {
				activateButtonResponse.setStatusCode(414);
				activateButtonResponse.setStatusName("user id is incorrect");
			}
			
		} catch (Exception exception) {
			activateButtonResponse.setStatusCode(500);
			activateButtonResponse.setStatusName("there is an error" + exception);
		}
		return activateButtonResponse;
	}
}
