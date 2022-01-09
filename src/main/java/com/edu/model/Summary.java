package com.edu.model;

public class Summary {

    public int Main;
    public int Sub;

    public Summary(){
        Main = 0;
        Sub = 0;
    }

    public Summary(double amount){
        Main = (int) amount;
        Sub = (int) (amount*100%100);
    }

    public Summary(int Main, int Sub){
        this.Main = Main;
        this.Sub = Sub;
    }

    public void Add(double amount) {
        Main += (int) amount;
        Sub += (int) (amount*100%100);
    }

    public double getAmount() {
        return (100*Main+Sub)/100.00;
    }

    public void remove(double amount) {
        if (getAmount() < amount) {
            return;
        }

        Main -= (int) amount;
        Sub -= (amount*100)%100;

    }
}
