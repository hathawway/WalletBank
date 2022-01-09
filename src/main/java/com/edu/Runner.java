package com.edu;

import com.edu.model.Bank;
import com.edu.model.Wallet;

public class Runner {

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addCurrency("RUB");
        bank.addCurrency("USD");
        Wallet w = new Wallet(bank);
        w.addMoney("RUB", 100.1);
    }
}
