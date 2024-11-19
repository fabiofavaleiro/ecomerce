package service;

import entity.Product;
import repository.ProductRepository;
import Exception.EcommerceDomainException;

import java.util.Objects;
import java.util.Set;

public class ProductService {
    private ProductRepository productRepository;



    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    public void delete(int id) {
        if(productRepository.exisThisID(id)){
            productRepository.delete(id);
        }else {
            messageIdNoencontred();
        }

    }

    public void update(Product product) {

        if(productRepository.exisThisID(product.getId())){
            productRepository.delete(product.getId());
            productRepository.update(product);
        }else {
            messageIdNoencontred();
            throw new EcommerceDomainException("ID não existe ao atualizar", 1);
        }
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
        if (productRepository.findById(id)==null){
            messageIdNoencontred();
            return null;
        }else {
            return productRepository.findById(id);
        }
    }

    private void messageIdNoencontred(){
        System.out.println("Nobre usuàrio, o ID desejado não está na lista, por favor tente novamente, obrigado!");
    }


}

