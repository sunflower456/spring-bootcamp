package com.posco.mes3.quality.tracking.domain.exception;

public class UnsupportedNameValueException extends RuntimeException {
    //
    public UnsupportedNameValueException(String propertyName) {
        //
        super(String.format("%s is not supported property by setValues method.", propertyName));
    }
}
