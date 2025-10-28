import org.example.Calculator;
import org.example.timeConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class timeConverterTest {

    @Nested
    @DisplayName("Time converter tests")
    class timeconvertertests{

    @DisplayName("should convert 60 seconds to 1 minute")
    public void secondsToMinutes(){
        int seconds = 60;
        int expectedMinutes = 1;
        int actualMinutes = timeConverter.convertSecondsToMinutes(seconds);
        assertEquals(expectedMinutes, actualMinutes);
    }
    }
}
