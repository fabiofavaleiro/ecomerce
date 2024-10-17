package service;

import entity.Product;
import repository.ProductRepository;


import java.util.Objects;
import java.util.Set;
//
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

    public void update(int id, String nameProduct , double valueProduct) {

        if(productRepository.exisThisID(id)){

            productRepository.update(id, nameProduct , valueProduct);

        }else {
            messageIdNoencontred();
        }
    }

    public void save(Product product) {
        productRepository.save(product);
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
        System.out.println("Caro usuário, o ID que vc digitou não existe na lista. ");
    }


}

