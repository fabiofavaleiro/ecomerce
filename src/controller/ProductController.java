package controller;

import entity.Product;
import response.ErrorDetails;
import response.Response;
import response.ResponseBuilder;
import service.ProductService;
import Exception.EcommerceDomainException;
import java.util.Set;

public class ProductController implements ProductControllerInterface{

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    public Response<Void> deleteProduct ( int id){
        try {
            productService.delete(id);
            return new ResponseBuilder<Void>().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public Response<Void> updateProduct ( Product product){
        try{
            productService.update(product);
            return new ResponseBuilder<Void>().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public Response<Void> addProduct (Product product){
        try {
            productService.save(product);
            return new ResponseBuilder<Void>().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public Response<Set<Product>> getProducts () {
        try {
            return new ResponseBuilder<Set<Product>>().setData(productService.findAll()).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public Response<Product> getProductById ( int id){
        try {
            Product product = productService.findById(id);
            return new ResponseBuilder<Product>().setData(product).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
