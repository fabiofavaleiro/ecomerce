package controller;

import entity.Product;
import response.ErrorDetails;
import response.Response;
import service.ProductService;
import Exception.EcommerceDomainException;
import java.util.Set;

public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public Response<Void> deleteProduct ( int id){
        try {
            productService.delete(id);
            return new Response<>();
        } catch (EcommerceDomainException e) {
            ErrorDetails errorDetails = new ErrorDetails(e.getMessage(), e.getStatusCode());
            return new Response<>(errorDetails);
        } catch (Exception e) {
            ErrorDetails errorDetails = new ErrorDetails("Erro Interno", 500);
            return new Response<>(errorDetails);
        }
    }

    public Response<Void> updateProduct ( Product product){
        try{
            productService.update(product);
            return new Response<>();
        } catch (EcommerceDomainException e) {
            ErrorDetails errorDetails = new ErrorDetails(e.getMessage(), e.getStatusCode());
            return new Response<>(errorDetails);
        } catch (Exception e) {
            ErrorDetails errorDetails = new ErrorDetails("Erro Interno", 500);
            return new Response<>(errorDetails);
        }
    }

    public Response<Void> addProduct (Product product){
        try {
            productService.save(product);
            return new Response<>();
        } catch (EcommerceDomainException e) {
            ErrorDetails errorDetails = new ErrorDetails(e.getMessage(), e.getStatusCode());
            return new Response<>(errorDetails);
        } catch (Exception e){
            ErrorDetails errorDetails = new ErrorDetails("Erro Interno", 500);
            return new Response<>(errorDetails);
        }
    }

    public Response<Set<Product>> getProducts () {
        try {
            return new Response<>(productService.findAll());
        } catch (EcommerceDomainException e) {
            ErrorDetails errorDetails = new ErrorDetails(e.getMessage(), e.getStatusCode());
            return new Response<>(errorDetails);
        } catch (Exception e){
            ErrorDetails errorDetails = new ErrorDetails("Erro Interno", 500);
            return new Response<>(errorDetails);
        }
    }

    public Response<Product> getProductById ( int id){
        try {
            Product product = productService.findById(id);
            return new Response<>(product);
        } catch (EcommerceDomainException e) {
            ErrorDetails errorDetails = new ErrorDetails(e.getMessage(), e.getStatusCode());
            return  new Response<>(errorDetails);
        } catch (Exception e) {
            ErrorDetails errorDetails = new ErrorDetails("Erro Interno", 500);
            return  new Response<>(errorDetails);
        }
    }

}
