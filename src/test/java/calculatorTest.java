import org.example.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Documented;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class calculatorTest
{

    //Phase one
    @Test
    @DisplayName("Should add two positive numbers")
    public void testAddTwoPositiveNumbers() {
        int a = 10;
        int b = 20;
        int expectedSum = 30;
        int actualSum = Calculator.add(a, b);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    @DisplayName("Should add zero to a number.")
    public void testAddZeroToNumber() {
        int a = 15;
        int b = 0;
        int expectedSum = 15;
        int actualSum = Calculator.add(a, b);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    @DisplayName("Should add negative numbers.")
    public void testAddNegativeNumbers() {
        int a = -5;
        int b = -10;
        int expectedSum = -15;
        int actualSum = Calculator.add(a, b);
        assertEquals(expectedSum, actualSum);
    }

    //Phase two
    @Test
    @DisplayName("Should subtract two numbers")
    public void testSubtractnumbers()
{
    int  a=10;
    int  b=5;
    int expectedSum = 5;

    int actualSum = Calculator.subtract(a,b);
    assertEquals(expectedSum, actualSum);
}
    @Test
    @DisplayName("Should handle negative result in subtraction")
    public void testNegativeResultInSubtraction() {
        int a = 5;
        int b = 10;
        int expected = -5;
        int actual = Calculator.subtract(a, b);
        assertEquals(expected, actual);
    }

    //Phase three
@Test
@DisplayName("Should multiply two numbers")
    public void testMultiplication()
{
    int  a=10;
    int  b=2;
    int expectedSum = 20;

    int actualSum = Calculator.multiply(a,b);
    assertEquals(expectedSum, actualSum);
}

@Test
@DisplayName("Should return zero when multiplying by zero")
    public void testMultiplyZero()
{
    int  a=10;
    int  b=0;
    int expectedSum = 0;
    int actualSum = Calculator.multiply(a,b);

    assertEquals(expectedSum, actualSum);
}

    //Phase four
    @Test
    @DisplayName("Should divide two numbers")
    public void testDivideNumbers()
    {
        int  a=10;
        int  b=5;
        int expectedSum = 2;

        int actualSum = Calculator.divide(a,b);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    @DisplayName("Should handle decimal division.")
    public void testDecimalDivision() {
        double a = 7.0;
        double b = 2.0;
        double expected = 3.5;
        assertEquals(expected, Calculator.divide(a, b), 0.0001);
    }

    @Test
    @DisplayName("Should throw exception when dividing by zero")
    public void testDivideZero() {
        assertThrows(ArithmeticException.class, () -> Calculator.divide(0,0));
    }

    //Phase five
    @Test
    @DisplayName("Should calculate the power of a number")
    public void testCalculatePowerOfNumber() {
        int base = 2;
        int exponent = 3;
        int expected = 8;

        int actual = Calculator.power(base, exponent);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should handle the power of zero")
    public void testPowerZero() {
        int base = 2;
        int exponent = 0;
        int expected = 1;

        int actual = Calculator.power(base, exponent);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should calculate square root")
    public void testSquareRoot() {
        double input = 25.0;
        double expected = 5.0;
        double actual = Calculator.squareRoot(input);
        assertEquals(expected, actual, 0.0001);

    }
}
