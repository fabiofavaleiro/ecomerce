package com.fabiovaleiro.response;

public class ErrorDetails {
    private String message;
    private int StatusCode;


    public ErrorDetails(String message, int statusCode) {
        this.message = message;

        StatusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "message='" + message + '\'' +
                ", StatusCode=" + StatusCode +
                '}';
    }
}
