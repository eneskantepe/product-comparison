package com.task.product.repository.mongo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.UpdateOptions;
import com.task.product.mongo.ProductMongoClient;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.task.product.model.MongoConstants.DB_NAME;

/**
 * @author Enes Kantepe
 */

@Repository
public class BaseMongoDao {

    public final static UpdateOptions UPSERT_OPTION = createUpdateOptions(true);

    @Autowired
    private ProductMongoClient productMongoClient;

    private static UpdateOptions createUpdateOptions(boolean upsert) {
        UpdateOptions opt = new UpdateOptions();
        opt.upsert(upsert);
        return opt;
    }


    public MongoCollection<Document> getCollection(String collection) {
        return productMongoClient.mongoClient().getDatabase(DB_NAME).getCollection(collection);
    }
}
