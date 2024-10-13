import entity.Product;

import java.util.Date;
import java.util.HashSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        HashSet<Product> listaProdutos = new HashSet<>();
        Product produto = new Product();
        Product produto2 = new Product();
        Product produto3 = new Product();
        Product produto4 = new Product();

        produto.setId(1);
        produto.setCompanyId(1);
        produto.setCodeId(1);
        produto.setProductName("nome do produto");
        produto.setValue(3.30);
        produto.setProductType("tipo do produto");
        produto.setProductDescription("muito bom");
        produto.setProductImage("c:");
        produto.setCreationDate(new Date(2024-05-06));
        listaProdutos.add(produto);

        produto2.setId(2);
        produto2.setCompanyId(2);
        produto2.setCodeId(2);
        produto2.setProductName("nome do produto2");
        produto2.setValue(3.32);
        produto2.setProductType("tipo do produto2");
        produto2.setProductDescription("muito bom2");
        produto2.setProductImage("c:2");
        produto2.setCreationDate(new Date(2024-05-02));
        listaProdutos.add(produto2);

        produto3.setId(3);
        produto3.setCompanyId(3);
        produto3.setCodeId(3);
        produto3.setProductName("nome do produto3");
        produto3.setValue(3.33);
        produto3.setProductType("tipo do produto3");
        produto3.setProductDescription("muito bom3");
        produto3.setProductImage("c:3");
        produto3.setCreationDate(new Date(2024-05-03));
        listaProdutos.add(produto3);

        produto4.setId(4);
        produto4.setCompanyId(4);
        produto4.setCodeId(4);
        produto4.setProductName("nome do produto4");
        produto4.setValue(3.34);
        produto4.setProductType("tipo do produto4");
        produto4.setProductDescription("muito bom4");
        produto4.setProductImage("c:4");
        produto4.setCreationDate(new Date(2024-05-04));
        listaProdutos.add(produto4);


        for (Product product : listaProdutos) {
            System.out.println(product);
        }




    }
}