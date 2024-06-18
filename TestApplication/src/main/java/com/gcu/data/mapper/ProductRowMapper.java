package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.data.entity.ProductEntity;

/**
 * RowMapper implementation for mapping ProductEntity objects from a ResultSet.
 */
public class ProductRowMapper implements RowMapper<ProductEntity> {
	
	/**
	 * Constructs a new ProductRowMapper.
	 * This is the default constructor.
	 */
	public ProductRowMapper() {
	    // Default constructor implementation
	}

    /**
     * Maps a row in the ResultSet to a ProductEntity object.
     *
     * @param rs        the ResultSet containing the data to be mapped
     * @param rowNumber the number of the current row being mapped (starting from 0)
     * @return a ProductEntity object mapped from the current row in the ResultSet
     * @throws SQLException if a SQLException is encountered while accessing the ResultSet
     */
    @Override
    public ProductEntity mapRow(ResultSet rs, int rowNumber) throws SQLException {
        // Map the data from the ResultSet to a ProductEntity object and return it
        return new ProductEntity(
                rs.getLong("ID"),
                rs.getString("NAME"),
                rs.getString("DESCRIPTION"),
                rs.getFloat("PRICE"),
                rs.getInt("QUANTITY")
        );
    }
}
