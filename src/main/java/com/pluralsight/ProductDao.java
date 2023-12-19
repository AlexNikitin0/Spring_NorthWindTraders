package com.pluralsight;

import java.util.ArrayList;

public interface ProductDao {

    public void add(Product product);

    public ArrayList<Product>  getAll();


}
