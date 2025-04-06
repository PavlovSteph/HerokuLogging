package com.gcu.business;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.ProductModel;
import com.gcu.model.ProductsList;

@RestController
@RequestMapping("/service")
public class ProductsRestService {
	
	// declare and initialize service class and logger
	private ProductsBusinessInterface service;
	private static final Log logger = LogFactory.getLog(ProductsRestService.class);
	
	/**
     * Setter for the ProductsBusinessInterface dependency.
     * 
     * @param service The ProductsBusinessInterface implementation.
     */
    @Autowired
    public void setService(ProductsBusinessInterface service) {
        this.service = service;
    }

    /**
     * Retrieves products data in JSON format.
     * 
     * @return A list of ProductModel objects serialized to JSON.
     */
    @GetMapping(path="/getjson", produces= {MediaType.APPLICATION_JSON_VALUE})
    public List<ProductModel> getOrderAsJson() {
    	 logger.info("Entering getOrderAsJson()");
    	 logger.info("Exiting getOrderAsJson()");
        return service.getProducts();
    }
    
    /**
     * Retrieves products data in XML format.
     * 
     * @return An ProductsList object containing the list of products serialized to XML.
     */
    @GetMapping(path="/getxml", produces= {MediaType.APPLICATION_XML_VALUE})
    public ProductsList getProductssAsXml() {
    	logger.info("Entering getProductssAsXml()");
        ProductsList list = new ProductsList();
        list.setProducts(service.getProducts());
        logger.info("Exiting getProductssAsXml()");
        return list;
    }
    
    /**
     * return a filtered list of the products
     * @param searchTerm
     * @return
     */
    @GetMapping(path="/search", produces= {MediaType.APPLICATION_JSON_VALUE})
    public List<ProductModel> searchProducts(@RequestParam String searchTerm) {
    	logger.info("Entering searchProducts()");
    	logger.info("Exiting searchProducts()");
        return service.searchProducts(searchTerm);
    }
}
