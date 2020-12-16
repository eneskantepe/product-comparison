package com.task.product.repository;

import com.task.product.model.VendorServiceModel;

import java.util.List;

/**
 * @author Enes Kantepe
 */
public interface VendorDao {
    List<VendorServiceModel> findVendorService(String privilege);
}
