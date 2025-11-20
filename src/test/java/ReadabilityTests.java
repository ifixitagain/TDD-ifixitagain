import org.example.ReadabilityAnalyzer;
import org.example.ReadabilityResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Readability Analysis Tests")
public class ReadabilityTests {
    @Nested
    @DisplayName("flesh score calculation")
    class FleshScoreCalculationTests {
        @Test
        @DisplayName("should calculate flesh reading ease correctly")
        void shouldCalculateFleshReadingEaseCorrectly() {
            String input = "Cats jump high and fast.";
            ReadabilityResult result = ReadabilityAnalyzer.analyzerReadability(input);
            assertEquals(206.835 - (1.015 * 5.0) - (84.6 * 1.0), result.getFleshScore(), 0.1);
        }
    }
}
