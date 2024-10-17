package repository;

import entity.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductRepositoryImpl implements ProductRepository{
//
    protected  Set<Product> listProduct = new HashSet<>();

    public ProductRepositoryImpl() {    }

    @Override
    public Product findById(int id) {
            for (Product product1: listProduct){
                if (product1.getId() == id){
                    Product product= new Product();

                    product.setId(product1.getId());




                    return product;
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
            delete(id);
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
        boolean exist = false;
        for (Product product1: listProduct){
            if (product1.getId() == id){
                exist = true;
            }
        }
        return exist;
    }

}
