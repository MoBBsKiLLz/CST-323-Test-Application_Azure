package com.gcu.data;

import java.util.List;

/**
 * Interface for generic data access operations.
 * @param <T> The type of data to be accessed.
 */
public interface DataAccessInterface<T> {
    /**
     * Retrieves all instances of the specified type.
     * @return A list of all instances.
     */
    public List<T> findAll();
    
    /**
     * Retrieves an instance by its ID.
     * @param id The ID of the instance to retrieve.
     * @return The instance with the specified ID, or null if not found.
     */
    public T findById(Long id);
    
    /**
     * Creates a new instance.
     * @param t The instance to create.
     * @return True if the operation was successful, false otherwise.
     */
    public boolean create(T t);
    
    /**
     * Updates an existing instance.
     * @param t The instance to update.
     * @return True if the operation was successful, false otherwise.
     */
    public boolean update(T t);
    
    /**
     * Deletes an existing instance.
     * @param t The instance to delete.
     * @return True if the operation was successful, false otherwise.
     */
    public boolean delete(T t);
}
