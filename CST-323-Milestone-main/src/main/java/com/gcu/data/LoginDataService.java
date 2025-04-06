package com.gcu.data;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.ProductEntity;
import com.gcu.data.entity.UserEntity;

@Service
public class LoginDataService implements DataAccessInterface<UserEntity> {

	// instantiate logger 
	private static final Log logger = LogFactory.getLog(LoginDataService.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * CRUD: finder to return if user is in system with correct login
	 */
	public boolean findUser(String inputUsername, String inputPassword) {
		logger.info("Entering findUser()");
		try {
			Query query = new Query(Criteria.where("username").is(inputUsername).and("password").is(inputPassword));
			long count = mongoTemplate.count(query, UserEntity.class);
			logger.info("Exiting findUser()");
			return count > 0;
		} catch (Exception e) {
			logger.error("Exception in findUser(): " + e.getMessage(), e);
			return false;
		}
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
	public List<UserEntity> findProducts() {
		return null;
	}

	@Override
	public boolean createProduct(UserEntity t) {
		return true;
	}

	@Override
	public boolean createUser(UserEntity t) {
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
