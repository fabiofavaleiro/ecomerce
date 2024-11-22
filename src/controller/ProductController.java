package controller;

import entity.Product;
import response.Response;
import service.ProductService;

import java.util.Set;

public class ProductController {

ProductService productService;

    public ProductController(ProductService productService) {
        try {
            this.productService = productService;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public void deleteProduct ( int id){
        try {
            productService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }

        public void updateProduct ( Product product){
        try{
            productService.update(product);
            } catch (Exception e) {
            e.printStackTrace();
        }
        }

        public void addProduct (Product product){
            try {
                productService.save(product);

            } catch (Exception e) {
                new Response<>(e.getMessage(),3 );
            }
        }

        public Set<Product> getProducts () {
            /*try {
                return productService.findAll();
            } catch (Exception e) {
                e.printStackTrace();
            }*/
            return productService.findAll();
        }

        public Response<Object> getProductById ( int id){
        try {

            Product product = productService.findById(id);
            return new Response<>(product, 0, 0);

        } catch (Exception e) {
           // ErrorDetails error = new ErrorDetails(e.getMessage(), "/product" + id, e.getStatusCode());
            return  new Response<>(null,1);
        }
        }

}
