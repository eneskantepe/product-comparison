package com.task.product.mongo;

import com.google.common.collect.Lists;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Enes Kantepe
 */
public class ProductMongoClient {
    @Value("${mongo.contactpoints}")
    private String mongoServers;

    @Value("${mongo.user}")
    private String user;

    @Value("${mongo.password}")
    private String password;

    public MongoClient mongoClient() {
        List<MongoCredential> credentials = new ArrayList<>();
        if (!StringUtils.isEmpty(user) && !StringUtils.isEmpty(password)) {
            credentials = Lists.newArrayList(MongoCredential.createScramSha1Credential(user, "admin", password.toCharArray()));
        }
        return new MongoClient(createServerAddress(mongoServers.split(",")), credentials, getOptions());
    }

    private List<ServerAddress> createServerAddress(String[] hostArray) {
        List<ServerAddress> serverAddress = new ArrayList<>();

        for (String host : hostArray) {
            serverAddress.add(new ServerAddress(host));
        }

        return serverAddress;
    }

    private MongoClientOptions getOptions() {
        MongoClientOptions.Builder optionsBuilder = MongoClientOptions.builder();
        optionsBuilder.connectTimeout(10000);
        optionsBuilder.connectionsPerHost(500);
        optionsBuilder.maxWaitTime(120000);
        optionsBuilder.socketTimeout(0);
        return optionsBuilder.build();
    }
}
