package com.ecom.retail.poc.constant;

import java.io.Serializable;

public class ServiceConstant  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7898186226880848990L;
	
	public static final String HTTPS="https://"; 
	public static int STATUS_OK = 200;
	public static String BLANK_QUOTES = "";
	public static String PRICE_ID_MSG = "NO DOCUMENT FOUND WITH INPUT ID ";
	public static String SUCCESS_UPDATE_MSG = "PRICE SUCCESSFULLY UPDATED";
	public static String ERROR_NULL_OBJECT_MSG = "PUT REQUEST WITH NULL DATA NOT ALLOWED";
	public static String PRICE_ERROR_MSG = " PRICE SHOULD NOT BE ZERO OR LESS THAN ZERO";
	public static String NO_RECORD_FOUND_MSG = "NO RECORD FOUND   WITH ID PROVIDED";
	public static String NO_PRICE_RECORD_MSG = "NO PRICE RECORD FOUND  WITH ID";
	public static String ID_CANNOT_BE_NULL = "ID SHOULD NOT BE NULL";
	public static String ERROR_MSG_STRING = "INPUT IS NOT NUMBER";
	public static String ERROR_MSG_STRING_ZERO = "INPUT NUMBER SHOULD BE GREATER THAN ZERO";
	
	
	

}
