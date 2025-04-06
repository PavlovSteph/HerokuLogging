package com.gcu.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.business.LoginService;
import com.gcu.model.*;

import jakarta.validation.Valid;

/**
 * Controller class for handling login-related requests.
 * This controller manages the display of the login form and the submission of login credentials.
 */
@Controller
public class LoginController {
	
	//Declare and Initialize
	private LoginService service;
	
	// instantiate logger
    private static final Log logger = LogFactory.getLog(LoginController.class);
	
	@Autowired
	public void setLoginService(LoginService service) {
		this.service = service;
	}
	
	
	
	/**
	 * Handles GET requests for the login page ("/") and prepares the model for displaying the login form.
	 * @param model The model to be used for rendering the view.
     * @return The name of the Thymeleaf template for the login form (in this case, "login").
	 */
	@GetMapping("/login")
	public String display(Model model)
	{
		model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        
		return "login";
	}
	
	/**
	 * Handles POST requests for submitting login credentials and performs validation.
     * If validation fails, returns to the login form with error messages.
     * If credentials are invalid, displays an error message.
     * If login is successful, redirects to the home page ("/").
     *
     * @param loginModel    The model containing login credentials.
     * @param bindingResult The result of the validation.
     * @param model         The model to be used for rendering the view.
     * @return The name of the Thymeleaf template based on the outcome of the login attempts
	 */
	@PostMapping("/submit")
    public String login(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
		String username = loginModel.getUsername();
        // Check for validation errors
        if (bindingResult.hasErrors()) {
        	logger.info("Login validation failed for user: " + username);
            model.addAttribute("title", "Login Form");
            return "login";
        }

        if (service.isValidUser(loginModel.getUsername(), loginModel.getPassword())) {
            // Perform login logic (set session, etc.)
            // Redirect to the next page after successful login
        	logger.info("User logged in succesfully: " + username);
            return "redirect:/shop";
        } else {
        	 logger.warn("Login failed for user: " + username + " - Invalid credentials");
        	model.addAttribute("errorMessage", "Your username cannot be found or your password is incorrect");
            return "login";
        }
	}
}
