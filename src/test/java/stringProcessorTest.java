
import org.example.stringProcessor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @Nested
    @DisplayName("Word Count Tests")
    class WordCountTests {
        @Test
        @DisplayName("should count words in simple sentence")
        public void simpleSentenceTest(){
            String input = "Hello World";
            int result = stringProcessor.countWords(input);
            assertEquals(2, result);
        }
        @Test
        @DisplayName("should handle multiple spaces between words")
        public void multipleSpacesBetweenWordsTest(){
            String input = "Hello    World    Makkipakki";
            int result = stringProcessor.countWords(input);
            assertEquals(3, result);
        }
        @Test
        @DisplayName("should handle leading and trailing spaces")
        public void leadingAndTrailingSpacesTest(){
            String input = "        Hello World        ";
            int result = stringProcessor.countWords(input);
            assertEquals(2, result);
        }
        @Test
        @DisplayName("should count single word")
        public void singleWordTest(){
            String input = "World";
            int result = stringProcessor.countWords(input);
            assertEquals(1, result);
        }
        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = {" ", "   ", "\t", "\n"})
        @DisplayName("should return zero for null or whitespace only strings")
        public void emptyStringTest(String input){
            input = "";
            int result = stringProcessor.countWords(input);
            assertEquals(0, result);
        }
    }
    @Nested
    @DisplayName("Input validation")
    class InputValidationTests {
        @Test
        @DisplayName("should validate email fromat")
        public void emailFromatTest(){
            assertTrue(stringProcessor.isValidEmail("john@doe.com"));
            assertTrue(stringProcessor.isValidEmail("makki.pakki@rynnakko.fi"));
        }
        @Test
        @DisplayName("should reject invalid email format")
        public void invalidEmailFormatTest(){
            assertFalse(stringProcessor.isValidEmail("makkipakki"));
            assertFalse(stringProcessor.isValidEmail("@rynnakko.fi"));
        }
        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("should reject null and emppty emails (string)")
        public void nullAndEmptyEmailsTest(String input){
            assertFalse(stringProcessor.isValidEmail(input));
        }
    }
    @Nested
    @DisplayName("string manipulation tests")
    class StringManipulationTests {
        @Test
        @DisplayName("should capitalize each world correcctly")
        public void capitalizeEachWorkdTest(){
            String input = "Hello world";
            String result = stringProcessor.capitalizeWords(input);
            assertEquals("Hello World", result);
        }
        @Test
        @DisplayName("should handle multiple spaces and trim")
        public void multipleSpacesAndTrimTest(){
            String input = "   Hello      world";
            String result = stringProcessor.capitalizeWords(input);
            assertEquals("Hello World", result);
        }
        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("should return empty string for null or empty string")
        public void emptyStringTest(String input){
            assertEquals("", stringProcessor.capitalizeWords(null));
            assertEquals("", stringProcessor.capitalizeWords(""));
            assertEquals("", stringProcessor.capitalizeWords("   "));
        }
        @Test
        @DisplayName("should only capitalize first letter")
        public void capitalizeFirstLetterTest(){
            String input = "HEllo WoRld";
            String result = stringProcessor.capitalizeWords(input);
            assertEquals("Hello World", result);
        }
    }
    @Nested
    @DisplayName("substring searching")
    class SubstringSearchingTests {
        @Test
        @DisplayName("should detect substring correctly")
        public void substringSearchingTest(){
            assertTrue(stringProcessor.containgSubstring("Hello World", "World"));
            //case sensitive
            assertFalse(stringProcessor.containgSubstring("Hello world", "World"));
        }
        @Test
        @DisplayName("should return false for null")
        public void nullTest() {
            assertFalse(stringProcessor.containgSubstring(null, "abc"));
            assertFalse(stringProcessor.containgSubstring("abc", null));
            assertFalse(stringProcessor.containgSubstring("", "abc"));
            assertFalse(stringProcessor.containgSubstring("abc", ""));
        }
        @Test
        @DisplayName("should find substring at beginning middle and end")
        public void findSubstringAtBeginningMiddleAndEndTest(){
            assertTrue(stringProcessor.containgSubstring("Hello World", "Hello"));
            assertTrue(stringProcessor.containgSubstring("Hello World", "lo Wo"));
            assertTrue(stringProcessor.containgSubstring("Hello World", "World"));
        }
    }
    @Nested
    @DisplayName("Remove duplicates")
    class RemoveDuplicatesTests {
        @Test
        @DisplayName("should remove duplicate characters")
        public void removeDuplicatesTest(){
            String input = stringProcessor.removeDupe("banana");
            assertEquals("ban", input);
        }
        @Test
        @DisplayName("should handle all unique characters")
        public void handleAllUniqueCharactersTest(){
            String result = stringProcessor.removeDupe("abcdef");
            assertEquals("abcdef", result);
        }
        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("should return empty string for null")
        public void emptyStringTest(String input){
            assertEquals("", stringProcessor.removeDupe(input));
        }
    }
    @Nested
    @DisplayName("advanced validation")
    class AdvancedValidationTests {
        @Test
        @DisplayName("should validate correct phone number")
        public void validateCorrectPhoneNumberTest(){
            assertTrue(stringProcessor.validatePhoneNum("+45 1234 567"));
            assertTrue(stringProcessor.validatePhoneNum("045-1234567"));
            assertTrue(stringProcessor.validatePhoneNum("0451234567"));
        }
        @Test
        @DisplayName("should reject incorrect phone numbers")
        public void rejectCorrectPhoneNumberTest(){
            assertFalse(stringProcessor.validatePhoneNum("123"));
            assertFalse(stringProcessor.validatePhoneNum("abcd"));
            assertFalse(stringProcessor.validatePhoneNum("01a4567"));
        }
        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("should reject null or empty phone num")
        public void rejectNullPhoneNumberTest(String input){
            assertFalse(stringProcessor.validatePhoneNum(input));
        }
    }
    @Nested
    @DisplayName("URL validation")
    class URLValidationTests {
        @Test
        @DisplayName("should validate correct url")
        public void validateCorrectUrlTest(){
            assertTrue(stringProcessor.validateURL("http://makkipakki.com"));
            assertTrue(stringProcessor.validateURL("https://www.makkipakki.com"));
            assertTrue(stringProcessor.validateURL("https://sub.makkipakki.org/path?query=456"));
        }
        @Test
        @DisplayName("should reject invalid urls")
        public void rejectInvalidUrlsTest(){
            assertFalse(stringProcessor.validateURL("htt:/makkipakki.com"));
            assertFalse(stringProcessor.validateURL("makkipakki"));
            assertFalse(stringProcessor.validateURL("www.makkipakki"));
        }
        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("should reject empty url")
        public void rejectEmptyUrlTest(String input){
            assertFalse(stringProcessor.validateURL(input));
        }
    }
    @Nested
    @DisplayName("performance and edge case tests")
    class PerformanceEdgeCaseTests {
        @Test
        @DisplayName("should handle very long strings")
        public void handleVeryLongStringsTest(){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10000; i++) {
                sb.append("Hello ");
            }
            String longString = sb.toString().trim();
            int count = stringProcessor.countWords(longString);
            assertEquals(10000, count);
        }
        @Test
        @DisplayName("special symbols and unicode")
        public void specialSymbolsTest(){
            String input = "Hello World \uD83D\uDC4B";
            String result = stringProcessor.capitalizeWords(input);
            assertEquals("Hello World \uD83D\uDC4B", result);
        }
        @Test
        @DisplayName("should handle whitespaces")
        public void handleWhitespacesTest(){
            String input = "hello\tWorld\nmakki \tpakki";
            int count = stringProcessor.countWords(input);
            assertEquals(4, count);
        }
        @Test
        @DisplayName("performance tests for large palindromes")
        public void largePalindromeTest(){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 50000; i++) {
                sb.append("abcde");
            }
            String largePalindrome = sb.toString() + sb.reverse().toString();
            long start = System.currentTimeMillis();
            String result = stringProcessor.removeDupe(largePalindrome);
            long duration  = System.currentTimeMillis() - start;

            assertEquals("abcde", result);
            assertTrue(duration < 1000, "Performance test took too long: " +  duration + "ms");
        }
    }
}
