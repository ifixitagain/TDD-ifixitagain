package org.example;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class moneyConverter {

    private static final BigDecimal EXCHANGE_RATE = new BigDecimal("0.92");
    private static final BigDecimal USD_TO_SEK_RATE = new BigDecimal("10.50");


    public static BigDecimal convertUsdToEur(BigDecimal usd) {
        if (usd.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("USD amount cannot be negative");
        }

        BigDecimal eur = usd.multiply(EXCHANGE_RATE);
        // Round to 2 decimal places
        return eur.setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal convertEurToUsd(BigDecimal eur) {
        if (eur.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("EUR amount cannot be negative");
        }
        BigDecimal usd = eur.divide(EXCHANGE_RATE, 2,  RoundingMode.HALF_UP);
        return usd;
    }

    public static BigDecimal conversionUSDtoSEK(BigDecimal usd) {
        if (usd.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("USD amount cannot be negative");
        }
        BigDecimal sek = usd.multiply(USD_TO_SEK_RATE);
        return sek.setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal conversionSEKtoUSD(BigDecimal sek) {
        if (sek.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("SEK amount cannot be negative");
        }
        BigDecimal usd = sek.divide(USD_TO_SEK_RATE, 2, RoundingMode.HALF_UP);
        return  usd.setScale(2, RoundingMode.HALF_UP);
    }
}
