package com.ecom.retail.test.poc;

import org.apache.http.HttpResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ecom.retail.test.poc.http.JsonTestClient;


@ContextConfiguration(value = "classpath:applicationcontexttest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductRestTestServices {
private static final Integer ID= 15117729;
private static final Integer NON_EXISTING_ID= 15;
private static String BASE_PATH = "http://localhost:8081/DemoProject/rest/products/";
private static final String PRODUCT_DETAILS_FOUND_MSG = "Record Found";
	 @Autowired
	private JsonTestClient jsonTestClient;
	
	@Before
	public void setup() throws Exception {
		jsonTestClient.initialize();
	}
	
	
	@After
	public void teardown() throws Exception {
		jsonTestClient.Close();
	}
	
	 /*  COMMENTS
     *   This method  will ftech data from service api and return result
     *   (NOTE:- run local tomcat run ) .*/
	
	@Test
	  public void getProductDetailsTest() throws Exception {
		StringBuilder builder = new StringBuilder();
		String url = builder.append(BASE_PATH).append(ID).toString();
		HttpResponse response = jsonTestClient.processGet(url);
		Assert.assertNotNull(PRODUCT_DETAILS_FOUND_MSG,response);
   
	  }
	
	 /*  COMMENTS
     *   This method  will fetch data with invalid id from service api 
     *   (NOTE:- run local tomcat run ) .*/

	@Test
	  public void getProductDetailsFailedTest() throws Exception {
		StringBuilder builder = new StringBuilder();
		String url = builder.append(BASE_PATH).append(NON_EXISTING_ID).toString();
		HttpResponse response = jsonTestClient.processGet(url);
		Assert.assertEquals(PRODUCT_DETAILS_FOUND_MSG,response.getStatusLine().getReasonPhrase());
 
	  }


}
