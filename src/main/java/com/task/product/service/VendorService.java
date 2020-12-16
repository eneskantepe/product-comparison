package com.task.product.service;

import com.task.product.model.VendorServiceModel;
import com.task.product.repository.VendorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Enes Kantepe
 */
@Service
public class VendorService {

    @Autowired
    private VendorDao vendorDao;

    public List<VendorServiceModel> getVendorService(String privilege) {
        return vendorDao.findVendorService(privilege);
    }
}