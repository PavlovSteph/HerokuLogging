package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Products")
public class ProductEntity {

	//Declaring and Initializing
	@Id
	String id;
	
	@Indexed(unique=true)
	String picURL;

	@Indexed(unique=true)
	String name;
	
	String effects;

	double price;
	
	String ingredients;
	
	/**
	 * Default Constructor
	 */
	public ProductEntity() {
		
	}
	
	/**
	 * Non-default Constructor
	 * @param ID Specified ID
	 * @param picURL Specified picURL
	 * @param name Specified name
	 * @param effects Specified effects
	 * @param price Specified price
	 * @param ingredients Specified ingredients
	 */
	public ProductEntity(String id, String picURL, String name, String effects, double price, String ingredients){
		this.id = id;
		this.picURL = picURL;
		this.name = name;
		this.effects = effects;
		this.price = price;
		this.ingredients = ingredients;
	}
	
	/**
	 * Getter for ID
	 * @return ID
	 */
	public String getID() {
		return id;
	}

	/**
	 * Setter for ID
	 * @param iD
	 */
	public void setID(String ID) {
		id = ID;
	}
	
	/**
	 * Getter for picURL
	 * @return picURL
	 */
	public String getPicURL() {
		return picURL;
	}

	/**
	 * Setter for picURL
	 * @param picURL
	 */
	public void setPicURL(String picURL) {
		this.picURL = picURL;
	}
	
	/**
	 * Getter for name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter for name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter for effects
	 * @return effects
	 */
	public String getEffects() {
		return effects;
	}
	
	/**
	 * Setter for effects
	 * @param effects
	 */
	public void setEffects(String effects) {
		this.effects = effects;
	}
	
	/**
	 * Getter for price
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Setter for price
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Getter for ingredients
	 * @return ingredients
	 */
	public String getIngredients() {
		return ingredients;
	}
	
	/**
	 * Setter for ingredients
	 * @param ingredients
	 */
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
}
