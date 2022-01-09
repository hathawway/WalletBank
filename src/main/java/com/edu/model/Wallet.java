package com.edu.model;

import com.edu.interfaces.Converter;

import java.util.*;

public class Wallet {
    private HashMap<String, Summary> money;
    private Converter bank;

    private MoneyPrinter printer;
    public Wallet() {
        bank = new Bank();
        bank.addCurrency("RUB");
        bank.addCurrency("USD");
        money = new HashMap<>();
        printer = new MoneyPrinter();
    }

    public Wallet(Converter converter) {
        money = new HashMap<>();
        bank = converter;

        printer = new MoneyPrinter();
    }

    public void addMoney(String currency, double amount) {
        printer.print("Зачисление", currency, amount);
        Summary mon = money.get(currency);
        if (mon == null) {
            mon = new Summary();
            money.put(currency, mon);
        }
        mon.Add(amount);
    }

    public double removeMoney(String currency, double amount) {
        printer.print("Списание", currency, amount);
        Summary s = money.get(currency);
        if (s == null) {
            return 0;
        }

        if (amount > s.getAmount()) {
            return 0;
        }

        s.remove(amount);
        return s.getAmount();
    }

    public double getMoney(String currency) {
        Summary s = money.get(currency);
        if (s == null) {
            return 0;
        }
        return s.getAmount();
    }

    public double getTotalMoney(String currency) {
        int d = 0;
        for(String s : money.keySet()){
            if (s.equals(currency)) {
                d += money.get(s).getAmount()*100;
            } else {

                d += bank.convert(money.get(s).getAmount(), s, currency)*100;
            }
        }
        return d/100.00;
    }

    @Override
    public String toString(){
        ArrayList<String> keys = new ArrayList<>(money.size());
        keys.addAll(money.keySet());

        Collections.sort(keys);

        StringBuilder s = new StringBuilder("{ ");

        for(String key: keys) {
            s.append(money.get(key).getAmount()).append(" ").append(key).append(", ");
        }

        s.delete(s.length()-2, s.length()-1);
        s.append("}");
        return s.toString();
    }
}
