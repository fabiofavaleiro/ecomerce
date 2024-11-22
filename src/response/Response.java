package response;

import entity.Product;

public class Response<T> {
    private T data;
    private String errorMessage;
    private int errorcode;
    Product produto = new Product();
    int teste;


    public Response(T data){
        this.data = data;
    }

    public Response(Product produto, int errorCode, int teste){
        this.produto = produto;
        this.errorcode = errorCode;
        this.teste = teste;
    }

    public Response(String errorMessage, int errorCode){
        this.errorMessage = errorMessage;
        this.errorcode = errorCode;
    }

    public T getData(){
        return data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getErrorcode() {
        return errorcode;
    }

    public boolean isSuccess() {
        return errorMessage == null;
    }

    @Override
    public String toString() {
        return "Response{" +
                "data=" + data +
                ", errorMessage='" + errorMessage + '\'' +
                ", errorcode=" + errorcode +
                '}';
    }

    public Product getProduto() {
        return produto;
    }

    public void setProduto(Product produto) {
        this.produto = produto;
    }
}
