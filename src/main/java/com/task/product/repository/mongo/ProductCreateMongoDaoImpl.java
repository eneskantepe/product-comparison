package com.task.product.repository.mongo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOneModel;
import com.mongodb.client.model.WriteModel;
import com.task.product.model.MongoConstants;
import com.task.product.model.ProductDto;
import com.task.product.repository.ProductCreateDao;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.task.product.model.MongoConstants.*;

/**
 * @author Enes Kantepe
 */

@Repository
public class ProductCreateMongoDaoImpl extends BaseMongoDao implements ProductCreateDao {

    @Override
    public void create(String vendor, List<ProductDto> productDtos) {
        MongoCollection<Document> collection = getCollection(PRODUCT_COLLECTION_NAME);
        List<WriteModel<Document>> bulkUpdates = new ArrayList<>();
        for (ProductDto productDto : productDtos) {
            Document idQuery = new Document();
            idQuery.put(DB_KEY_PRODUCT_PRODUCT_ID, productDto.getId());
            Document vendorQuery = new Document();
            vendorQuery.put(DB_KEY_PRODUCT_VENDOR, vendor);
            Bson findQuery = Filters.and(idQuery, vendorQuery);
            Document document = new Document();
            document.put(DB_KEY_PRODUCT_CATEGORY, productDto.getCategory());
            document.put(DB_KEY_PRODUCT_PRICE, productDto.getPrice());
            document.put(DB_KEY_PRODUCT_NAME, productDto.getName());
            bulkUpdates.add(new UpdateOneModel<>(findQuery, new Document(MongoConstants.SET, document), UPSERT_OPTION));
            if (bulkUpdates.size() == 100) {
                collection.bulkWrite(bulkUpdates, new BulkWriteOptions().ordered(false));
                bulkUpdates = new ArrayList<>();
            }
        }
        if (bulkUpdates.size() > 0) {
            collection.bulkWrite(bulkUpdates, new BulkWriteOptions().ordered(false));
        }
    }
}
