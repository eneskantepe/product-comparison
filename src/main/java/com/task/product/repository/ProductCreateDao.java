package com.task.product.repository;

import com.task.product.model.ProductDto;

import java.util.List;
/**
 * @author Enes Kantepe
 */
public interface ProductCreateDao {
    void create(String vendor, List<ProductDto> productDtos);
}
