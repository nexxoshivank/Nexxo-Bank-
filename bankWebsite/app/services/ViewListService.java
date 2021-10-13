package services;


import dto.ViewListResponse;
import models.Roles;
import models.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class ViewListService {
	
	public static List<ViewListResponse> renderViewList() {
		
		List<ViewListResponse> viewListResponseList = new ArrayList<ViewListResponse>();
		
		try {
			List<UserDetails> userDetailsList = UserDetails.find.query().where()
					.eq("role_id", Roles.roleTypeEnum.CUSTOMER.getRoleId()).findList();
			if (userDetailsList.size() == 0) {
				ViewListResponse viewListResponse = new ViewListResponse();
				viewListResponse.setStatusCode(412);
				viewListResponse.setStatusName("No list Found");
				viewListResponseList.add(viewListResponse);
				return viewListResponseList;
			}
			
			for (UserDetails userDetails : userDetailsList) {
				
				ViewListResponse viewListResponse = new ViewListResponse();
				viewListResponse.setUserId(userDetails.getUserId());
				viewListResponse.setCustomerName(userDetails.getFirstName());
				viewListResponse.setCustomerLastName(userDetails.getLastName());
				viewListResponse.setMobile(userDetails.getMobile());
				viewListResponse.setEmail(userDetails.getEmail());
				viewListResponse.setDob(userDetails.getDob().toString());
				viewListResponse.setAadhaarNumber(userDetails.getAadhaarNumber());
				viewListResponse.setPanNumber(userDetails.getPanNumber());
				viewListResponse.setAccountStatus(userDetails.getStatusId().getStatusName());
				viewListResponse.setStatusName("Customer List Shown");
				viewListResponse.setStatusCode(200);
				viewListResponseList.add(viewListResponse);
			}
		} catch (Exception exception) {
			ViewListResponse viewListResponse = new ViewListResponse();
			viewListResponse.setStatusCode(500);
			viewListResponse.setStatusName("Internal server error while showing list" + exception);
			viewListResponseList.add(viewListResponse);
			return viewListResponseList;
		}
		return viewListResponseList;
	}
}
