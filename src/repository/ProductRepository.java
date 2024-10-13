package repository;

import entity.Product;

import java.util.Set;

public interface ProductRepository {
    Product findById(int id);
    Set<Product> findAll();
    void save(Product product);
    void update(int id, Product product);
    void delete(int id);


}
