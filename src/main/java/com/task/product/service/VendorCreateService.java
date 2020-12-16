package com.task.product.service;

import com.task.product.model.VendorDto;
import com.task.product.repository.VendorCreateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Enes Kantepe
 */
@Service
public class VendorCreateService {
    @Autowired
    private VendorCreateDao vendorCreateDao;

    public void createVendorForApi(VendorDto vendorDto) {
        vendorCreateDao.createVendor(vendorDto);
    }

}
