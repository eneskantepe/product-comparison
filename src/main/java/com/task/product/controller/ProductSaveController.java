package com.task.product.controller;


import com.task.product.model.ProductDto;
import com.task.product.model.VendorServiceModel;
import com.task.product.service.ProductCreateService;
import com.task.product.service.VendorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.task.product.model.MongoConstants.DB_KEY_PRIVILEGE_REST_API;

/**
 * @author Enes Kantepe
 */

@Slf4j
@RestController
@RequestMapping("/admin/api")
public class ProductSaveController {

    protected Map<String, String> mapApiKey = new ConcurrentHashMap<>();

    @Autowired
    private VendorService vendorService;

    @Autowired
    private ProductCreateService productCreateService;

    @Scheduled(cron = "0/5 * * * * *")
    public void prepareMap(){
        List<VendorServiceModel> vendorServices = vendorService.getVendorService(DB_KEY_PRIVILEGE_REST_API);
        for (VendorServiceModel vendorService : vendorServices) {
            mapApiKey.put(vendorService.getApiKey(), vendorService.getVendor());
        }
    }

    @PostMapping(value = "/product")
    public ResponseEntity post(WebRequest request, @RequestBody List<ProductDto> products) {
        String apikey = request.getHeader("api-key");
        String vendor = mapApiKey.get(apikey);
        log.info("vendor::{} requested create product");
        if (vendor != null) {
            productCreateService.createProducts(vendor, products);
            return new ResponseEntity(HttpStatus.CREATED);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
