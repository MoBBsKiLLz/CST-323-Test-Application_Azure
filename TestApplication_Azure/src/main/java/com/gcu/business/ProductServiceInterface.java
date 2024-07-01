package com.gcu.business;

import java.util.List;
import com.gcu.data.entity.ProductEntity;
import com.gcu.model.ProductModel;

/**
 * Interface for ProductService, defining business operations related to products.
 */
public interface ProductServiceInterface {
    /**
     * A test method to be implemented by concrete implementations.
     */
    public void test();
    
    /**
     * Retrieves all products.
     * @return List of ProductModel objects representing products.
     */
    public List<ProductModel> getProducts();
    
    /**
     * Creates a new product.
     * @param name The name of the product.
     * @param description The description of the product.
     * @param price The price of the product.
     * @param quantity The quantity of the product.
     * @return The created ProductEntity object.
     */
    public ProductEntity createProduct(String name, String description, float price, int quantity);
    
    /**
     * Retrieves a product by its ID.
     * @param id The ID of the product.
     * @return The ProductModel object representing the product.
     */
    public ProductModel getProductById(Long id);
    
    /**
     * Updates a product.
     * @param id The ID of the product to update.
     * @param updatedProduct The updated ProductModel object.
     */
    public void updateProduct(Long id, ProductModel updatedProduct);
    
    /**
     * Deletes a product by its ID.
     * @param id The ID of the product to delete.
     */
    public void deleteProduct(Long id);
    
    /**
     * Initialization method to be implemented by concrete implementations.
     */
    public void init();
    
    /**
     * Cleanup method to be implemented by concrete implementations.
     */
    public void destroy();
}
