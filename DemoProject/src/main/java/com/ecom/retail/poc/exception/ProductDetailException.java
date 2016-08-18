package com.ecom.retail.poc.exception;

import javax.ws.rs.core.Response.Status;

public class ProductDetailException extends Exception {
    private static final long serialVersionUID = -7399597906948051933L;

    private Status messageId;

    public Status getMessageId() {
        return messageId;
    }

    public void setMessageId(Status messageId) {
        this.messageId = messageId;
    }

    public ProductDetailException() {}

    public ProductDetailException(String message) {
        super(message);
    }

    public ProductDetailException(String message, Status messageId) {
        super(message);
        this.messageId = messageId;
    }

    public ProductDetailException(Throwable cause) {
        super(cause);
    }

    public ProductDetailException(String message, Throwable cause) {
        super(message, cause);
    }

}