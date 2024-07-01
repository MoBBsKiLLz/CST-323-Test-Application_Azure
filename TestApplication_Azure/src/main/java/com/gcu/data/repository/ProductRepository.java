package com.gcu.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gcu.data.entity.ProductEntity;

/**
 * Repository interface for managing ProductEntity objects.
 * Extends CrudRepository to inherit basic CRUD operations.
 */
@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

}
