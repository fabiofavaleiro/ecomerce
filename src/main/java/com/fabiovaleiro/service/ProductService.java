package com.fabiovaleiro.service;

import com.fabiovaleiro.entity.Product;
import com.fabiovaleiro.repository.ProductRepository;
import com.fabiovaleiro.Exception.EcommerceDomainException;

import java.util.Set;

public class ProductService {
    private ProductRepository productRepository;



    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    public void delete(int id) {
            productRepository.delete(id);
    }

    public void update(Product product) {
            productRepository.update(product);
    }

    public void save(Product product) {

         if (product.getId() != 0 ){
            throw new IllegalArgumentException("O Produto não deve ter ID ao ser salvo.");
        }else{
             productRepository.save(product);
         }
    }

    public Set<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(int id) {
            return productRepository.findById(id);
    }

    private void messageIdNoencontred(){
        System.out.println("Nobre usuàrio, o ID desejado não está na lista, por favor tente novamente, obrigado!");
    }


}

