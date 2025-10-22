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
}
