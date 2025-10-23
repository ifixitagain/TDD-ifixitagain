package org.example;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class moneyConverter {

    private static final BigDecimal EXCHANGE_RATE = new BigDecimal("0.92");

    public static BigDecimal convertUsdToEur(BigDecimal usd) {
        if (usd.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("USD amount cannot be negative");
        }

        BigDecimal eur = usd.multiply(EXCHANGE_RATE);
        return eur.setScale(2, RoundingMode.HALF_UP); // Round to 2 decimal places
    }

}
