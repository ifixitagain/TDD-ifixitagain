
import org.example.moneyConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("money converter TDD test demo")
public class moneyConverterTest {

    @Nested
    @DisplayName("USD to EUR Conversion")

    class USDToEURConversion {

        @Test
        @DisplayName("Should convert 100 USD to 92 EUR")
        public void testConvert100Usd() {
            BigDecimal usd = new BigDecimal("100");
            BigDecimal expected = new BigDecimal("92.00");
            BigDecimal actual = moneyConverter.convertUsdToEur(usd);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Should convert 0 usd to 0 eur")
        public void testConvert0Usd() {
            BigDecimal usd = new BigDecimal("0");
            BigDecimal expected = new BigDecimal("0.00");
            BigDecimal actual = moneyConverter.convertUsdToEur(usd);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Should round result to 2 decimal places")
        public void testRoundingToTwoDecimals() {
            BigDecimal usd = new BigDecimal("123.456");
            BigDecimal expected = new BigDecimal("113.58");
            BigDecimal actual = moneyConverter.convertUsdToEur(usd);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Should throw exception for negative numbers")
        public void testConvertNegativeException() {
            BigDecimal usd = new BigDecimal("-1");
            assertThrows(IllegalArgumentException.class, () -> moneyConverter.convertUsdToEur(usd));
        }
       /* @Test
        public void validcatePositiveNumber(BigDecimal value) {
            if (value == null || moneyConverter.convertUsdToEur(BigDecimal.ZERO).compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException("Amount cannot be negative");}
        }*/
    }

    @Nested
    @DisplayName("EUR to USD Conversion")
    class EURtoUSDConvertion {

        @Test
        @DisplayName("Should convert 92 eur to 100 EUR")
        public void testConvert92Eur() {
            BigDecimal eur = new BigDecimal("92");
            BigDecimal expected = new BigDecimal("100.00");
            BigDecimal actual = moneyConverter.convertEurToUsd(eur);
            assertEquals(expected, actual);
        }
        @Test
        @DisplayName("Should maintain value through round-trip conversion")
        public void testRoundTripConversion() {
            BigDecimal originalUsd = new BigDecimal("100.00");
            BigDecimal eur = moneyConverter.convertUsdToEur(originalUsd);
            BigDecimal usdBack = moneyConverter.convertEurToUsd(eur);

            assertEquals(originalUsd, usdBack);
        }

    }
    @Nested
    @DisplayName("USD to SEK conversion")
    class USDtoSEKConversion {

        @Test
        @DisplayName("Should convert 100 USD to 1050 SEK")
        public void testConvert100UsdTosek() {
            BigDecimal usd = new BigDecimal("100");
            BigDecimal expected = new BigDecimal("1050.00");
            BigDecimal actualSek = moneyConverter.conversionUSDtoSEK(usd);
            assertEquals(expected, actualSek);
        }
        @Test
        @DisplayName("Should convert 10 USD to 105 SEK")
        public void testConvert10UsdTosek() {
            BigDecimal usd = new BigDecimal("10");
            BigDecimal expected = new BigDecimal("105.00");
            BigDecimal actualSek = moneyConverter.conversionUSDtoSEK(usd);
            assertEquals(expected, actualSek);
        }
    }

    @Nested
    @DisplayName("SEK to USD conversion")
    class SEKtoUSDConversion {

        @Test
        @DisplayName("Should convert 1050 SEK to 100 USD")
        public void testConvert1050SEK() {
            BigDecimal sek = new BigDecimal("1050");
            BigDecimal expected = new BigDecimal("100.00");
            BigDecimal actual = moneyConverter.conversionSEKtoUSD(sek);
            assertEquals(expected, actual);
        }
        @Test
        @DisplayName("Should maintain value through round-trip conversion")
        public void testRoundTripConversion() {
            BigDecimal originalUsd = new BigDecimal("1050.00");
            BigDecimal eur = moneyConverter.convertUsdToEur(originalUsd);
            BigDecimal usdBack = moneyConverter.convertEurToUsd(eur);

            assertEquals(originalUsd, usdBack);
        }
    }
    @Nested
    @DisplayName("Money Addition")
    class moneyAddition {
        @Test
        @DisplayName("Should add two money amounts")
        public void testMoneyAddition() {
            BigDecimal amountOne = new BigDecimal("25.00");
            BigDecimal amountTwo = new BigDecimal("13.00");
            BigDecimal expected = new BigDecimal("38.00");

            BigDecimal result = moneyAdd.add(amountOne, amountTwo);
            assertEquals(expected, result);
        }
    }
}
