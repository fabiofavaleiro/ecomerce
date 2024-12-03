import controller.ProductController;
import entity.Product;
import repository.ProductRepositoryImpl;
import response.Response;
import service.ProductService;
import javax.swing.*;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        Product product;
        ProductController productController = new ProductController(new ProductService(new ProductRepositoryImpl()));
        Set<Product> listaProduct;


        int opcao= 0;

        while (opcao != 6) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Listar todos os produtos");
            System.out.println("2. Buscar produto por ID");
            System.out.println("3. Adicionar novo produto");
            System.out.println("4. Atualizar produto");
            System.out.println("5. Remover produto");
            System.out.println("6. Sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:

                    Response<Set<Product>> resposta = productController.getProducts();
                    listaProduct = resposta.getData();


                    for (Product product1 : listaProduct){
                        System.out.println(product1);
                    }

                    break;
                case 2:
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Qual é o ID do produto desejado?"));


                    Response<Product> product2 = productController.getProductById(id);


                    System.out.println(product2);

                    break;
                case 3:

                    product = new Product();

                    //product.setId(Integer.parseInt(JOptionPane.showInputDialog("Qual é o ID do Produto?")));
                    product.setCompanyId(1);
                    product.setCodeId(1);
                    product.setProductName("nome");
                    product.setValue(3.30);
                    product.setProductType("produto");
                    product.setProductDescription("descição");
                    product.setProductImage("c:");
                    product.setCreationDate(new Date(2021-01-03));
                    productController.addProduct(product);



                    break;
                case 4:

                    int id4 = Integer.parseInt(JOptionPane.showInputDialog("Qual é o ID do produto desejado?"));

                        System.out.println(productController.getProductById(id4).getData());

                        product = new Product();

                        product.setId(productController.getProductById(id4).getData().getId());
                        product.setCompanyId(productController.getProductById(id4).getData().getCompanyId());
                        product.setCodeId(productController.getProductById(id4).getData().getCodeId());
                        product.setProductName(productController.getProductById(id4).getData().getProductName());//nem precisava desse só fiz por fazer
                        product.setValue(productController.getProductById(id4).getData().getValue());
                        product.setProductType(productController.getProductById(id4).getData().getProductType());
                        product.setProductDescription(productController.getProductById(id4).getData().getProductDescription());
                        product.setProductImage(productController.getProductById(id4).getData().getProductImage());
                        product.setCreationDate(productController.getProductById(id4).getData().getCreationDate());

                        product.setProductName("produto foi atualizado");

                        productController.updateProduct(product); //aqui atualiza o produto
                        System.out.println("Produto atualizado");
                        System.out.println(productController.getProductById(id4).getData());

                    break;
                case 5:
                    int id5 = Integer.parseInt(JOptionPane.showInputDialog("Qual é o ID do produto que deseja remover?"));
                    productController.deleteProduct(id5);

                    break;
                case 6:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }scanner.close();
    }
}

