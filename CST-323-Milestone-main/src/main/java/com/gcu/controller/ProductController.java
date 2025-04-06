package com.gcu.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.gcu.business.ProductsBusinessService;
import com.gcu.data.entity.ProductEntity;
import com.gcu.model.ProductModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	/**
	 * The service used for CRUD
	 */
	private ProductsBusinessService service;
	
	private static final Log logger = LogFactory.getLog(ProductController.class);

	/**
	 * Sets the service
	 * @param service
	 */
	@Autowired
	public void setProductsService(ProductsBusinessService service) {
		this.service = service;
	}
	
	/**
	 * Method to handle the display of the Create A Product Page
	 * @param model
	 * @return The name of the Thymeleaf template
	 */
	@GetMapping("/")
	public String display(Model model)
	{
		logger.info("Displaying Create Product form");
		model.addAttribute("title", "Create a Potion");
        model.addAttribute("productModel", new ProductModel());
        
		return "product";
	}
	
	/**
	 * Handles POST requests for submitting product credentials and performs validation.
    * If validation fails, returns to the product form with error messages.
    * If credentials are invalid, displays an error message.
    * If product is successful, redirects to success banner.
    *
    * @param productModel    The model containing login credentials.
    * @param bindingResult The result of the validation.
    * @param model         The model to be used for rendering the view.
    * @return The name of the Thymeleaf template based on the outcome of the login attempts
	 */
	@PostMapping("/submit")
	public String product(@Valid @ModelAttribute("productModel") ProductEntity productModel, BindingResult bindingResult, Model model) {
		logger.info("Attempting to create product: " + productModel.getName());
       // Check for validation errors
       if (bindingResult.hasErrors()) {
    	// display out to logger
    	   logger.warn("Product creation failed validation for: " + productModel.getName());
           model.addAttribute("title", "Create a Potion!");
           return "product";
       }
       
       boolean createSuccess = service.createProduct(productModel);
		
		if (!createSuccess) {
			// display out to logger
			logger.error("Product creation failed - fields may be blank for: " + productModel.getName());
			// Perform login logic (set session, etc.)
			model.addAttribute("errorMessage", "All fields are blank");
			return "product";
		} else {
			// display out to logger
			logger.info("Product created successfully: " + productModel.getName());
			model.addAttribute("successMessage", true);
			// service.createProduct(productModel);
			return "product";
		}
	}

}
