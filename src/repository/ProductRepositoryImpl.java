package repository;

import entity.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductRepositoryImpl implements ProductRepository{

    protected  Set<Product> listProduct = new HashSet<>();
    protected Product product = new Product();

    public ProductRepositoryImpl() {    }

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
        return listProduct;
    }

    @Override
    public void save(Product product) {

        listProduct.add(product);

    }

    @Override
    public void update(int id, Product product) {
        for(Product product1 : listProduct){
            if (product1.getId() == id){
                listProduct.remove(product1);
                listProduct.add(product);
            }
        }
    }

    @Override
    public void delete(int id) {
        for (Product product1 : listProduct){
            if (product1.getId() == id){
                listProduct.remove(product1);
            }
        }


    }







}
