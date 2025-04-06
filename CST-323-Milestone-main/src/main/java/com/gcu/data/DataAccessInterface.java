package com.gcu.data;

import java.util.List;

import com.gcu.data.entity.ProductEntity;

public interface DataAccessInterface <T>{

	/**
	 * Method to find all product in SQL Database
	 * @return List of Products
	 */
	public List<T> findProducts();
	
	/**
	 * Method to be able to create a product
	 * @param t Specified for t
	 * @return true or false
	 */
	public boolean createProduct(T t);
	
	/**
	 * Method to be able to delete a product
	 * @param id Specified id product
	 * @return true or false
	 */
	public boolean deleteProduct(int id);
	
	/**
     * Method to create a new user entity
     */
    public boolean createUser(T t);
    
    /**
	 * Method to find the user's login info in SQL Database
	 * @return true or false if user exists in database
	 */
	public boolean findUser();
	
	/**
	 * Method to add a user to the database
	 * @param t Specified for t
	 * @return true or false
	 */
	public boolean addUser(T t);

	/**
	 * Method to find product by id using ProductEntity
	 * @param productId Specified productId
	 * @return Instance of ProductEntity
	 */
	public ProductEntity findProductById(int productId);
	
	public T findByUsername(String username);
}
