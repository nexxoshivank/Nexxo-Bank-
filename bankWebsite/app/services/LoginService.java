package services;

import dto.LoginRequest;
import dto.LoginResponse;
import models.Statuses;
import models.UserDetails;
import models.UserPasswords;

import java.util.regex.Pattern;

public class LoginService {
	public static LoginResponse validateCredentials(LoginRequest loginRequest) {
		
		LoginResponse loginResponse = new LoginResponse();
			try {
				boolean b = Pattern.matches("[0-9]{3}",loginRequest.getUserId() );
				if (b) {
					UserDetails userDetails = UserDetails.find.byId( Integer.valueOf(loginRequest.getUserId()));
					
					if (userDetails == null) {
						System.out.println("does not exist");
						loginResponse.setStatusCode(404);
						loginResponse.setStatusName("User ID does not exists");
						return loginResponse;
						
					}
					UserPasswords userPasswords =
							UserPasswords.find.query().where()
									.eq("userId ", userDetails.getUserId())
									.eq("pass", loginRequest.getPass()).findOne();
					
					if (userPasswords == null) {
						loginResponse.setStatusCode(404);
						loginResponse.setStatusName("Incorrect password");
						return loginResponse;
					}
					
					
					if (userDetails.getStatusId().getStatusId().equals(Statuses.statusEnum.ACTIVE.getId())) {
						loginResponse.setRole(userDetails.getRoleId().getRoleStatus());
						loginResponse.setStatus(userDetails.getStatusId().getStatusName());
						loginResponse.setStatusCode(200);
						loginResponse.setStatusName("Login successful");
						return loginResponse;
					} else
						loginResponse.setStatusCode(414);
					loginResponse.setStatusName("User is Inactive");
					
				}
				else{
					loginResponse.setStatusName("enter correct User ID please ");
					
				}
			}
		
		catch (Exception exception) {
			loginResponse.setStatusCode(500);
			loginResponse.setStatusName("Some exception occurred" + exception);
			
			return loginResponse;
		}
		
		
		return loginResponse;
	}
}
