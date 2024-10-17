package controller;

import entity.Product;
import service.ProductService;

import java.util.Set;

public class ProductController {
//
ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

        public void deleteProduct ( int id){
            productService.delete(id);
        }

        public void updateProduct ( int id, String nameProduct , double valueProduct){
            productService.update(id, nameProduct, valueProduct );
        }

        public void addProduct (Product product){

            productService.save(product);
        }

        public Set<Product> getProducts () {
            return productService.findAll();
        }

        public Product getProductById ( int id){
            return productService.findById(id);
        }

}
