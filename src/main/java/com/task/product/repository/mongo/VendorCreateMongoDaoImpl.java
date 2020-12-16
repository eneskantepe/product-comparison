package com.task.product.repository.mongo;

import com.mongodb.client.MongoCollection;
import com.task.product.model.MongoConstants;
import com.task.product.model.VendorDto;
import com.task.product.repository.VendorCreateDao;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import static com.task.product.model.MongoConstants.*;

/**
 * @author Enes Kantepe
 */
@Repository
public class VendorCreateMongoDaoImpl extends BaseMongoDao implements VendorCreateDao {

    @Override
    public void createVendor(VendorDto vendorDto) {
        MongoCollection<Document> collection = getCollection(MongoConstants.VENDOR_COLLECTION_NAME);
        Document vendorDocument = new Document();
        vendorDocument.put(DB_KEY_VENDOR_NAME, vendorDto.getVendor());
        if (vendorDto.getApiKey() != null) {
            vendorDocument.put(DB_KEY_VENDOR_APIKEY, vendorDto.getApiKey());

        }
        vendorDocument.put(DB_KEY_VENDOR_PRIVILEGE, vendorDto.getPrivilege());
        vendorDocument.put(DB_KEY_VENDOR_SERVICE_NAME, vendorDto.getServiceName());
        collection.insertOne(vendorDocument);
    }

}
