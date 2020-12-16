package com.task.product.repository.mongo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.task.product.model.MongoConstants;
import com.task.product.model.VendorServiceModel;
import com.task.product.repository.VendorDao;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.task.product.model.MongoConstants.*;

/**
 * @author Enes Kantepe
 */

@Repository
public class VendorMongoDaoImpl extends BaseMongoDao implements VendorDao {

    public List<VendorServiceModel> findVendorService(String privilege) {
        MongoCollection<Document> collection = getCollection(MongoConstants.VENDOR_COLLECTION_NAME);
        Document query = new Document(DB_KEY_VENDOR_PRIVILEGE, privilege);
        MongoCursor<Document> iterator = collection.find(query).iterator();
        List<VendorServiceModel> vendors = new ArrayList<>();
        while (iterator.hasNext()) {
            Document next = iterator.next();
            String vendorName = next.getString(DB_KEY_VENDOR_NAME);
            String serviceName = next.getString(DB_KEY_VENDOR_SERVICE_NAME);
            String apiKey = next.getString(DB_KEY_VENDOR_APIKEY);
            VendorServiceModel vendorServiceModel = new VendorServiceModel(vendorName, serviceName, apiKey);
            vendors.add(vendorServiceModel);
        }
        return vendors;
    }
}
