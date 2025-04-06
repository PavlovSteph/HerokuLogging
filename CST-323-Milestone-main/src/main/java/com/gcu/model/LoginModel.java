package com.gcu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Model class representing login credentials.
 * This class is used to capture and validate user login information.
 */
public class LoginModel {
	
	//Declaring and Initializing
	@NotNull(message = "Username is a required field")
	@Size(min=1, max=32,message="Username is a required field")
    private String username;
	
	@NotNull(message = "Password is a required field")
	@Size(min=1, max=32,message="Password is a required field")
    private String password;

	/**
	 * Default Constructor
	 */
	public LoginModel() {
		this.username = "";
		this.password = "";
	}
	
	/**
	 *  Non-default constructor
	 * @param username Specified username
	 * @param password Specified password
	 */
    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }
    

	/**
	 *  Getter method for username
	 * @return username
	 */
    public String getUsername() {
        return username;
    }

    /**
     *  Setter method for username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *  Getter method for password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     *  Setter method for password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
