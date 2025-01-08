package com.fabiovaleiro.controller;

import com.fabiovaleiro.entity.Product;
import com.fabiovaleiro.response.Response;

import java.util.Set;

public interface ProductControllerInterface {

    public Response<Void> deleteProduct (int id);
    public Response<Void> updateProduct ( Product product);
    public Response<Void> addProduct (Product product);
    public Response<Set<Product>> getProducts ();
    public Response<Product> getProductById ( int id);




}
