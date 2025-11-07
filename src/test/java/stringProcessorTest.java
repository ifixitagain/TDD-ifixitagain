
import org.example.stringProcessor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
            assertTrue(processor.isPalindrome("racecar"), "palindrome detected");
        }
        @Test
        @DisplayName("should detect non palindrome")
        public void nonPalindromeTest(){
            stringProcessor processor = new stringProcessor();
            assertFalse(processor.isPalindrome("hello"), "non palindrome detected");
        }
        @Test
        @DisplayName("shold handle case insensitive palindromes")
        public void caseSensitivePalindromeTest(){
            stringProcessor processor = new stringProcessor();
            assertTrue(processor.isInsensitivePalindrome("rAcecaR"), "palindrome detected");
        }
        @Test
        @DisplayName("should handle palindromes with spaces")
        public void palindromeWithSpacesTest(){
            stringProcessor processor = new stringProcessor();
            assertTrue(processor.isSpacesPalindrome("Tre erT"), "Palindrome detected");
        }
        /*@DisplayName("should handle single character as palindrome")
        @DisplayName("should handle null and empty as palindromes")*/
    }
}
