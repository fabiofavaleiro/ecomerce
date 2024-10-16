package controller;

import entity.Product;
import repository.ProductRepository;
import repository.ProductRepositoryImpl;
import service.ProductService;

import java.util.Set;

public class ProductController {

    private ProductRepository productRepository = new ProductRepositoryImpl();

    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    ProductService productService = new ProductService(productRepository);


    public void deleteProduct(int id) {
        productService.delete(id);
    }

    public void updateProduct(int id, Product product) {
        productService.update(id, product);
    }

    public void addProduct(Product product) {

        productService.save(product);
    }

    public Set<Product> getProducts() {
        return productService.findAll();
    }

    public Product getProductById(int id) {
        return productService.findById(id);
    }
}
