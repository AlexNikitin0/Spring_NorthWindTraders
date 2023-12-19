package com.pluralsight;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.pluralsight.SimpleProductDao;

import java.util.Scanner;
@SpringBootApplication
public class NorthWindApplication implements CommandLineRunner{
    static Scanner keyboard = new Scanner(System.in);

    private JdbcProductDao jdbcProductDao;

  public  NorthWindApplication(JdbcProductDao jdbcProductDao){
        this.jdbcProductDao = jdbcProductDao;
    }

    @Override
    public void run(String... args) throws Exception {



    String choice;
        do {

    System.out.println("1. List Products");
    System.out.println("2. Add Product");
    choice = keyboard.nextLine();
    if (choice.equalsIgnoreCase("1")) {
        jdbcProductDao.getAll().forEach(System.out::println);

    } else if (choice.equalsIgnoreCase("2")) {
        int id;
        String name;
        int category;
        double price;
        System.out.println("Enter the product ID: ");
        id = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Enter the Product Name: ");
        name = keyboard.nextLine();
        System.out.println("Enter the Product Category: ");
        category = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Enter the Price: ");
        price = keyboard.nextDouble();
        keyboard.nextLine();
        Product p = new Product(id, name, category, price);
        jdbcProductDao.add(p);

    }

}while(!choice.equalsIgnoreCase("0"));

        }
    }

