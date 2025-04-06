package com.gcu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegisterModel {

	//Declaring and Initializing
	
	@NotNull(message = "First name is a required field")
	@Size(min=1, max=32,message="First name is a required field")
    private String firstName;
	
	@NotNull(message = "Last name is a required field")
	@Size(min=1, max=32,message="Last name is a required field")
    private String lastName;
	
	@NotNull(message = "Email is a required field")
	@Size(min=1, max=32,message="Email is a required field")
    private String email;
	
	@NotNull(message = "Phone number is a required field")
	@Size(min=1, max=32,message="Phone number is a required field")
    private String phoneNumber;
	
	@NotNull(message = "Username is a required field")
	@Size(min=1, max=32,message="Username is a required field")
    private String username;
	
	@NotNull(message = "Password is a required field")
	@Size(min=1, max=32,message="Password is a required field")
    private String password;

	/**
	 * Default Constructor
	 */
	public RegisterModel() {
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.phoneNumber = "";
		this.username = "";
		this.password = "";
	}
	/**
	 * Parameterized Constructor 
	 * @param firstName Specified firstName
	 * @param lastName Specified lastName
	 * @param username Specified username
	 * @param email Specified email
	 * @param phoneNumber Specified phoneNUmber
	 * @param password Specified password
	 */
	public RegisterModel(String firstName, String lastName, String email, String phoneNumber, String username,
			String password) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
	}
	
	/**
	 *  Getter method for first name
	 * @return firstName
	 */
    public String getFirstName() {
        return firstName;
    }

    /**
     *  Setter method for first name
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * Getter method for lastName
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter method for lastName
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     *  Getter method for first name
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for first name
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     *  Getter method for first name
     * @return firstName
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *  Setter method for first name
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * Getter method for username
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
