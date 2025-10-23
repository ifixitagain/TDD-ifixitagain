import org.example.moneyConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Moneyconverter TDD test demo")
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
        @DisplayName("Should thow exception for negative numbers")
        public void testConvertNegativeException() {
            BigDecimal usd = new BigDecimal("-1");

        }
    }

}
