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

import java.util.regex.Pattern;


public class RegistrationService {
	
	public static RegistrationResponse save(RegistrationRequest registrationRequest) {
		
		RegistrationResponse registrationResponse = new RegistrationResponse();
		
		try {
			boolean fname = Pattern.matches("^[A-Za-z]{3,29}$", registrationRequest.getFirstName());
			if (!fname) {
				registrationResponse.setStatusName("please enter correct first name");
				return registrationResponse;
			}
			
			boolean lname = Pattern.matches("^[A-Za-z]{3,29}$", registrationRequest.getLastName());
			if (!lname) {
				registrationResponse.setStatusName("please enter correct last name");
				return registrationResponse;
			}
			boolean mobile = Pattern.matches("^[6-9]\\d{9}$", registrationRequest.getMobile());
			if (!mobile) {
				registrationResponse.setStatusName("please enter correct mobile number");
				return registrationResponse;
			}
			boolean email = Pattern.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", registrationRequest.getEmail());
			if (!email) {
				registrationResponse.setStatusName("please enter correct email");
				return registrationResponse;
			}
			
			boolean aadhaar = Pattern.matches("^[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}$", registrationRequest.getAadhaarNumber());
			if (!aadhaar) {
				registrationResponse.setStatusName("please enter correct aadhaar number");
				return registrationResponse;
			}
			
			boolean pan = Pattern.matches("[A-Z]{5}[0-9]{4}[A-Z]", registrationRequest.getPanNumber());
			if (!pan) {
				registrationResponse.setStatusName("please enter correct pan number");
				return registrationResponse;
			}
			
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
			
			
		} catch (DuplicateKeyException duplicateKeyException) {
			registrationResponse.setStatusCode(500);
			registrationResponse.setStatusName("Pan, Aadhaar or email already registered");
			return registrationResponse;
		} catch (Exception exception) {
			
			registrationResponse.setStatusCode(500);
			registrationResponse.setStatusName("error1" + exception);
			return registrationResponse;
		}
		
		return registrationResponse;
	}
	
}
