package com.task.product.controller;


import com.task.product.model.ProductDto;
import com.task.product.service.ProductSearchService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Enes Kantepe
 */

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductSearchController {

    @Autowired
    private ProductSearchService productSearchService;

    @GetMapping(value = "/search")
    public ResponseEntity<List<ProductDto>> search(@RequestParam(required = false) String name, @RequestParam(required = false) String category) {
        if (StringUtils.isEmpty(name) && StringUtils.isEmpty(category)) {
            return ResponseEntity.badRequest().build();
        }
        List<ProductDto> products = productSearchService.getProducts(name, category);
        if (products.size() == 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }
}
