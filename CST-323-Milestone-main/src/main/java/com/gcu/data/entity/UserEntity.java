package com.gcu.data.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Model class representing user information.
 * This class manages user data, including retrieval of users, addition of new users,
 * and validation of user credentials.
 */
@Document(collection="Users")
public class UserEntity {
	
	//Declare and Initalize
	
	@Id
	String id;
	
	@Indexed(unique=true)
	private String username;
	
	@Indexed(unique=true)
	private String password;
	
	private String lastName;
	
	private String firstName;
	
	private String email; 
	
	private String phoneNumber;
	
	

		/**
		 * Constructor for creating a UserModel instance.
		 *
		 * @param username The username for the user.
		 * @param password The password for the user.
		 */
	    public UserEntity(String username, String password, String lastName, String firstName, String email, String phoneNumber) {
	        this.username = username;
	        this.password = password;
	        this.lastName = lastName;
	        this.firstName = firstName;
	        this.email = email;
	        this.phoneNumber = phoneNumber;
	    }

	    /**
	     * Getter method for retrieving the username.
	     * @return username
	     */
	    public String getUsername() {
	        return username;
	    }

	    /**
	     * Getter method for retrieving the password.
	     * @return password
	     */
	    public String getPassword() {
	        return password;
	    }
	    
	 // Hard-coded list of users for testing
	    private static List<UserEntity> users = new ArrayList<>();

	    /**
	     *  Getter method for retrieving the list of users.
	     * @return users
	     */
	    public static List<UserEntity> getUsers() {
	        return users;
	    }

	    /**
	     * Method for adding a new user to the list.
     * @param username The username for the new user.
     * @param password The password for the new user.
	     */
	    public static void addUser(String username, String password, String lastName, String firstName, String email, String phoneNumber) {
	        users.add(new UserEntity( username,password,lastName,firstName,email,phoneNumber));
	    }

	    /**
	     * Method for validating user credentials.
     * @param inputUsername The username input by the user for validation.
     * @param inputPassword The password input by the user for validation.
     * @return True if the provided credentials match any user in the list, otherwise false.
	     */
	    public static boolean isValidUser(String inputUsername, String inputPassword) {
	        for (UserEntity user : users) {
	            if (user.getUsername().equals(inputUsername) && user.getPassword().equals(inputPassword)) {
	                return true;
	            }
	        }
	        return false;
	    }

		public String getFirstName() {
			// TODO Auto-generated method stub
			return firstName;
		}

		public String getEmail() {
			// TODO Auto-generated method stub
			return email;
		}

		public String getLastName() {
			// TODO Auto-generated method stub
			return lastName;
		}

		public String getPhoneNumber() {
			// TODO Auto-generated method stub
			return phoneNumber;
		}
}
