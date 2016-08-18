package com.ecom.retail.poc.dao.test.impl;

import java.net.UnknownHostException;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;


public class ProductDetailsDAOTestImpl {

    private static final Logger log = LoggerFactory.getLogger(ProductDetailsDAOTestImpl.class);

    private MongoClient mongoClient;
    private String dbName;
    private String productCollectionName;
    private String priceCollectionName;
    private DBCollection priceCollection;

    public ProductDetailsDAOTestImpl() {

    }
    
    /*  COMMENTS
     *   This method  will initialise the mongoclient and connect with mongodb and price collection .*/
    public void init() throws UnknownHostException {
        DB productDetailsfDatabase = mongoClient.getDB(dbName);
        priceCollection = productDetailsfDatabase.getCollection(getPriceCollectionName());
    }

    /*  COMMENTS
     *   This method  will fetch the  data from mongodb price colection.
        Fetch  object from price collection and return .*/
    
    public DBObject readPriceByIdTest(String priceId, Integer id) {
        DBObject dbObject = null;
        try {
            DBObject query = new BasicDBObject(priceId, id);
            dbObject = priceCollection.findOne(query);
            Assert.assertNotNull("Object not null expected from mongodb after sending null as input", dbObject);
            return dbObject;
        } catch (MongoException e) {
            log.info("Error connecting mongo DB:::" + e.getStackTrace());

        }
        return dbObject;
    }

    public DBCollection getPriceCollection() {
        return priceCollection;
    }

    public void setPriceCollection(DBCollection priceCollection) {
        this.priceCollection = priceCollection;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getProductCollectionName() {
        return productCollectionName;
    }

    public void setProductCollectionName(String productCollectionName) {
        this.productCollectionName = productCollectionName;
    }

    public String getPriceCollectionName() {
        return priceCollectionName;
    }

    public void setPriceCollectionName(String priceCollectionName) {
        this.priceCollectionName = priceCollectionName;
    }

}