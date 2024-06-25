package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.data.ProductDataService;
import com.gcu.data.entity.ProductEntity;
import com.gcu.model.ProductModel;

/**
 * Service implementation for managing product-related operations.
 */
@Service
public class ProductService implements ProductServiceInterface {
    @Autowired
	private ProductDataService service;
    
    // SLF4J Logger
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    
    /**
     * Creates a new product.
     * @param name The name of the product.
     * @param description The description of the product.
     * @param price The price of the product.
     * @param quantity The quantity of the product.
     * @return The created ProductEntity object.
     */
    @Override
    public ProductEntity createProduct(String name, String description, float price, int quantity) {
        ProductEntity productEntity = new ProductEntity(name, description, price, quantity);
        if (service.create(productEntity)) {
            logger.info("Product created: " + productEntity.getName());
            return productEntity;
        }
        logger.error("Failed to create product.");
        return null;
    }
    
    /**
     * Retrieves all products.
     * @return List of ProductModel objects representing products.
     */
    @Override
    public List<ProductModel> getProducts() {
        // Get all the Entity Products
        List<ProductEntity> productsEntity = service.findAll();
        
        // Iterate over the Entity Products and create a list of Domain Products
        List<ProductModel> productsDomain = new ArrayList<ProductModel>();
        for(ProductEntity entity : productsEntity) {
            productsDomain.add(new ProductModel(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice(), entity.getQuantity()));
        }
        logger.info("Products retrieved.");
        return productsDomain;
    }
    
    /**
     * Retrieves a product by its ID.
     * @param id The ID of the product.
     * @return The ProductModel object representing the product.
     */
    @Override
    public ProductModel getProductById(Long id) {
        ProductEntity entity = service.findById(id);
        ProductModel product = new ProductModel(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice(), entity.getQuantity());
        logger.info("Product id=" + product.getId() + " found.");
        return product;
    }

    /**
     * Updates a product.
     * @param id The ID of the product to update.
     * @param updateProduct The updated ProductModel object.
     */
    @Override
    public void updateProduct(Long id, ProductModel updateProduct) {
        // Retrieve the existing product from the database
        ProductEntity existingProduct = service.findById(id);
        
        // Update the existing product
        existingProduct.setName(updateProduct.getName());
        existingProduct.setDescription(updateProduct.getDescription());
        existingProduct.setPrice(updateProduct.getPrice());
        existingProduct.setQuantity(updateProduct.getQuantity());
        
        // Save the product with updates
        service.update(existingProduct);
        logger.info("Product id=" + existingProduct.getId() + " has been updated.");
    }
    
    /**
     * Deletes a product by its ID.
     * @param id The ID of the product to delete.
     */
    @Override
    public void deleteProduct(Long id) 
    {
        // Retrieve the existing product from the database
        ProductEntity existingProduct = service.findById(id);
        
        //Delete the identified product
        service.delete(existingProduct);  
        
        logger.info("Product id=" + existingProduct.getId() + " was deleted.");
    }
    
    /**
     * A test method to print a message to the console.
     */
    @Override
    public void test() {
        System.out.println("Hello from the ProductService!");
    }

    /**
     * Initialization method to print a message to the console.
     */
    @Override
    public void init() {
        System.out.println("Hello from the ProductService!");
    }

    /**
     * Cleanup method to print a message to the console.
     */
    @Override
    public void destroy() {
        System.out.println("Hello from the ProductService!");
    }

}
