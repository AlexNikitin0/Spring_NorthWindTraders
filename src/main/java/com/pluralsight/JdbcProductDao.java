package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
@Component
public class JdbcProductDao implements ProductDao{

    private ArrayList<Product> products;
    private DataSource dataSource;
    @Autowired
    public JdbcProductDao(DataSource basicdataSource){
        this.products = new ArrayList<>();
        this.dataSource = basicdataSource;
    }

    @Override
    public void add(Product product) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO products(ProductID, ProductName, UnitPrice) VALUES(?,?,?)")){
            statement.setInt(1,product.getProductId());
            statement.setString(2,product.getName());
            statement.setDouble(3,product.getPrice());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }




    }

    @Override
    public ArrayList<Product> getAll() {
        ArrayList<Product> products = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM products")) {

            while(resultSet.next()){
                Product p = new Product(
                        resultSet.getInt("ProductID"),
                        resultSet.getString("ProductName"),
                        resultSet.getInt("CategoryID"),
                        resultSet.getDouble("UnitPrice")
                );
                products.add(p);
            }

    }catch (SQLException e){
            e.printStackTrace();
        }

        return products;
}
    }