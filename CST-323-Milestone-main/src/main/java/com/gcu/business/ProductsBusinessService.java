package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.ProductDataService;
import com.gcu.data.entity.ProductEntity;
import com.gcu.model.ProductModel;

@Service
public class ProductsBusinessService implements ProductsBusinessInterface {

	/**
	 * Service for accessing the data
	 */
	@Autowired
	private ProductDataService service;
	// declare and initialize our logger
	private static final Log logger = LogFactory.getLog(ProductsBusinessService.class);

	/**
	 * Gets the products by using the data access service
	 * 
	 * @return List of products using ProductModel
	 */
	public List<ProductModel> getProducts() {
		logger.info("Entering getProducts()");
		// Get all the Entity products
		List<ProductEntity> productEntity = service.findProducts();

		// Iterate over the Entity products and create a list of Domain Products
		List<ProductModel> productsDomain = new ArrayList<ProductModel>();
		for (ProductEntity entity : productEntity) {
			productsDomain.add(new ProductModel(entity.getID(), entity.getPicURL(), entity.getName(),
					entity.getEffects(), entity.getPrice(), entity.getIngredients()));
		}

		// Return list of Domain Products
		logger.info("Exiting getProducts()");
		return productsDomain;
	}

	/**
	 * Create a product using the data access service
	 * 
	 * @param productEntity
	 * @return
	 */
	public boolean createProduct(ProductEntity productEntity) {
		logger.info("Entering createProduct()");
		// Making sure textboxes arent blank
		if (productEntity.getPicURL() == null || productEntity.getPicURL().isBlank() || productEntity.getName() == null
				|| productEntity.getName().isBlank() || productEntity.getEffects() == null
				|| productEntity.getEffects().isBlank() || productEntity.getPrice() == 0
				|| productEntity.getIngredients() == null || productEntity.getIngredients().isBlank()) {
			logger.warn("Exiting createProduct(), Failure to create product.");
			return false;
		} else {
			service.createProduct(productEntity);
			logger.info("Exiting createProduct(), Product created successfully.");
			return true;
		}

	}

	/**
	 * Update a product using the data access service
	 * 
	 * @param productEntity
	 * @return
	 */
	public boolean updateProduct(ProductEntity productEntity) {
		logger.info("Entering updateProduct()");
		// Making sure textboxes arent blank
		if (productEntity.getPicURL() == null || productEntity.getPicURL().isBlank() || productEntity.getName() == null
				|| productEntity.getName().isBlank() || productEntity.getEffects() == null
				|| productEntity.getEffects().isBlank() || productEntity.getPrice() == 0
				|| productEntity.getIngredients() == null || productEntity.getIngredients().isBlank()) {
			logger.warn("Exiting updateProduct(), Product failed to update.");
			return false;
		} else {
			service.updateProduct(productEntity);
			logger.info("Exiting updateProduct(), Product updated successfully.");
			return true;
		}

	}

	/**
	 * Method to delete to a product
	 */
	public boolean deleteProduct(String id) {
		logger.info("Entering deleteProduct()");
		service.deleteProduct(id);
		logger.info("Exiting deleteProduct(), Product deleted successfully.");
		return true;
	}

	/**
	 * Method to search for a product
	 * 
	 * @param searchTerm
	 * @return
	 */
	public List<ProductModel> searchProducts(String searchTerm) {
		logger.info("Entering searchProducts()");
		List<ProductEntity> productEntityList = service.searchProducts(searchTerm);

		List<ProductModel> productModelList = new ArrayList<>();
		for (ProductEntity entity : productEntityList) {
			productModelList.add(new ProductModel(entity.getID(), entity.getPicURL(), entity.getName(),
					entity.getEffects(), entity.getPrice(), entity.getIngredients()));
		}
		logger.info("Exiting searchProducts()");
		return productModelList;
	}

	/**
	 * Method to find the product id for each product
	 */
	public ProductModel findProductById(String productId) {
		logger.info("Entering findProductById()");
		ProductEntity p = service.getProductById(productId);
		ProductModel product = new ProductModel(p.getID(), p.getPicURL(), p.getName(), p.getEffects(), p.getPrice(),
				p.getIngredients());

		// ProductRowMapper is a class that maps a ResultSet row to a ProductModel
		// object
		logger.info("Exiting findProductById()");
		return product;
	}

	@Override
	public boolean createProduct(ProductModel productModel) {
		// TODO Auto-generated method stub
		return false;
	}
}
