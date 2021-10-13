package services;

import dto.ProfileDetailsRequest;
import dto.ProfileDetailsResponse;
import models.UserDetails;

public class ProfileDetailsService {
	public static ProfileDetailsResponse renderProfileDetails(ProfileDetailsRequest profileDetailsRequest) {
		
		ProfileDetailsResponse profileDetailsResponse = new ProfileDetailsResponse();
		
		try {
			UserDetails userDetails = UserDetails.find.byId(profileDetailsRequest.getUserId());
			profileDetailsResponse.setFirstName(userDetails.getFirstName());
			profileDetailsResponse.setLastName(userDetails.getLastName());
			profileDetailsResponse.setAadhaarNumber(userDetails.getAadhaarNumber());
			profileDetailsResponse.setDob(userDetails.getDob().toString());
			profileDetailsResponse.setEmail(userDetails.getEmail());
			profileDetailsResponse.setUserId(userDetails.getUserId());
			profileDetailsResponse.setMobile(userDetails.getMobile());
			profileDetailsResponse.setPanNumber(userDetails.getPanNumber());
			
			profileDetailsResponse.setStatusCode(200);
			profileDetailsResponse.setStatusName("Profile Shown");
			
		} catch (Exception exception) {
			
			profileDetailsResponse.setStatusCode(500);
			profileDetailsResponse.setStatusName("Some error occurred");
			
			return profileDetailsResponse;
			
		}
		return profileDetailsResponse;
	}
}
