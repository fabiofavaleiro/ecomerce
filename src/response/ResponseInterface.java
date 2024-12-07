package response;

public interface ResponseInterface<T> {

    public T getData();

    public void setData(T data);

    public ErrorDetails getError();

    public void setError(ErrorDetails error);


}
