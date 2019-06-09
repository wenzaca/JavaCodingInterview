package com.interview.ex19_vendingmachine.controller;

import com.interview.ex19_vendingmachine.entity.Product;
import com.interview.ex19_vendingmachine.enums.Coin;
import com.interview.ex19_vendingmachine.service.VendingMachineService;

import java.util.List;

public class VendingMachineController {

    VendingMachineService service;
    Double paid = 0d;

    public VendingMachineController() {
        this.service = new VendingMachineService();
    }

    public Boolean buyProduct(String name) {
        Product product = service.getProduct(name);
        if (product != null) {
            Double change = service.getChange(paid, product.getPrice());
            if (change < 0) {
                System.out.println("Not enough cash, insert more " + Math.abs(change));
                return false;
            } else {
                System.out.println("Enjoy your " + product.getName() + ". Here is your change " + change);
                paid = 0d;
                service.removeProduct(product);
                return true;
            }
        } else {
            System.out.println("We do not have this product");
            return false;
        }
    }

    public void insertCash(Coin coin) {
        paid += Coin.calculate(coin);
        System.out.println("Total value: " + paid);
    }

    public void putProduct(String name, Double price) {
        service.addProduct(new Product(name, price));
        return;
    }

    public void resetVendingMachine() {
        service.resetMachine();
    }

    public void cashBack() {
        System.out.println("Returning: " + paid);
        paid = 0d;
    }

    public Product getProduct(String name) {
        return service.getProduct(name);
    }

    public List<Product> getProducts() {
        return service.getProducts();
    }

}
