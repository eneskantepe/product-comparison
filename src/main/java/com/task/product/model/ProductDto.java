package com.task.product.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author Enes Kantepe
 */

@Data
@ToString
public class ProductDto {
    private String name;
    private String id;
    private String category;
    private Double price;
    private String vendor;
}
