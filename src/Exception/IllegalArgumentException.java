package Exception;

public class IllegalArgumentException extends EcommerceDomainException{

    public IllegalArgumentException(String message) {
        super(message, 400);
    }
}
