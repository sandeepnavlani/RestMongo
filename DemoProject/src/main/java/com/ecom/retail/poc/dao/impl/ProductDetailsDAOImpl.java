package com.ecom.retail.poc.dao.impl;

import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ecom.retail.poc.dao.ProductDetailsDAO;
import com.ecom.retail.poc.exception.ProductDetailException;
import com.ecom.retail.poc.util.JsonUtil;
import com.ecom.retail.poc.valueobject.ProductPrice;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

@Repository
public class ProductDetailsDAOImpl implements ProductDetailsDAO, Serializable {

    private static final Logger log = LoggerFactory.getLogger(ProductDetailsDAOImpl.class);
    private static final long serialVersionUID = 4057569855882570419L;

    private MongoClient mongoClient;
    private String dbName;
    private String productCollectionName;
    private String priceCollectionName;
    private DBCollection priceCollection;

    public ProductDetailsDAOImpl() {

    }

    /*  COMMENTS
     *  Initialisation and connecting to mongo DB and collection .*/
    public void init() throws UnknownHostException {
        DB productDetailsfDatabase = mongoClient.getDB(dbName);
        priceCollection = productDetailsfDatabase.getCollection(getPriceCollectionName());
    }

    public DBCollection getPriceCollection() {
        return priceCollection;
    }

    public void setPriceCollection(DBCollection priceCollection) {
        this.priceCollection = priceCollection;
    }
    
    /*  COMMENTS
     *   This method  will fetch the  data from mongodb price colection.
        Fetch productPrice object from price collection and return .*/
    
    @Override
    public Optional < ProductPrice > readPriceById(String id) throws ProductDetailException {
        ProductPrice price = null;
        try {
            if (StringUtils.isNotBlank(id)) {
                DBObject query = new BasicDBObject("_id", id);
                DBObject dbObject = priceCollection.findOne(query);
                if (null != dbObject) {
                    price = JsonUtil.toProductPrice(dbObject.toString());
                }

            }
        } catch (MongoException | IOException e){
            throw new ProductDetailException("Exception During  readPriceById() method while querying mongo :::" + e.getMessage());
        } 
        if (price == null) {
            log.info("price with Id does not exist ::::", id);
            return null;

        } else {
            return Optional.of(price);
        }
    }
    
    /*  COMMENTS
     *   This method  will update the incoming data in mongodb price colection.
        It will  fetch data from price collection and update the price.*/

    @Override
    public Optional < ProductPrice > updateProductPriceObj(String id, ProductPrice productPrice)
    throws ProductDetailException {
        Optional < ProductPrice > price = null;
        String productJson = null;
        try {

            DBObject query = new BasicDBObject("_id", id);
            DBObject dbObject = priceCollection.findOne(query);
            DBObject object = null;
            if (null != productPrice) {
                productJson = JsonUtil.fromObjectToJson(productPrice);
            }
            if (StringUtils.isNotBlank(productJson)) {
                if (null != dbObject) {
                    object = (DBObject) JSON.parse(productJson);
                    WriteResult result = priceCollection.update(query, object);
                    if (result.getN() == 1) {
                        log.info("Updated price with Id ::::", id);
                        price = Optional.of(productPrice);
                    }
                }
            }
        } catch (MongoException | IOException e){
           throw new ProductDetailException("Exception while  updating the price of product updateProductPriceObj() method  :::" + e.getMessage());
        }
        return price;

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