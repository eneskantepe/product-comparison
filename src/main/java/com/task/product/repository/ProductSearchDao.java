package com.task.product.repository;

import com.task.product.model.ProductDto;

import java.util.List;
/**
 * @author Enes Kantepe
 */
public interface ProductSearchDao {
    List<ProductDto> findProducts(String name, String category);
}
