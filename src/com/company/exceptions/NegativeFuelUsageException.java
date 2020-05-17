package com.company.exceptions;

public class NegativeFuelUsageException extends Exception {
    public NegativeFuelUsageException(String errMsg){
        super(errMsg);
    }
}
