package com.ecom.retail.poc.dao.test.impl;

import java.io.IOException;
import java.net.UnknownHostException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ecom.retail.poc.dao.test.util.AppUtils;
import com.ecom.retail.poc.valueobject.ProductPrice;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.mongo.tests.MongodForTestsFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:mongo-config-test.xml")
public class ProductDetailsTestImpl {

	private static final String PRICE_COLLECTION_NAME = "price";
    private static final String DB_NAME = "productdetails";
    private static final Integer INSERT_ID = 1523;
    private static final double VALUE = 27.00;
    private static final String CURRENCY_CODE = "USD";
    private static final String PRICE_ID = "_id";

    private static DBCollection priceCollection;

    MongodForTestsFactory factory;

    @Autowired
    private ProductDetailsDAOTestImpl productDetailsTestDAO;
    @Autowired
    private MongoClient mongoClient;

    @Before
    public void setup() throws Exception {
        factory = MongodForTestsFactory.with(Version.Main.PRODUCTION);
        ProductDetailsinit();
    }

    @After
    public void teardown() throws Exception {
        if (factory != null) {
            factory.shutdown();
        }
    }

    /*  COMMENTS
     *   This method  will initialise the mongoclient and connect with mongodb and price collection .*/
    public void ProductDetailsinit() throws UnknownHostException {
        DB productDetailsfDatabase = mongoClient.getDB(DB_NAME);
        priceCollection = productDetailsfDatabase.getCollection(PRICE_COLLECTION_NAME);
        Assert.assertTrue(priceCollection.count() != 4);
    }
    
    /*  COMMENTS
     *   This method  will throw null pointer as null as input is trying to fecth from mongo collection .*/

    @Test(expected = NullPointerException.class)
    public void readPriceIdTest() throws IOException {
        DBObject query = new BasicDBObject(PRICE_ID, null);
        DBObject dbObject = priceCollection.findOne(query);
        Assert.assertNull("Object  null expected from mongodb after sending null as input", dbObject);
    }

    /*  COMMENTS
     *   This method  will query mongo collection and fetch the data of input id .*/
    @Test
    public void readPriceByIdTest() throws IOException {
        DBObject query = new BasicDBObject(PRICE_ID, INSERT_ID);
        DBObject dbObject = priceCollection.findOne(query);
        Assert.assertNotNull("Object not null expected from mongodb after sending null as input", dbObject);
    }

    /*  COMMENTS
     *   This method  will insert in  mongo collection .*/
    @Test
    public void updateProductPriceObj() {
        ProductPrice price = new ProductPrice();
        price.setValue(VALUE);
        price.setcurrency_Code(CURRENCY_CODE);
        DBObject dbObject = AppUtils.toDBObject(price);
        dbObject.put(PRICE_ID, INSERT_ID);
        WriteResult result = priceCollection.insert(dbObject);
        Assert.assertEquals(result.getN(), 0);


    }

}