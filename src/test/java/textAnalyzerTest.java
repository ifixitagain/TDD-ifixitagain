import org.example.Calculator;
import org.example.SentimentResult;
import org.example.stringProcessor;
import org.example.textAnalyzer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

        @Test
        @DisplayName("should analyze neutral sentiment correctly")
        void shouldAnalyzeNeutralPositiveSentimentCorrectly() {
            String input = "This is an ok string output";
            SentimentResult result = textAnalyzer.analyzeSentiment(input);

            assertNotNull(result);
            assertEquals(SentimentResult.SentimentCategory.NEUTRAL, result.getSentimentCategory());
            assertEquals(0, result.getSentimentScore());
            assertEquals(0, result.getPositiveWordCount());
            assertEquals(0, result.getNegativeWordCount());
        }
        @Test
        @DisplayName("should analyze negative sentiment input")
        void shouldAnalyzeNegativePositiveSentimentInput() {
            String input = "This is a bad string output";
            SentimentResult result = textAnalyzer.analyzeSentiment(input);

            assertEquals(SentimentResult.SentimentCategory.NEGATIVE, result.getSentimentCategory());
            assertTrue(result.getSentimentScore() < 0);
            assertEquals(0, result.getPositiveWordCount());
            assertTrue(result.getNegativeWordCount() > 0);
        }
        @ParameterizedTest(name = "{index} => text=''{0}'', expected={1}")
        @CsvSource({
                "'This is happy and good', POSITIVE",
                "'This is sad and bad', NEGATIVE",
                "'This is Finnish and normal', NEUTRAL"
        })
        @DisplayName("should classify sentiment categories correctly")
        void shouldClassifySentimentCategoriesCorrectly(String text, SentimentResult.SentimentCategory expectedCategory){
            SentimentResult result = textAnalyzer.analyzeSentiment(text);
            assertEquals(expectedCategory, result.getSentimentCategory());
        }
        @Test
        @DisplayName("should handle empty text in sentiment analysis")
        void shouldHandleEmptyTextInSentimentAnalysis() {
            String input = "";
            SentimentResult result = textAnalyzer.analyzeSentiment(input);

            assertNotNull(result);
            assertEquals(SentimentResult.SentimentCategory.NEUTRAL, result.getSentimentCategory());
            assertEquals(0, result.getSentimentScore());
            assertEquals(0, result.getPositiveWordCount());
            assertEquals(0, result.getNegativeWordCount());
        }
    }
}
