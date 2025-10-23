package org.example;

public class moneyConverter {
    public static double convertUSDtoEUR(double usd){
        if (usd < 0) {
            throw new IllegalArgumentException("USD should not be negative");
        }
        double eur = usd * 0.92;
        return Math.round(eur * 100.0) / 100.0;
    }
}
