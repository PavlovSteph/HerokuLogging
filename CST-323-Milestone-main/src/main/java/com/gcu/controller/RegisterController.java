package com.gcu.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.RegisterService;
import com.gcu.data.entity.UserEntity;
import com.gcu.model.*;

import jakarta.validation.Valid;

/**
 * Controller class for handling registration-related requests.
 * This controller manages the display of the registration form.
 */
@Controller
@RequestMapping("/potents")
public class RegisterController {
	
	//Declaring and Initializing
	private RegisterService service;
	
	// instantiate logger 
    private static final Log logger = LogFactory.getLog(RegisterController.class);

	
	@Autowired
	public void setRegisterService(RegisterService service) {
		this.service = service;
	}
	
	/**
	 * Handles GET requests for the registration page ("/register") and prepares the model for displaying the registration form.
     *
     * @param model The model to be used for rendering the view.
     * @return The name of the Thymeleaf template for the registration form (in this case, "register").
	 */
	@GetMapping("/register")
	public String display(Model model)
	{
		logger.info("Displaying Registration form");
		model.addAttribute("title", "Register Form");
        model.addAttribute("registerModel", new RegisterModel());
        
		return "register";
	}
	
	/**
	 * Handles POST requests for submitting register credentials and performs validation.
    * If validation fails, returns to the register form with error messages.
    * If credentials are invalid, displays an error message.
    * If register is successful, redirects to the home page ("/").
    *
    * @param registerModel    The model containing register credentials.
    * @param bindingResult The result of the validation.
    * @param model         The model to be used for rendering the view.
    * @return The name of the Thymeleaf template based on the outcome of the login attempts
	 */
	@PostMapping("/submit")
   public String register(@Valid UserEntity userEntity, BindingResult bindingResult, Model model) {
		logger.info("Attempting registration for: " + userEntity.getUsername());
       // Check for validation errors
       if (bindingResult.hasErrors()) {
    	   // display out to logger
    	   logger.warn("Registration validation failed for: " + userEntity.getUsername());
           model.addAttribute("title", "Register Form");
           return "register";
       }
       
       
       boolean registerSuccess = service.registerUser(userEntity);
       
       //check to see if the register was successful or not
       if (!registerSuccess) {
    	   // display error out to logger
    	   logger.error("Registration failed for: " + userEntity.getUsername() + " - Possibly due to empty fields");
           // Perform register logic (set session, etc.)
    	   model.addAttribute("errorMessage", "All fields are blank");
    	   return "register";
       } 
       else {
    	   // display with logger
    	   logger.info("User registered successfully: " + userEntity.getUsername());
    	   return "redirect:/login/";
       }
	}

}
