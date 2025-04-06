package com.gcu.business;

import java.util.List;

import com.gcu.data.entity.ProductEntity;
import com.gcu.model.ProductModel;

public interface ProductsBusinessInterface{

	/**
	 * Method to create a product in SQL database
	 * @param productModel Specified Product Model
	 * @return true or false
	 */
	public boolean createProduct(ProductModel productModel);
	
	/**
	 * Method to delete a product in SQL database
	 * @param id Specified id
	 * @return true or false
	 */
	public boolean deleteProduct(String id);
	
	/**
	 * 
	 * @param productModel
	 * @return
	 */
	public boolean updateProduct(ProductEntity productEntity);
	
	/**
	 * Method to get a list of Products from SQL Database
	 * @return List of Products
	 */
	public List<ProductModel> getProducts();
	
	/**
	 * Method to find a product by an id
	 * @param productId Specified id for product
	 * @return Instance of ProductModel
	 */
	public ProductModel findProductById(String productId);
	
	/**
     * Method to search for products based on a search term.
     * @param searchTerm The search term to filter products.
     * @return A list of ProductModel objects that match the search term.
     */
    List<ProductModel> searchProducts(String searchTerm);
	
}
