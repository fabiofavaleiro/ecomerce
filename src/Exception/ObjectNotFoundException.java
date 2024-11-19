package Exception;

public class ObjectNotFoundException extends EcommerceDomainException{

    public ObjectNotFoundException(String message){
        super(message, 404);
    }
}
