package com.fabiovaleiro.repository.impl;

import com.fabiovaleiro.config.ConfigFactory;
import com.fabiovaleiro.entity.Product;
import com.fabiovaleiro.repository.ProductRepository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class ProductRepositoryImplDB implements ProductRepository {

    protected  Set<Product> listProduct = new HashSet<>();
    protected  Product product;

    @Override
    public Product findById(int id) {

        String insertSQL = "select * from product where id = ?" ;

        try(Connection connection = DriverManager.getConnection(ConfigFactory.getConfig().getDbUrl(), ConfigFactory.getConfig().getDbUser(), ConfigFactory.getConfig().getDbPassword());
            PreparedStatement stmt = connection.prepareStatement(insertSQL);) {


            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setCompanyId(resultSet.getInt("company_id"));
                product.setCodeId(resultSet.getInt("code_id"));
                product.setProductName(resultSet.getString("product_name"));
                product.setValue(resultSet.getDouble("price"));
                product.setProductType(resultSet.getString("product_type"));
                product.setProductDescription(resultSet.getString("product_description"));
                product.setProductImage(resultSet.getString("product_image_url"));
                Timestamp timestamp = resultSet.getTimestamp("creation_date");
                product.setCreationDate(timestamp.toLocalDateTime());
                this.product = product;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return product;
    }

    @Override
    public Set<Product> findAll() {

        String insertSQL = "select * from product" ;

        try(Connection connection = DriverManager.getConnection(ConfigFactory.getConfig().getDbUrl(), ConfigFactory.getConfig().getDbUser(), ConfigFactory.getConfig().getDbPassword());
            PreparedStatement stmt = connection.prepareStatement(insertSQL);        ) {

            ResultSet resultSet = stmt.executeQuery();
            listProduct = new HashSet<>();

            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setCompanyId(resultSet.getInt("company_id"));
                product.setCodeId(resultSet.getInt("code_id"));
                product.setProductName(resultSet.getString("product_name"));
                product.setValue(resultSet.getDouble("price"));
                product.setProductType(resultSet.getString("product_type"));
                product.setProductDescription(resultSet.getString("product_description"));
                product.setProductImage(resultSet.getString("product_image_url"));
                Timestamp timestamp = resultSet.getTimestamp("creation_date");
                product.setCreationDate(timestamp.toLocalDateTime());
                listProduct.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listProduct;
    }

    @Override
    public void save(Product product) {


        String insertSQL = "INSERT INTO product (company_id, code_id, product_name, price, product_type, product_description, product_image_url, creation_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)" ;

        try(Connection connection = DriverManager.getConnection(ConfigFactory.getConfig().getDbUrl(), ConfigFactory.getConfig().getDbUser(), ConfigFactory.getConfig().getDbPassword());
            PreparedStatement stmt = connection.prepareStatement(insertSQL);

        ) {
            stmt.setInt(1, product.getCompanyId());
            stmt.setInt(2, product.getCodeId());
            stmt.setString(3, product.getProductName());
            stmt.setDouble(4, product.getValue());
            stmt.setString(5, product.getProductType());
            stmt.setString(6, product.getProductDescription());
            stmt.setString(7, product.getProductImage());
            stmt.setTimestamp(8, Timestamp.valueOf(product.getCreationDate()));

            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Product product) {
        String insertSQL = "UPDATE product SET company_id = ?, code_id = ?, product_name = ?, price = ?, product_type = ?, product_description = ?, product_image_url = ?, creation_date = ? WHERE id = ?" ;

        try(Connection connection = DriverManager.getConnection(ConfigFactory.getConfig().getDbUrl(), ConfigFactory.getConfig().getDbUser(), ConfigFactory.getConfig().getDbPassword());
            PreparedStatement stmt = connection.prepareStatement(insertSQL);

        ) {
            stmt.setInt(1, product.getCompanyId());
            stmt.setInt(2, product.getCodeId());
            stmt.setString(3, product.getProductName());
            stmt.setDouble(4, product.getValue());
            stmt.setString(5, product.getProductType());
            stmt.setString(6, product.getProductDescription());
            stmt.setString(7, product.getProductImage());
            stmt.setTimestamp(8, Timestamp.valueOf(product.getCreationDate()));
            stmt.setInt(9, product.getId());

            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {

        String insertSQL = "delete from product where id = ?" ;

        try(Connection connection = DriverManager.getConnection(ConfigFactory.getConfig().getDbUrl(), ConfigFactory.getConfig().getDbUser(), ConfigFactory.getConfig().getDbPassword());
            PreparedStatement stmt = connection.prepareStatement(insertSQL);
        ) {
            stmt.setInt(1, id);
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean exisThisID(int id) {
        for (Product product1: listProduct){
            if (product1.getId() == id){
                return true;
            }
        }
        return false;
    }
}
