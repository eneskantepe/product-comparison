package com.task.product.service;

import com.task.product.model.ProductDto;
import com.task.product.repository.ProductSearchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Enes Kantepe
 */
@Service
public class ProductSearchService {

    @Autowired
    private ProductSearchDao productSearchDao;

    public List<ProductDto> getProducts(String name, String category) {
        return productSearchDao.findProducts(name, category);
    }
}
