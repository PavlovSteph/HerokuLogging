package com.gcu.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductModel {
	
	//Declaring and Initializing

	private String id;
	
	@NotNull(message = "Picture of Potion is a required field")
	@Size(message="Picture of Potion is a required field")
	private String picURL;

	@NotNull(message = "Name of Potion is a required field")
	@Size(min=1, max=32,message="Name of Potion is a required field")
	private String name;
	
	@NotNull(message = "Effects of Potion is a required field")
	@Size(min=1, max=32,message="Effects of Potion is a required field")
	private String effects;

	@NotNull(message = "Price of Potion is a required field")
	@DecimalMin(value = "0.0", message = "Price of Potion is a required field")
	private double price;
	
	@NotNull(message = "Ingredients of Potion is a required field")
	@Size(min=1, max=32,message="Ingredients of Potion is a required field")
	private String ingredients;
	
	/**
	 * Default Constructor
	 */
	public ProductModel() {
		this.id = "";
		this.picURL = "";
		this.name = "";
		this.effects = "";
		this.price = 0;
		this.ingredients = "";
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
	public ProductModel(String id, String picURL, String name, String effects, double price, String ingredients){
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
