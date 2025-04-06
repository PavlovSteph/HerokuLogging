package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.ProductEntity;
import com.gcu.data.repository.ProductsRepository;

@Service
public class ProductDataService implements DataAccessInterface<ProductEntity> {

	// Declare and Initializing
	@Autowired
	private ProductsRepository productsRepository;
	private MongoTemplate mongoTemplate;
	private static final Log logger = LogFactory.getLog(ProductDataService.class);

	/**
	 * Non-Default constructor for constructor injection
	 * 
	 * @param ordersRespository Specified for ordersRepository
	 */
	public ProductDataService(ProductsRepository productsRepository, MongoTemplate mongoTemplate) {
		this.productsRepository = productsRepository;
		this.mongoTemplate = mongoTemplate;
	}

	/**
	 * CRUD: finder to return all products
	 */
	public List<ProductEntity> findProducts() {
		logger.info("Entering findProducts()");
		List<ProductEntity> products = new ArrayList<>();
		try {
			Iterable<ProductEntity> productsIterable = productsRepository.findAll();
			productsIterable.forEach(products::add);
		} catch (Exception e) {
			logger.error("Exception in findProducts(): " + e.getMessage(), e);
		}
		logger.info("Exiting findProducts()");
		return products;
	}

	/**
	 * CRUD: create a product
	 */
	public boolean createProduct(ProductEntity product) {
		logger.info("Entering createProduct()");
		try {
			this.productsRepository.save(product);
			logger.info("Exiting createProduct()");
		} catch (Exception e) {
			logger.error("Exception in createProduct(): " + e.getMessage(), e);
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * CRUD: Updating a product
	 */
	public boolean updateProduct(ProductEntity productEntity) {// read in the productId of the product the user selected
		logger.info("Entering updateProduct()");
		try {
			productsRepository.save(productEntity);
			logger.info("Exiting updateProduct()");
			return true;
		} catch (Exception e) {
			logger.error("Exception in updateProduct(): " + e.getMessage(), e);
			return false;
		}
	}

	/**
	 * CRUD: delete a product
	 */
	public boolean deleteProduct(String id) {
		logger.info("Entering deleteProduct()");
		try {
			productsRepository.deleteById(id);
			logger.info("Exiting deleteProduct()");
			return true;
		} catch (Exception e) {
			logger.error("Exception in deleteProduct(): " + e.getMessage(), e);
			return false;
		}
	}

	/**
	 * Search for a product
	 * 
	 * @param searchTerm
	 * @return
	 */
	public List<ProductEntity> searchProducts(String searchTerm) {
		logger.info("Entering searchProducts()");
		// search for products by name
		logger.info("Exiting searchProducts()");
		return productsRepository.findByNameContainingIgnoreCase(searchTerm);
		
	}

	@Override
	public boolean createUser(ProductEntity t) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean findUser() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean addUser(ProductEntity t) {
		// TODO Auto-generated method stub
		return true;
	}

	public ProductEntity getProductById(String id) {
		logger.info("Entering getProductById()");
		// TODO Auto-generated method stub
//		String query = "SELECT * FROM products WHERE id = ?";
//		ProductEntity product = jdbcTemplateObject.queryForObject(query, new Object[] { productId },
//				new ProductRowMapper());
		// ProductRowMapper is a class that maps a ResultSet row to a ProductModel
		// object
		logger.info("Exiting getProductById()");
		return productsRepository.getProductById(id);
	}

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProductEntity findProductById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductEntity findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
