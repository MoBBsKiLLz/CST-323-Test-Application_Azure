package com.gcu.data;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.ProductEntity;
import com.gcu.data.repository.ProductRepository;

/**
 * Service class for managing product data access operations.
 */
@Service
public class ProductDataService implements DataAccessInterface<ProductEntity> {
	@Autowired
	private ProductRepository productRepository;

    /**
     * Retrieves all products.
     * @return A list of all products.
     */
    @Override
    public List<ProductEntity> findAll() {
        List<ProductEntity> products = new ArrayList<ProductEntity>();
        
        try {
            // Get all product entities
            Iterable<ProductEntity> productsIterable = productRepository.findAll();
            
            // Convert to a List and return the List
            products = new ArrayList<ProductEntity>();
            productsIterable.forEach(products::add);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        // Return the List
        return products;
    }

    /**
     * Retrieves a product by its ID.
     * @param id The ID of the product to retrieve.
     * @return The product with the specified ID.
     * @throws NoSuchElementException If no product exists with the given ID.
     */
    @Override
    public ProductEntity findById(Long id) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElseThrow(() -> new NoSuchElementException("Product not found with id: " + id));
    }

    /**
     * Creates a new product.
     * @param product The product to create.
     * @return True if the operation was successful, false otherwise.
     */
    @Override
    public boolean create(ProductEntity product) {
        try {
            this.productRepository.save(product);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Updates an existing product.
     * @param product The product to update.
     * @return True if the operation was successful, false otherwise.
     */
    @Override
    public boolean update(ProductEntity product) {
        try {
            this.productRepository.save(product);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Deletes an existing product.
     * @param product The product to delete.
     * @return True if the operation was successful, false otherwise.
     */
    @Override
    public boolean delete(ProductEntity product) {
        try {
            this.productRepository.delete(product);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
