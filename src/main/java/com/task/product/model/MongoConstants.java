package com.task.product.model;

/**
 * @author Enes Kantepe
 */

public interface MongoConstants {
    String SET = "$set";
    String REGEX = "$regex";
    String DB_NAME = "task";
    String VENDOR_COLLECTION_NAME = "vendors";
    String PRODUCT_COLLECTION_NAME = "products";

    String DB_KEY_PRODUCT_PRODUCT_ID = "productId";
    String DB_KEY_PRODUCT_VENDOR = "vendor";
    String DB_KEY_PRODUCT_CATEGORY = "category";
    String DB_KEY_PRODUCT_PRICE = "price";
    String DB_KEY_PRODUCT_NAME = "name";

    String DB_KEY_VENDOR_PRIVILEGE = "privilege";
    String DB_KEY_VENDOR_NAME = "name";
    String DB_KEY_VENDOR_APIKEY = "apiKey";
    String DB_KEY_PRIVILEGE_REST_API = "rest-api";
    String DB_KEY_PRIVILEGE_PULL = "pull";
    String DB_KEY_PRIVILEGE_BATCH = "batch";
    String DB_KEY_VENDOR_SERVICE_NAME= "serviceName";


}
