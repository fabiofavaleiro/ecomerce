package repository;

import entity.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductRepositoryImpl implements ProductRepository{

    protected  Set<Product> listProduct = new HashSet<>();

    public ProductRepositoryImpl() {    }

    @Override
    public Product findById(int id) {

        if (exisThisID(id)){
            for (Product product1: listProduct){
                if (product1.getId() == id){
                    return product1;
                }
            }
        }
        messageIdNoencontred();
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
        if (exisThisID(id)){
            delete(id);
            listProduct.add(product);
        }else {
            messageIdNoencontred();
        }
    }

    @Override
    public void delete(int id) {
        if (exisThisID(id)){
            for (Product product1 : listProduct){
                if (product1.getId() == id){
                    listProduct.remove(product1);
                    break;
                }
            }
        }else {
            messageIdNoencontred();
        }
    }

    private void messageIdNoencontred(){
        System.out.println("Seu imbecil, o ID que vc digitou não existe na lista. Quer que eu ligue no manicombio?");
    }

    private boolean exisThisID(int id){
        boolean exist = false;
        for (Product product1: listProduct){
            if (product1.getId() == id){
                exist = true;
            }
        }
        return exist;
    }

}
