
import org.example.stringProcessor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.*;

public class stringProcessorTest {

    @Nested
    @DisplayName("String processor tests")
    class StringProcessorTests {
        @Test
        @DisplayName("should reverse a simple string")
        public void simpleStringTest(){
            stringProcessor processor = new stringProcessor();
            String result = processor.reverse("Hello");
            assertEquals("olleH", result);
        }
        @Test
        @DisplayName("Should handle a single character")
        public void singleCharacterTest(){
            stringProcessor processor = new stringProcessor();
            String result = processor.reverse("A");
            assertEquals("A", result);
        }
        @Test
        @DisplayName("should handle null or emppty strings")
        public void emptyStringTest(){
            stringProcessor processor = new stringProcessor();
            String result = processor.reverse("");
            assertEquals("", result);
        }
        @Test
        @DisplayName("should preserve spaces in reversal")
        public void spacesPreservedTest(){
            stringProcessor processor = new stringProcessor();
            String result = processor.reverse("a b c");
            assertEquals("c b a", result);
        }
    }
    @Nested
    @DisplayName("palindrome detection tests")
    class PalindromeDetectionTests {
        @Test
        @DisplayName("should detect simple palindrome")
        public void simplePalindromeTest(){
            stringProcessor processor = new stringProcessor();
            assertTrue(processor.isPalindrome("racecar"));
        }
        @Test
        @DisplayName("should detect non palindrome")
        public void nonPalindromeTest(){
            stringProcessor processor = new stringProcessor();
            assertFalse(processor.isPalindrome("hello"));
        }
        @Test
        @DisplayName("shold handle case insensitive palindromes")
        public void caseSensitivePalindromeTest(){
            stringProcessor processor = new stringProcessor();
            assertTrue(processor.isInsensitivePalindrome("rAcecaR"));
        }
        @Test
        @DisplayName("should handle palindromes with spaces")
        public void palindromeWithSpacesTest(){
            stringProcessor processor = new stringProcessor();
            assertTrue(processor.isSpacesPalindrome("Tre erT"));
        }
        @Test
        @DisplayName("should handle single character as palindrome")
        public void singleCharacterAsPalindromeTest(){
            stringProcessor processor = new stringProcessor();
            assertTrue(processor.isSpacesPalindrome("T"));
        }
        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("should handle null and empty as palindromes")
        public void emptyAsPalindromeTest(String input){
            stringProcessor processor = new stringProcessor();
            assertTrue(processor.isPalindrome(input));
        }
    }
    @Nested
    @DisplayName("String compression")
    class StringCompressionTests {
        @Test
        @DisplayName("should compress repeated characters")
        public void repeatedCharactersTest(){
            assertEquals("a2b1c3a5", stringProcessor.compress("aabcccaaaaa"));
        }
        @Test
        @DisplayName("should return original if compression dont reduce length")
        public void compressionDontReduceLengthTest(){
            assertEquals("a1b1c1", stringProcessor.compress("abc"));
        }
        @Test
        @DisplayName("should handle single character compression")
        public void singleCharacterCompressionTest(){
            assertEquals("a1", stringProcessor.compress("a"));
        }
        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("should handle null and empty strings in compression")
        public void emptyCompressionTest(String input){
            assertEquals(input, stringProcessor.compress(input));
        }
    }
}
