package com.edu.model;


public class MoneyPrinter {

    public void print(String operation, String currency, double amount) {
        System.out.println(String.format("Пользователь совершил операцию '%s' в валюте %d на сумму %d", operation, currency, amount));
    }
}
