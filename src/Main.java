import controller.ProductController;
import entity.Product;
import repository.ProductRepository;
import repository.ProductRepositoryImpl;
import service.ProductService;

import javax.swing.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Product product = new Product();
        ProductRepository productRepository = new ProductRepositoryImpl();
        ProductService productService = new ProductService(new ProductRepositoryImpl());
        ProductController productController = new ProductController();
        Set<Product> listaProduct;





        product.setId(1);
        product.setCompanyId(1);
        product.setCodeId(1);
        product.setProductName("nome do produto");
        product.setValue(3.30);
        product.setProductType("tipo do produto");
        product.setProductDescription("muito bom");
        product.setProductImage("c:");
        product.setCreationDate(new Date(2024-05-06));
        productController.addProduct(product);
        product = new Product();
        product.setId(2);
        productController.addProduct(product);
        product = new Product();
        product.setId(3);
        productController.addProduct(product);
        product = new Product();
        product.setId(4);
        productController.addProduct(product);


        int opcao = 0;



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
                    listaProduct = productController.getProducts();

                    for (Product product1 : listaProduct){
                        System.out.println(product1);
                    }

                    break;
                case 2:
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Qual é o ID do produto desejado?"));
                    product = productController.getProductById(id);
                    System.out.println(product);

                    break;
                case 3:
                    product = new Product();
                    product.setId(Integer.parseInt(JOptionPane.showInputDialog("Qual é o ID do Produto?")));
                    product.setCompanyId(Integer.parseInt(JOptionPane.showInputDialog("Qual é o ID da Companhia?")));
                    product.setCodeId(Integer.parseInt(JOptionPane.showInputDialog("Qual é o ID do codigo?")));
                    product.setProductName(JOptionPane.showInputDialog("Qual é o nome do Produto?"));
                    product.setValue(Double.valueOf(JOptionPane.showInputDialog("Qual é o valor do produto?")));
                    product.setProductType(JOptionPane.showInputDialog("Qual é o tipo do produto?"));
                    product.setProductDescription(JOptionPane.showInputDialog("Qual é a descrição do produto?"));
                    product.setProductImage("c:");
                    product.setCreationDate(new Date(2024-05-06));
                    productController.addProduct(product);

                    break;
                case 4:
                    // Pedir as informações do produto a ser atualizado e chamar o método updateProduct(product) da classe ProductController
                    break;
                case 5:
// Pedir o id do produto que quer remover e chamar o metodo apropriado do controle
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