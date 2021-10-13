package services;

import dao.PasswordDao;
import dao.UserDao;
import dto.RegistrationRequest;
import dto.RegistrationResponse;
import io.ebean.DuplicateKeyException;
import models.Roles;
import models.Statuses;
import models.UserDetails;
import models.UserPasswords;
import org.joda.time.DateTime;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegistrationService {
	
	public static RegistrationResponse save(RegistrationRequest registrationRequest) {
		
		RegistrationResponse registrationResponse = new RegistrationResponse();
		
		try {
			System.out.println(registrationRequest.getAadhaarNumber());
			boolean aadhar = Pattern.matches("[0-9]{12}",registrationRequest.getAadhaarNumber());
			///boolean email  = Pattern.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",registrationRequest.getEmail());
			boolean pan = Pattern.matches("[a-zA-Z0-9]{8}",registrationRequest.getPanNumber());
			
			if (aadhar  && pan) {
				
				UserDetails userDetails = new UserDetails();
				
				userDetails.setFirstName(registrationRequest.getFirstName());
				userDetails.setLastName(registrationRequest.getLastName());
				userDetails.setAadhaarNumber(registrationRequest.getAadhaarNumber());
				userDetails.setPanNumber(registrationRequest.getPanNumber());
				userDetails.setMobile(registrationRequest.getMobile());
				userDetails.setEmail(registrationRequest.getEmail());
				userDetails.setCreatedOn(new DateTime());
				userDetails.setDob(registrationRequest.getDob());
				
				userDetails.setRoleId(Roles.getInstance(Roles.roleTypeEnum.CUSTOMER.getRoleId()));
				userDetails.setStatusId(Statuses.getInstanceof(Statuses.statusEnum.ACTIVE.getId()));
				
				
				UserPasswords userPasswords = new UserPasswords();
				userPasswords.setDateTime(new DateTime());
				userPasswords.setUserId(userDetails);
				userPasswords.setPass(registrationRequest.getPassword());
				
				
				UserDao.saveUserDetails(userDetails);
				PasswordDao.saveUserPasswords(userPasswords);
				registrationResponse.setStatusCode(200);
				registrationResponse.setStatusName("User Registered");
				
			}
			else {
				registrationResponse.setStatusName("enter correct format of each field");
			}
			
			
		}
		catch (DuplicateKeyException duplicateKeyException){
			registrationResponse.setStatusCode(500);
			registrationResponse.setStatusName("Pan, Aadhaar or email already registered");
			return registrationResponse;
		}
		
		catch (Exception exception) {
			
			registrationResponse.setStatusCode(500);
			registrationResponse.setStatusName("error1");
			return registrationResponse;
		}
		
		return registrationResponse;
	}
	
}
