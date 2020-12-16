package com.task.product.repository.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.task.product.model.MongoConstants;
import com.task.product.model.ProductDto;
import com.task.product.repository.ProductSearchDao;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.task.product.model.MongoConstants.*;

/**
 * @author Enes Kantepe
 */

@Repository
public class ProductSearchMongoDaoImpl extends BaseMongoDao implements ProductSearchDao {

    @Override
    public List<ProductDto> findProducts(String name, String category) {
        MongoCollection<Document> product = getCollection(PRODUCT_COLLECTION_NAME);
        Map<String, Object> filter = new HashMap<>(2);
        if (StringUtils.isNotEmpty(name)) {
            filter.put(MongoConstants.DB_KEY_PRODUCT_NAME, new BasicDBObject(REGEX, name + ".*"));
        }
        if (StringUtils.isNotEmpty(category)) {
            filter.put(DB_KEY_PRODUCT_CATEGORY, new BasicDBObject(REGEX, category + ".*"));
        }
        Document query = new Document(filter);
        MongoCursor<Document> iterator = product.find(query).iterator();
        List<ProductDto> productDtos = new ArrayList<>();
        while (iterator.hasNext()) {
            Document document = iterator.next();
            ProductDto productDto = new ProductDto();
            productDto.setId(document.getString(DB_KEY_PRODUCT_PRODUCT_ID));
            productDto.setCategory(document.getString(DB_KEY_PRODUCT_CATEGORY));
            productDto.setPrice(document.getDouble(DB_KEY_PRODUCT_PRICE));
            productDto.setName(document.getString(DB_KEY_PRODUCT_NAME));
            productDto.setVendor(document.getString(DB_KEY_PRODUCT_VENDOR));
            productDtos.add(productDto);
        }
        return productDtos;
    }
}
