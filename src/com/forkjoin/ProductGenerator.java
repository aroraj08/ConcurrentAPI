package com.forkjoin;

import java.util.ArrayList;
import java.util.List;

public class ProductGenerator {

    private static List<Product> productList = new ArrayList<>();

    public static List<Product> getProducts(int productsToGenerate) {

        for (int i = 0; i<productsToGenerate;i++) {
            Product p = new Product("product " + i, 10);
            productList.add(p);
        }
        return productList;
    }
}
