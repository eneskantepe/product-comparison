package com.task.product.service.vendor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Enes Kantepe
 */

@Service
@Slf4j
public class AmazonVendorService implements VendorPullImportService {

    public boolean started;

    private final static String VENDOR_NAME = "amazon";

    @Override
    public void pullImport() {
        if (!started) {
            log.info("vendor :: {} is subscribing to queue", VENDOR_NAME);
            //
            started = true;
        } else {
            log.info("vendor :: {} has already subscribed", VENDOR_NAME);
        }
    }
}
