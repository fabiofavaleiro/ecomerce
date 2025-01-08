package com.fabiovaleiro;

import com.fabiovaleiro.controller.ProductController;
import com.fabiovaleiro.controller.ProductControllerInterface;
import com.fabiovaleiro.controller.ProxyFactoryJDK;
import com.fabiovaleiro.entity.Product;
import com.fabiovaleiro.repository.impl.ProductRepositoryImplDB;
import com.fabiovaleiro.response.Response;
import com.fabiovaleiro.service.ProductService;
import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Application {
    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        Product product;
        ProductControllerInterface productController = new ProductController(new ProductService(new ProductRepositoryImplDB()));
        ProductControllerInterface proxyProductController = ProxyFactoryJDK.createProxy(
                productController, ProductControllerInterface.class);
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

                    Response<Set<Product>> resposta = proxyProductController.getProducts();
                    listaProduct = resposta.getData();

                    for (Product product1 : listaProduct){
                        System.out.println(product1);
                    }

                    break;
                case 2:
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Qual é o ID do produto desejado?"));


                    Response<Product> resposta2 = proxyProductController.getProductById(id);
                    product = resposta2.getData();

                    System.out.println(product);

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
                    product.setCreationDate( LocalDateTime.parse("2021-01-03T12:16:03"));
                    Response<Void> voidResponse = proxyProductController.addProduct(product);

                    if (voidResponse.getError() != null){

                        switch (voidResponse.getError().getStatusCode()){
                            case 500:
                                System.out.println("Caro usuario, problema interno, por favor tente novamente mais tarde");
                                break;
                        }
                    }

                    break;
                case 4:

                    int id4 = Integer.parseInt(JOptionPane.showInputDialog("Qual é o ID do produto desejado?"));

                        System.out.println(proxyProductController.getProductById(id4).getData());

                        product = new Product();

                        product.setId(proxyProductController.getProductById(id4).getData().getId());
                        product.setCompanyId(proxyProductController.getProductById(id4).getData().getCompanyId());
                        product.setCodeId(proxyProductController.getProductById(id4).getData().getCodeId());
                        product.setProductName(proxyProductController.getProductById(id4).getData().getProductName());//nem precisava desse só fiz por fazer
                        product.setValue(proxyProductController.getProductById(id4).getData().getValue());
                        product.setProductType(proxyProductController.getProductById(id4).getData().getProductType());
                        product.setProductDescription(proxyProductController.getProductById(id4).getData().getProductDescription());
                        product.setProductImage(proxyProductController.getProductById(id4).getData().getProductImage());
                        product.setCreationDate(proxyProductController.getProductById(id4).getData().getCreationDate());

                        product.setProductName("produto foi atualizado");

                        proxyProductController.updateProduct(product); //aqui atualiza o produto
                        System.out.println("Produto atualizado");
                        System.out.println(proxyProductController.getProductById(id4).getData());

                    break;
                case 5:
                    int id5 = Integer.parseInt(JOptionPane.showInputDialog("Qual é o ID do produto que deseja remover?"));
                    proxyProductController.deleteProduct(id5);

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

