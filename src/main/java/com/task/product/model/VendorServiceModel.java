package com.task.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Enes Kantepe
 */
@Data
@AllArgsConstructor
public class VendorServiceModel {
    private String vendor;
    private String serviceName;
    private String apiKey;
}
