import org.example.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class calculatorTest
{

@Test
public void testAddTwoPositiveNumbers()
{
    int  a=10;
    int b=20;
    int expectedSum = 30;

    int actualSum = Calculator.add(a,b);
    assertEquals(expectedSum, actualSum);
}

@Test
    public void testSubtractnumbers()
{
    int  a=10;
    int  b=5;
    int expectedSum = 5;

    int actualSum = Calculator.subtract(a,b);
    assertEquals(expectedSum, actualSum);
}

@Test
    public void testDivideNumbers()
{
    int  a=10;
    int  b=5;
    int expectedSum = 2;

    int actualSum = Calculator.divide(a,b);
    assertEquals(expectedSum, actualSum);
}

@Test
    public void testMultiplication()
{
    int  a=10;
    int  b=2;
    int expectedSum = 20;

    int actualSum = Calculator.multiply(a,b);
    assertEquals(expectedSum, actualSum);
}
}
