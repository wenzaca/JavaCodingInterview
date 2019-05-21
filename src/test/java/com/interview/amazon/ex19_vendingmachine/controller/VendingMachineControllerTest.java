package com.interview.amazon.ex19_vendingmachine.controller;

import com.interview.amazon.ex19_vendingmachine.entity.Product;
import com.interview.amazon.ex19_vendingmachine.enums.Coin;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class VendingMachineControllerTest {

    @Test
    public void buyProduct() {
        System.out.println("=======Test Buy Product======");
        VendingMachineController controller = new VendingMachineController();
        controller.putProduct("Coke", 25d);
        controller.putProduct("Soda", 35d);
        controller.putProduct("Pepsi", 45d);
        controller.putProduct("Coke", 25d);

        controller.insertCash(Coin.QUARTER);
        controller.insertCash(Coin.QUARTER);
        Assert.assertTrue(controller.buyProduct("Coke"));
        System.out.println("=======End of test=======\n");
    }

    @Test
    public void buyProductUntilThereIsNone() {
        System.out.println("=======Test Buy Product Until None======");
        VendingMachineController controller = new VendingMachineController();
        controller.putProduct("Coke", 25d);
        controller.putProduct("Soda", 35d);
        controller.putProduct("Pepsi", 45d);
        controller.putProduct("Coke", 25d);

        controller.insertCash(Coin.QUARTER);
        Assert.assertTrue(controller.buyProduct("Coke"));
        controller.insertCash(Coin.QUARTER);
        Assert.assertTrue(controller.buyProduct("Coke"));
        controller.insertCash(Coin.QUARTER);
        Assert.assertFalse(controller.buyProduct("Coke"));
        System.out.println("=======End of test=======\n");
    }

    @Test
    public void buyProductNotEnoughMoney() {
        System.out.println("=======Test Not Enough money======");
        VendingMachineController controller = new VendingMachineController();
        controller.putProduct("Coke", 25d);
        controller.putProduct("Soda", 35d);
        controller.putProduct("Pepsi", 45d);
        controller.putProduct("Coke", 25d);

        Assert.assertFalse(controller.buyProduct("Coke"));
        System.out.println("=======End of test=======\n");
    }

    @Test
    public void buyProductNotEnoughProduct() {
        System.out.println("=======Test Not Enough Product======");
        VendingMachineController controller = new VendingMachineController();
        controller.putProduct("Coke", 25d);
        controller.putProduct("Soda", 35d);

        Assert.assertFalse(controller.buyProduct("Pepsi"));
        System.out.println("=======End of test=======\n");
    }

    @Test
    public void insertCash() {
        System.out.println("=======Test Insert Cash======");
        VendingMachineController controller = new VendingMachineController();
        controller.insertCash(Coin.QUARTER);
        Assert.assertThat(controller.paid, is(25d));
        controller.insertCash(Coin.DIME);
        Assert.assertThat(controller.paid, is(35d));
        controller.insertCash(Coin.PENNY                );
        Assert.assertThat(controller.paid, is(36d));
        controller.insertCash(Coin.NICKEL);
        Assert.assertThat(controller.paid, is(41d));
        System.out.println("=======End of test=======\n");
    }

    @Test
    public void putProduct() {
        System.out.println("=======Test Put Product======");
        VendingMachineController controller = new VendingMachineController();
        controller.putProduct("Coke", 25d);
        controller.putProduct("Soda", 35d);
        controller.putProduct("Pepsi", 45d);
        controller.putProduct("Coke", 25d);
        Assert.assertThat(controller.getProduct("Coke"), is(new Product("Coke", 25d)));
        Assert.assertThat(controller.getProduct("Pepsi"), is(new Product("Pepsi", 45d)));
        Assert.assertThat(controller.getProduct("Soda"), is(new Product("Soda", 35d)));
        System.out.println("=======End of test=======\n");
    }

    @Test
    public void resetVendingMachine() {
        System.out.println("=======Test Reset Vending Machine======");
        VendingMachineController controller = new VendingMachineController();
        controller.putProduct("Coke", 25d);
        controller.putProduct("Soda", 35d);
        controller.resetVendingMachine();
        Assert.assertThat(controller.getProducts(), is(new ArrayList()));
        System.out.println("=======End of test=======\n");
    }

    @Test
    public void cashBack() {
        System.out.println("=======Test Cash Back======");
        VendingMachineController controller = new VendingMachineController();
        controller.insertCash(Coin.QUARTER);
        Assert.assertThat(controller.paid, is(25d));
        controller.cashBack();
        Assert.assertThat(controller.paid, is(0d));
        System.out.println("=======End of test=======\n");
    }


    @Test
    public void getProducts() {
        System.out.println("=======Test Get Products======");
        VendingMachineController controller = new VendingMachineController();
        Product coke = new Product("Coke", 25d);
        Product pepsi = new Product("Pepsi", 45d);
        Product soda = new Product("Soda", 35d);
        controller.putProduct("Coke", 25d);
        controller.putProduct("Soda", 35d);
        controller.putProduct("Pepsi", 45d);
        controller.putProduct("Coke", 25d);
        List<Product> products = new ArrayList<>();
        products.add(coke);
        products.add(soda);
        products.add(pepsi);
        products.add(coke);
        Assert.assertThat(controller.getProducts(), is(products));
        System.out.println("=======End of test=======\n");
    }
}