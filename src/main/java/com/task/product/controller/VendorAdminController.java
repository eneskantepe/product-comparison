package com.task.product.controller;

import com.task.product.model.VendorDto;
import com.task.product.service.VendorCreateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Enes Kantepe
 */

@Slf4j
@RestController
@RequestMapping("/vendor")
public class VendorAdminController {

    @Autowired
    private VendorCreateService vendorCreateService;

    @PostMapping(value = "/create")
    public ResponseEntity post(@RequestBody VendorDto vendorDto) {
        vendorCreateService.createVendorForApi(vendorDto);
        return ResponseEntity.ok().build();
    }
}
