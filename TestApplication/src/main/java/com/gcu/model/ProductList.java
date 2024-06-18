package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Represents a list of products.
 */
@RequestMapping(name = "/products")
public class ProductList {
    private List<ProductModel> products = new ArrayList<ProductModel>();
    
    /**
     * Constructs a new ProductList.
     * This is the default constructor.
     */
    public ProductList() {
        // Default constructor implementation
    }

    /**
     * Retrieves the list of products.
     * 
     * @return The list of products.
     */
    @GetMapping(name = "products/all")
    public List<ProductModel> getProducts() {
        return this.products;
    }

    /**
     * Sets the list of products.
     * 
     * @param products The list of products to set.
     */
    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }
}
