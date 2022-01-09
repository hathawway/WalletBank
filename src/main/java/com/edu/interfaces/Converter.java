package com.edu.interfaces;


public interface Converter {
    double convert(double amount, String from, String to);
    void addCurrency(String currency);
}
