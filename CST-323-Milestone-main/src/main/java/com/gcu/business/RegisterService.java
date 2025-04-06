package com.gcu.business;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.RegisterDataService;
import com.gcu.data.entity.UserEntity;

@Service
public class RegisterService {

	// Declaring and Initializing service class and logger
	@Autowired
	private RegisterDataService registerDataService;
	private static final Log logger = LogFactory.getLog(RegisterService.class);

	/**
	 * Registers a new user based on the provided registration information.
	 * 
	 * @param registrationModel The registration model containing user information.
	 * @return If the registration is successful, if any required field is null or
	 *         blank.
	 */
	public boolean registerUser(UserEntity userEntity) {
		logger.info("Entering registerUser()");
		// Check for null values or blank text fields
		if (userEntity.getFirstName().isBlank() || userEntity.getLastName().isBlank() || userEntity.getEmail().isBlank()
				|| userEntity.getPhoneNumber().isBlank() || userEntity.getUsername().isBlank()
				|| userEntity.getPassword().isBlank()) {
			// Return false if any field is null or blank
			logger.warn("Exiting registerUser(), User not registered.");
			return false;
		}
		boolean result = registerDataService.createUser(userEntity);
		logger.info("Exiting registerUser() with result: " + result);
		return registerDataService.createUser(userEntity);
	}
}
