package com.task.product.service.vendor;

import com.task.product.model.VendorServiceModel;
import com.task.product.service.SpringContext;
import com.task.product.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.task.product.model.MongoConstants.DB_KEY_PRIVILEGE_PULL;

/**
 * @author Enes Kantepe
 */

@Service
public class PullImportService {

    @Autowired
    private SpringContext springContext;

    @Autowired
    private VendorService vendorService;

    @Scheduled(cron = "0/5 * * * * *")
    public void pullImport() {
        List<VendorServiceModel> vendorService = this.vendorService.getVendorService(DB_KEY_PRIVILEGE_PULL);
        for (VendorServiceModel vendorServiceModel : vendorService) {
            VendorPullImportService providerService = (VendorPullImportService) springContext.getBeanOfName(vendorServiceModel.getServiceName());
            providerService.pullImport();
        }
    }
}
