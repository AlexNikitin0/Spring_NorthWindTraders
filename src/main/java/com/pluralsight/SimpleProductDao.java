package com.pluralsight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SimpleProductDao implements ProductDao{

    private ArrayList<Product> products;
    @Autowired
    public SimpleProductDao(){
        this.products = new ArrayList<>();
        Product apple = new Product(1,"Apple",13,3.25);
        Product cocaCola = new Product(2,"Coca-Cola",1,2.50);
        products.add(cocaCola);
        products.add(apple);
    }


    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public ArrayList<Product> getAll() {

        ArrayList<Product> prodList = new ArrayList<>();
        for(Product prod : products){
            prodList.add(prod);
        }

       return prodList;
    }
}
