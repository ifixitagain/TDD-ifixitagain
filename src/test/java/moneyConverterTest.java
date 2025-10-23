import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Moneyconverter TDD test demo")
public class moneyConverterTest {

    @Nested
    @DisplayName("USD to EUR Conversion")

    class USDToEURConversion {

        @Test
        @DisplayName("Should convert 100 USD to 92 EUR")
        public void testConvert100USDTo92EUR() {
            double USD = 100.00;
            double expectedEUR = 92.00;
            double actualEUR = moneyConverter.convertUSDtoEUR(usd);
            assertEquals(expectedEUR, actualEUR, 0.001);
        }
    }

}
