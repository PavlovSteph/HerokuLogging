package com.gcu.business;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.LoginDataService;

@Service
public class LoginService {
	
	//Declaring and Initializing
	@Autowired
	private LoginDataService loginDataService;
	// Instantiating logger 
	private static final Log logger = LogFactory.getLog(LoginService.class);
	
	/**
	 * Checks if the provided username and password match any user's credentials.
     * 
     * @param inputUsername The username entered by the user.
     * @param inputPassword The password entered by the user.
     * @return If the username and password match a user's credentials, otherwise.
	 */
	public boolean isValidUser(String inputUsername, String inputPassword) {
		 logger.info("Entering isValidUser()");
		 logger.info("Exiting isValidUser()");
        return loginDataService.findUser(inputUsername, inputPassword);
    }

}
