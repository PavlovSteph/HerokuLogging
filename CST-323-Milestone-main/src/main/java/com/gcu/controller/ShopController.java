package com.gcu.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.business.ProductsBusinessInterface;
import com.gcu.data.entity.ProductEntity;
import com.gcu.model.ProductModel;

/**
 * Controller class for handling requests related to the home page.
 * This controller maps the root ("/") URL to the showIndexPage() method,
 * which returns the name of the Thymeleaf template to be rendered as the home page.
 */
@Controller
@RequestMapping("/shop")
public class ShopController {
	
	//Declaring and Initializing
	@Autowired
	private ProductsBusinessInterface service;
	
	// instantiate the logger
	private static final Log logger = LogFactory.getLog(ShopController.class);
    
	
	/**
	 * Handles GET requests for the root ("/") URL and returns the name of the Thymeleaf template
     * to be rendered as the home page.
	 * @return The name of the Thymeleaf template for the home page (in this case, "index").
	 */
    @GetMapping("/display")
    public String showIndexPage(Model model) {
    	logger.info("Showing shop main page");
    	
        List<ProductModel> products = service.getProducts();
        model.addAttribute("products", products);
        model.addAttribute("updateClicked", false);
    
        return "shop";
    }
    
    /**
     * Handles the mapping for our search function
     * @param query
     * @param model
     * @return
     */
    @GetMapping("/search")
    public String searchProducts(@RequestParam("query") String query, Model model) {
    	logger.info("Searching for products with query: " + query);
    	
        // Get search results based on query
        List<ProductModel> products = service.searchProducts(query);
        model.addAttribute("products", products);
        return "shop :: productList";  // Return only the section containing the product list
    }

    /**
     * For updating the products 
     * @return index.html 
     */
    @PostMapping("/update")
	public String updateButton(@RequestParam("productId") String productId, Model model)
    {
    	logger.info("Update button clicked for product ID: " + productId);
    	
    	// Retrieve the product by its ID
        ProductModel products = service.findProductById(productId);
        
        model.addAttribute("products", products);
        model.addAttribute("updateClicked", true);
         
    	return "shop";
	}
    
    /**
     * Method for submitting the info to the database for updating a product
     * @param updateClicked Specified updateClicked
     * @param model Specified Model
     * @return home page
     */
    @PostMapping("/submit")
    public String submitUpdateProduct(@RequestParam("productId") String productId, @ModelAttribute ProductEntity updatedProduct) {
    	logger.info("Submitting update for product ID: " + productId);
    	
    	updatedProduct.setID(productId);
    	
    	// Retrieve the product by its ID
        service.updateProduct(updatedProduct);
        
        logger.info("Product updated successfully for ID: " + productId);
	    
	    return "redirect:/shop/display";
	}
    
    /**
     * Method to delete a product with specified productid
     * @param productId Specified productId
     * @param model Specified model
     * @return home page
     */
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("productId") String productId, Model model) {
    	logger.warn("Deleting product with ID: " + productId);
    	
    	service.deleteProduct(productId);
        List<ProductModel> products = service.getProducts();
        
        model.addAttribute("products", products);
        model.addAttribute("updateClicked", false);
    
        logger.info("Product " + productId + " deleted and shop page refreshed.");
        
        return "shop";
    }
}
