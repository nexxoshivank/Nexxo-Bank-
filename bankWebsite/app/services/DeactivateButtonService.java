package services;

import dao.DeactivateButtonDao;
import dto.DeactivateButtonRequest;
import dto.DeactivateButtonResponse;
import models.Roles;
import models.Statuses;
import models.UserDetails;

public class DeactivateButtonService {
	
	public static DeactivateButtonResponse deactivateCustomer(DeactivateButtonRequest deactivateButtonRequest) {
		
		DeactivateButtonResponse deactivateButtonResponse = new DeactivateButtonResponse();
		
		try {
			
			UserDetails userDetails = UserDetails.find.query().where()
					.eq("userId",deactivateButtonRequest.getUserId())
					.eq("roleId",Roles.getInstance(Roles.roleTypeEnum.CUSTOMER.getRoleId())).findOne();
			
			if (userDetails == null){
				deactivateButtonResponse.setStatusCode(414);
				deactivateButtonResponse.setStatusName("Enter Correct Customer Id");
				return deactivateButtonResponse;
			}
			
			if (userDetails.getStatusId().getStatusId() == Statuses.statusEnum.INACTIVE.getId()) {
				deactivateButtonResponse.setStatusCode(414);
				deactivateButtonResponse.setStatusName("user is already inactive");
				return deactivateButtonResponse;
			}
			
			Statuses statuses = Statuses.find.byId(Statuses.statusEnum.INACTIVE.getId());
			userDetails.setStatusId(statuses);
			deactivateButtonResponse.setStatusCode(200);
			deactivateButtonResponse.setStatusName("User Successfully deactivated");
			DeactivateButtonDao.deactivateCustomer(userDetails);
		} catch (Exception exception) {
			
			deactivateButtonResponse.setStatusCode(500);
			deactivateButtonResponse.setStatusName("Please enter correct user ID");
			return deactivateButtonResponse;
		}
		
		return deactivateButtonResponse;
	}
}
