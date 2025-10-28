package org.example;

public class timeConverter {
    public static int convertSecondsToMinutes(int seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("seconds cannot be negative");
        }
        return seconds / 60;
    }
}
