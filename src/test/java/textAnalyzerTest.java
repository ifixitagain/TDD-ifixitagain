import org.example.Calculator;
import org.example.SentimentResult;
import org.example.stringProcessor;
import org.example.textAnalyzer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Complex TextAnalyzer TDD Demo")
public class textAnalyzerTest {
    private Calculator calculator;
    private stringProcessor stringProcessor;
    private textAnalyzer textAnalyzer;

    @BeforeEach
    void setUP(){
        calculator = new Calculator();
        stringProcessor = new stringProcessor();
        textAnalyzer = new textAnalyzer(calculator, stringProcessor);
    }

    @Nested
    @DisplayName("Sentiment Analysis Tests")
    class sentimentAnalysisTests {
        @Test
        @DisplayName("Should analyze positive sentiment correctly")
        void shouldAnalyzePositivePositiveSentimentCorrectly() {
            String input = "This is a good string output";
            SentimentResult result = textAnalyzer.analyzeSentiment(input);
            assertNotNull(result);
            assertEquals(SentimentResult.SentimentCategory.POSITIVE, result.getSentimentCategory());
            assertTrue(result.getSentimentScore() > 0);
            assertTrue(result.getPositiveWordCount() > 0);
            assertEquals(0, result.getNegativeWordCount());
        }
    }
}
