package com.task.product.configuration;

import com.task.product.mongo.ProductMongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Enes Kantepe
 */
@Configuration
public class MongoConfiguration {

    @Bean(name = "productMongoClient")
    public ProductMongoClient productMongoClient() {
        return new ProductMongoClient();
    }
}
