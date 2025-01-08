package com.fabiovaleiro.repository;

import com.fabiovaleiro.entity.Product;

import java.util.Set;

public interface ProductRepository {

    Product findById(int id);
    Set<Product> findAll();
    void save(Product product);
    void update(Product product);
    void delete(int id);
    boolean exisThisID(int id);


}
