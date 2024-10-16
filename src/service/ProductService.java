package service;

import entity.Product;
import repository.ProductRepository;
import repository.ProductRepositoryImpl;

import java.util.Set;

public class ProductService {
    private ProductRepository productRepository;



    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void delete(int id) {
        productRepository.delete(id);
    }

    public void update(int id, Product product) {
        productRepository.update(id, product);
    }

    public void save(Product product) {

        productRepository.save(product);
    }

    public Set<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(int id) {
        return productRepository.findById(id);
    }
}

