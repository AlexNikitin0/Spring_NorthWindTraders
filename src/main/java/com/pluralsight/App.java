package com.pluralsight;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.Scanner;
@SpringBootApplication
public class App
{

    public static void main( String[] args )
    {
        SpringApplication.run(NorthWindApplication.class, args);

        }

    }



