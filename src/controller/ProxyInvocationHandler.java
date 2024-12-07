package controller;

import entity.Product;
import response.ErrorDetails;
import response.ResponseBuilder;
import Exception.EcommerceDomainException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Set;

import static logs.Logs.genereteLog;

public class ProxyInvocationHandler implements InvocationHandler {
    private final Object target;

    public ProxyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        try {
            genereteLog("Entrando no Proxy: " + method);
            Object result = method.invoke(target, args);
            return result;
        } catch (EcommerceDomainException e) {
            ErrorDetails errorDetails = new ErrorDetails(e.getMessage(), e.getStatusCode());
            return new ResponseBuilder<Set<Product>>().setError(errorDetails).build();
        } catch (Exception e){
            ErrorDetails errorDetails = new ErrorDetails("Erro Interno", 500);
            return new ResponseBuilder<Set<Product>>().setError(errorDetails).build();
        }



    }
}
