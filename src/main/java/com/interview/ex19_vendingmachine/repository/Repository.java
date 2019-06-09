package com.interview.ex19_vendingmachine.repository;

import com.interview.ex19_vendingmachine.entity.Product;
import com.interview.ex19_vendingmachine.entity.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    static VendingMachine vendingMachine;

    public Repository() {
        vendingMachine = new VendingMachine(new ArrayList<>());
    }

    public void addProduct(Product product) {
        vendingMachine.getProducts().add(product);
    }

    public Product getProduct(String name) {
        List<Product> products = vendingMachine.getProducts();
        if (products.isEmpty()) {
            return null;
        } else {
            Product prod = null;
            for (Product product : products) {
                if (product.getName().equals(name)) {
                    prod = product;
                }
            }
            return prod;
        }
    }

    public void removeProduct(Product product) {
        vendingMachine.getProducts().remove(product);
    }


    public List<Product> getProducts() {
        return vendingMachine.getProducts();

    }
}
