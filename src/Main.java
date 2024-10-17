import controller.ProductController;
import entity.Product;
import repository.ProductRepositoryImpl;
import service.ProductService;
import javax.swing.*;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
//
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        Product product;
        ProductController productController = new ProductController(new ProductService(new ProductRepositoryImpl()));
        Set<Product> listaProduct;

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
                    System.out.println(productController.getProductById(id));

                    break;
                case 3:

                    product = new Product();

                    product.setId(Integer.parseInt(JOptionPane.showInputDialog("Qual é o ID do Produto?")));
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

                    System.out.println(productController.getProductById(id4));
                    String nameProduct = (JOptionPane.showInputDialog("Qual o nome que deseja para o Produto?"));
                    double valueProduct = (Double.valueOf(JOptionPane.showInputDialog("Qual o valor do produto?")));
                    productController.updateProduct(id4, nameProduct, valueProduct ); //aqui atualiza o produto
                    System.out.println("Produto atualizado");
                    System.out.println(productController.getProductById(id4));


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

                  /*  product.setId(Integer.parseInt(JOptionPane.showInputDialog("Qual é o ID do Produto?")));
        product.setCompanyId(Integer.parseInt(JOptionPane.showInputDialog("Qual é o ID da Companhia?")));
        product.setCodeId(Integer.parseInt(JOptionPane.showInputDialog("Qual é o ID do codigo?")));
        product.setProductName(JOptionPane.showInputDialog("Qual é o nome do Produto?"));
        product.setValue(Double.valueOf(JOptionPane.showInputDialog("Qual é o valor do produto?")));
        product.setProductType(JOptionPane.showInputDialog("Qual é o tipo do produto?"));
        product.setProductDescription(JOptionPane.showInputDialog("Qual é a descrição do produto?"));
        product.setProductImage(JOptionPane.showInputDialog("Qual é a o caminho da imagem do produto"));
        product.setCreationDate(new Date(JOptionPane.showInputDialog("Qual é a data do produto no padrão yyyy-MM-dd?")));*/