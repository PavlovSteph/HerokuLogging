package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="products")
public class ProductsList {

	//Declaring and Initializing
	private List<ProductModel> products = new ArrayList<ProductModel>();

	/**
     * Gets the list of products
     * 
     * @return The list of products
     */
    @XmlElement(name="product")
    public List<ProductModel> getProducts() {
        return this.products;
    }
    
    /**
     * Sets the list of orders.
     * 
     * @param products The list of products to set.
     */
    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }
}
