package com.task.product.service.vendor;

import com.task.product.model.VendorServiceModel;
import com.task.product.service.SpringContext;
import com.task.product.service.VendorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.task.product.model.MongoConstants.DB_KEY_PRIVILEGE_BATCH;

/**
 * @author Enes Kantepe
 */

@Slf4j
@Service
public class BatchImportService {

    @Autowired
    private SpringContext springContext;

    @Autowired
    private VendorService vendorService;

    @Scheduled(cron = "0/5 * * * * *")
    public void batchImport() {
        List<VendorServiceModel> vendorService = this.vendorService.getVendorService(DB_KEY_PRIVILEGE_BATCH);
        for (VendorServiceModel vendor : vendorService) {
            VendorBatchImportService providerService = (VendorBatchImportService) springContext.getBeanOfName(vendor.getServiceName());
            log.info("batch import is starting for vendor::{}", vendor);
            providerService.batchImport();
            log.info("batch import is ended for vendor::{}", vendor);
        }
    }
}
