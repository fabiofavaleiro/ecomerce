package repository;

import entity.Product;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ProductRepositoryImpl implements ProductRepository{

    protected  Set<Product> listProduct = new HashSet<>();

    public ProductRepositoryImpl() {    }

    @Override
    public Product findById(int id) {
            for (Product product1: listProduct){
                if (product1.getId() == id){

                    Product product= new Product();

                    product.setId(product1.getId());
                    product.setCompanyId(product1.getCompanyId());
                    product.setCodeId(product1.getCodeId());
                    product.setProductName(product1.getProductName());
                    product.setValue(product1.getValue());
                    product.setProductType(product1.getProductType());
                    product.setProductDescription(product1.getProductDescription());
                    product.setProductImage(product1.getProductImage());
                    product.setCreationDate(product1.getCreationDate());
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
    public void update(int id, String nameProduct , double valueProduct) {

        Product product = findById(id);
        product.setProductName(nameProduct);
        product.setValue(valueProduct);

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
