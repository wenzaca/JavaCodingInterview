package com.interview.ex19_vendingmachine.enums;

public enum Coin {
    PENNY, NICKEL, DIME, QUARTER;

    public static Double calculate(Coin coin) {
        Double received = 0d;
        switch (coin) {
            case DIME:
                received += 10;
                break;
            case PENNY:
                received += 1;
                break;
            case NICKEL:
                received += 5;
                break;
            case QUARTER:
                received += 25;
                break;
        }
        return received;
    }
}
