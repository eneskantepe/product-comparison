package com.task.product.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author Enes Kantepe
 */

@Data
@ToString
public class VendorDto {
    private String vendor;
    private String serviceName;
    private String apiKey;
    private String privilege;
}
