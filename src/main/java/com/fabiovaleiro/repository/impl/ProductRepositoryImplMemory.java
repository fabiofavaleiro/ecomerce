package com.fabiovaleiro.repository.impl;

import com.fabiovaleiro.entity.Product;
import com.fabiovaleiro.repository.ProductRepository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ProductRepositoryImplMemory implements ProductRepository {

    private static int currentID = 1;

    protected  Set<Product> listProduct = new HashSet<>();

    public ProductRepositoryImplMemory() {    }

    @Override
    public Product findById(int id) {
            for (Product product1: listProduct){
                if (product1.getId() == id){
                    return product1;
                }
            }
            return null;
    }

    @Override
    public Set<Product> findAll() {

        return Collections.unmodifiableSet(listProduct);

    }

    @Override
    public void save(Product product) {
        product.setId(currentID);
        currentID++;
        listProduct.add(product);
    }

    @Override
    public void update(Product product) {
                    listProduct.add(product);
    }

    @Override
    public void delete(int id) {
            for (Product product1 : listProduct) {
                if (product1.getId() == id) {
                    listProduct.remove(product1);
                    break;
                }
            }
    }



    public boolean exisThisID(int id){

        for (Product product1: listProduct){
            if (product1.getId() == id){
                return true;
            }
        }
        return false;
    }

}
