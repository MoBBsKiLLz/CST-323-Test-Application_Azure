package com.gcu.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Represents a product model.
 */
public class ProductModel {
    private Long id;

    @NotNull(message = "Name is a required field")
    @Size(min = 1, max = 32, message = "Name must be between 1 and 32 characters")
    private String name;

    @NotNull(message = "Description is a required field")
    @Size(min = 1, max = 32, message = "Description must be between 1 and 32 characters")
    private String description;

    @NotNull(message = "Price is a required field")
    @DecimalMin(value = "0.1", inclusive = true, message = "Price must be greater than or equal to 0.1")
    private float price;

    @NotNull(message = "Quantity is a required field")
    @Min(value = 1, message = "Quantity must be greater than or equal to 1")
    private int quantity;
    
    /**
     * Constructs a new ProductModel.
     */
    public ProductModel() {
        super();
    }

    /**
     * Constructs a new ProductModel with the specified attributes.
     * 
     * @param id          The ID of the product.
     * @param name        The name of the product.
     * @param description The description of the product.
     * @param price       The price of the product.
     * @param quantity    The quantity of the product.
     */
    public ProductModel(Long id, String name, String description, float price, int quantity) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Retrieves the ID of the product.
     * 
     * @return The ID of the product.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the product.
     * 
     * @param id The ID of the product to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the product.
     * 
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     * 
     * @param name The name of the product to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the description of the product.
     * 
     * @return The description of the product.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the product.
     * 
     * @param description The description of the product to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the price of the product.
     * 
     * @return The price of the product.
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     * 
     * @param price The price of the product to set.
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Retrieves the quantity of the product.
     * 
     * @return The quantity of the product.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product.
     * 
     * @param quantity The quantity of the product to set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
