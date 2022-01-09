package com.edu.model;

import com.edu.interfaces.Converter;

import java.util.HashSet;
import java.util.Random;

public class Bank implements Converter {

    private HashSet<String> currencies;

    public Bank() {
        currencies = new HashSet<>();
    }

    public void addCurrency(String c) {
        currencies.add(c);
    }

    public double convert(double amount, String from, String to) {
        if (from.equals(to)) {
            return amount;
        }
        Random rnd = new Random();
        int delta = (int) (rnd.nextFloat()*100);
        return (amount*delta)/100.00;
    }
}
