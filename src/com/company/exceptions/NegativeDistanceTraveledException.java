package com.company.exceptions;

public class NegativeDistanceTraveledException extends Exception {
    public NegativeDistanceTraveledException(String errMsg){
        super(errMsg);
    }
}
