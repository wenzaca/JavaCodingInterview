package com.interview.amazon.ex19_vendingmachine.service;

import com.interview.amazon.ex19_vendingmachine.entity.Product;
import com.interview.amazon.ex19_vendingmachine.repository.Repository;

import java.util.List;

public class VendingMachineService {

    static Repository repository;

    public VendingMachineService() {
        repository = new Repository();
    }

    public Product getProduct(String name) {
        return repository.getProduct(name);
    }

    public void removeProduct(Product product) {
        repository.removeProduct(product);
    }


    public void addProduct(Product product) {
        repository.addProduct(product);
    }

    public void resetMachine() {
        repository = new Repository();
    }

    public Double getChange(Double paid, Double price) {
        return paid - price;
    }

    public List<Product> getProducts() {
        return repository.getProducts();
    }
}
