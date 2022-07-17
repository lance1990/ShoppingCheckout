package com.lance.shoppingc_checkout.config;

import com.lance.shoppingc_checkout.domain.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingList {

    public static List<Product> shoppingCart1 = Arrays.asList(
            new Product("book",17.99,1,"CA"),
            new Product("potato chips",3.99,1,"CA")
    );
    public static List<Product> shoppingCart2 = Arrays.asList(
            new Product("book",17.99,1,"NY"),
            new Product("pencils",2.99,	3,"NY")
    );
    public static List<Product> shoppingCart3 = Arrays.asList(
            new Product("pencils",2.99,2,"NY"),
            new Product("shirt",29.99,1,"NY")
    );

    public static List<Product> myList(){
        ArrayList al = new ArrayList();
        al.add(shoppingCart1);
        al.add(shoppingCart2);
        al.add(shoppingCart3);
        return al;
    }
}
