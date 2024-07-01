package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.business.ProductService;
import com.gcu.business.ProductServiceInterface;
import com.gcu.model.ProductModel;

import jakarta.validation.Valid;

/**
 * Controller class for managing product-related operations.
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductServiceInterface service;
    
    /**
     * Constructs a ProductController with a ProductService instance.
     * @param productService The ProductService instance.
     */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Displays the product form.
     * @param model The Model object.
     * @return The view name for the product form.
     */
    @GetMapping("/product")
    public String display(Model model)
    {
        model.addAttribute("title", "Product Form");
        model.addAttribute("productModel", new ProductModel());
        return "product";
    }
    
    /**
     * Creates a new product.
     * @param productModel The ProductModel object.
     * @param bindingResult The BindingResult object.
     * @param model The Model object.
     * @return The view name for the product form after successful product creation.
     */
    @PostMapping("/doCreateProduct")
    public String doCreateProduct(@Valid ProductModel productModel, BindingResult bindingResult, Model model)
    {
        // Check for validation errors
        if(bindingResult.hasErrors())
        {
            model.addAttribute("title", "Create Product");
            return "product";
        }
    
        // Add to database
        productService.createProduct(productModel.getName(), productModel.getDescription(), productModel.getPrice(), productModel.getQuantity());
        
        // Navigates user to the product page to create additional product
        return "redirect:/product/list";
    }
    
    /**
     * Displays the list of products.
     * @param model The Model object.
     * @return The view name for the product list.
     */
    @GetMapping("/product/list")
    public String getProductsList(Model model)
    {
        List<ProductModel> products = service.getProducts();
        model.addAttribute("title", "Products List");
        model.addAttribute("products", products);
        return "productlist";
    }
    
    /**
     * Displays the edit page for a product.
     * @param id The ID of the product.
     * @param model The Model object.
     * @return The view name for the edit product form.
     */
    @GetMapping("product/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model)
    {
        // Get the existing product based on the id
        ProductModel product = service.getProductById(id);
        
        // Add attributes to the model
        model.addAttribute("existingProduct", product);
        model.addAttribute("title", "Update Product");
        
        return "editproduct";
        
    }
    
    /**
     * Updates a product in the database.
     * @param id The ID of the product.
     * @param product The ProductModel object.
     * @return Redirects to the product list page to see the update.
     */
    @PostMapping("product/update/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute ProductModel product) 
    {
        // Update product in database
        service.updateProduct(id, product);
                
        // Navigates user to the product list page
        return "redirect:/product/list";
    }

    /**
     * Deletes a product from the database.
     * @param id The ID of the product.
     * @param product The ProductModel object.
     * @return Redirects back to the product list page to see the selected product contents deleted.
     */
    @PostMapping("product/delete/{id}")
    public String deleteProduct(@PathVariable Long id, @ModelAttribute ProductModel product)
    {
        // Delete product in database
        service.deleteProduct(id);
        
        // Navigates user to the product list page
        return "redirect:/product/list";
    }
}
