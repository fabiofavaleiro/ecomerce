package com.fabiovaleiro.Exception;

public class EcommerceDomainException extends RuntimeException{

    private int statusCode;

    public EcommerceDomainException(String message, int statusCode){
        super(message);
        this.statusCode = statusCode;
    }


    public int getStatusCode() {
        return statusCode;
    }
}
