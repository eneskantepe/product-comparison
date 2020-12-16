package com.task.product.service;

import com.task.product.model.ProductDto;
import com.task.product.repository.ProductCreateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Enes Kantepe
 */
@Service
public class ProductCreateService {

    @Autowired
    private ProductCreateDao productCreateDao;

    public void createProducts(String vendor, List<ProductDto> productDtoList) {
        productCreateDao.create(vendor, productDtoList);
    }
}
