
import org.example.timeConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class timeConverterTest {

    @Nested
    @DisplayName("Time converter tests seconds to moinutes")
    class convertSecondstoMinutes{

        @Test
    @DisplayName("should convert 60 seconds to 1 minute")
    public void secondsToMinutes(){
        int seconds = 60;
        int expectedMinutes = 1;
        double actualMinutes = timeConverter.convertSecondsToMinutes(seconds);
        assertEquals(expectedMinutes, actualMinutes);
    }
        @Test
        @DisplayName("Should convert 120 seconds to 2 minutes")
        public void minutesTo120Seconds(){
            assertEquals(2.0, timeConverter.convertSecondsToMinutes(120));
        }
        @Test
        @DisplayName("Should convert 90 seconds to 1.5 minutes")
        public void minutesTo900Seconds(){
            assertEquals(1.5, timeConverter.convertSecondsToMinutes(90));
        }
        @Test
        @DisplayName("Should throw excpetion for negative seconds")
        public void negativeSeconds(){
            assertThrows(IllegalArgumentException.class, () -> timeConverter.convertSecondsToMinutes(-1));
        }
    }
    @Nested
    @DisplayName("Time converter minutes to seconds")
    class convertMinutestoSeconds{
        @Test
        @DisplayName("Should convert 1 minute to 60 seconds")
        public void minutesTo60Seconds(){
            assertEquals(60, timeConverter.convertMinutesToSeconds(1.0));
        }
        @Test
        @DisplayName("Should convert 2.5 minutes to 150 seconds")
        public void minutesTo150Seconds(){
            assertEquals(150, timeConverter.convertMinutesToSeconds(2.5));
        }
        @Test
        @DisplayName("Should maintain value through round-trip conversion")
        public void maintainValueThroughRoundTripConversion(){
            double minutes = 60;
            double seconds = timeConverter.convertMinutesToSeconds(minutes);
            double convertedSeconds = timeConverter.convertSecondsToMinutes(seconds);
            assertEquals(minutes, convertedSeconds);
        }
    }
    @Nested
    @DisplayName("Time converter minutes to hours")
    class convertMinutesToHours{
        @Test
        @DisplayName("should convert 60 minutes to 1 hour")
        public void minutesTo60Hours(){
            assertEquals(1.0, timeConverter.convertMinutesToHours(60));
        }
        @Test
        @DisplayName("Should convert 120 minutes to 2 hours")
        public void minutesTo120Hours(){
            assertEquals(2.0, timeConverter.convertMinutesToHours(120));
        }
        @Test
        @DisplayName("Should convert 90 minutes to 1.5 hours")
        public void minutesTo900Hourss(){
            assertEquals(1.5, timeConverter.convertMinutesToHours(90));
        }
    }
    @Nested
    @DisplayName("Hours to minutes conversion")
    class convertHoursToMinutes{
        @Test
        @DisplayName("should convert 1 hour to 60 minutes")
        public void hourTo60Minutes(){
            assertEquals(60, timeConverter.convertHoursToMinutes(1));
        }
        @Test
        @DisplayName("Should convert 2.5h to 150min")
        public void hourTo150Minutes(){
            assertEquals(150, timeConverter.convertHoursToMinutes(2.5));
        }
        @Test
        @DisplayName("Should maintain value trough round trip conversion")
        public void maintainValueTroughRoundTripConversion(){
            double hours = 2.5;
            double minutes = timeConverter.convertMinutesToHours(hours);
            double convertedMinutes = timeConverter.convertHoursToMinutes(minutes);
            assertEquals(hours, convertedMinutes);
        }
    }
    @Nested
    @DisplayName("Hours to days conversion")
    class convertHoursToDays{
        @Test
        @DisplayName("Should convert 24h to 1 day")
        public void dayTo24h(){
            assertEquals(1, timeConverter.convertHoursToDays(24));
        }
        @Test
        @DisplayName("should convert 48h to 2 days")
        public void dayTo48h(){
            assertEquals(2, timeConverter.convertHoursToDays(48));
        }
        @Test
        @DisplayName("should convert 12h to 0.5days")
        public void dayTo12h(){
            assertEquals(0.5, timeConverter.convertHoursToDays(12));
        }
    }
    @Nested
    @DisplayName("should convert days to hours")
    class convertDaysToHours{
        @Test
        @DisplayName("should convert 1 day to 24h")
        public void daysTo24h(){
            assertEquals(24, timeConverter.convertDaysToHours(1));
        }
        @Test
        @DisplayName("should convert 7 days to 168h")
        public void daysTo168h(){
            assertEquals(168, timeConverter.convertDaysToHours(7));
        }
    }
}
