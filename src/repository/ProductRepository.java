package repository;

import entity.Product;

import java.util.Set;

public interface ProductRepository {

//
    Product findById(int id);
    Set<Product> findAll();
    void save(Product product);
    void update(int id, String nameProduct , double valueProduct);
    void delete(int id);
    boolean exisThisID(int id);


}
