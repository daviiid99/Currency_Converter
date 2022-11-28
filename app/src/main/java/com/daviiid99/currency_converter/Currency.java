package com.daviiid99.currency_converter;

public class Currency {

    protected double euroValor = 0.97;
    protected double dolarValor = 1.04;
    protected double amount;
    protected String type;

    public Currency(double amount, String type){
        this.amount = amount;
        this.type = type;
    }

    public double euroToDolar(){
        return (double)Math.round((amount * dolarValor) * 100000d)/100000d;
    }

    public double dolarToEuro(){
        return (double)Math.round((amount * euroValor) * 100000d)/100000d;
    }
}
