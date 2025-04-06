package com.gcu.data;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.gcu.data.entity.ProductEntity;
import com.gcu.data.entity.UserEntity;

@Service
public class RegisterDataService implements DataAccessInterface<UserEntity> {

	// Declaring and Initializing
	private final MongoTemplate mongoTemplate;
	
	// instantiate logger 
	private static final Log logger = LogFactory.getLog(RegisterDataService.class);

	// Constructor and initializing mongoTemplate
	public RegisterDataService(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	// method to create a new user in the database
	@Override
	public boolean createUser(UserEntity user) {
		logger.info("Entering createUser()");
		try {
			mongoTemplate.save(user);
			logger.info("Exiting createUser()");
			return true;
		} catch (Exception e) {
			logger.error("Exception in createUser(): " + e.getMessage(), e);
			return false;
		}
	}

	@Override
	public List<UserEntity> findProducts() {
		return null;
	}

	@Override
	public boolean createProduct(UserEntity t) {
		return true;
	}

	@Override
	public boolean findUser() {
		return true;
	}

	@Override
	public boolean addUser(UserEntity t) {
		return true;
	}

	@Override
	public ProductEntity findProductById(int productId) {
		return null;
	}

	@Override
	public boolean deleteProduct(int id) {
		return false;
	}

	@Override
	public UserEntity findByUsername(String username) {
		return null;
	}
}
