package com.fabiovaleiro.response;

public class Response<T> implements ResponseInterface<T> {
    private T data;
    private ErrorDetails error;



    public Response(T data){
        this.data = data;
    }

    public Response(ErrorDetails error){
        this.error = error;
    }

    public Response(){
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ErrorDetails getError() {
        return error;
    }

    public void setError(ErrorDetails error) {
        this.error = error;
    }


}
