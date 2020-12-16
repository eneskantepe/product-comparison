package com.task.product.repository;

import com.task.product.model.VendorDto;

/**
 * @author Enes Kantepe
 */
public interface VendorCreateDao {
    void createVendor(VendorDto vendorDto);
}
