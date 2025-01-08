package com.fabiovaleiro.response;

public class ResponseBuilder<T> {
    private T data;
    private ErrorDetails error;





    public ResponseBuilder<T> setData(T data){
        this.data= data;
        return this;
    }

    public ResponseBuilder<T> setError(ErrorDetails error){
        this.error = error;
        return this;
    }

    public Response<T> build(){
        Response<T> response = new Response<>();
        response.setData(data);
        response.setError(error);
        return response;
    }

}
