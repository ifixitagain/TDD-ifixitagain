package org.example;

public class timeConverter {
    public static double convertSecondsToMinutes(double seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("seconds cannot be negative");
        }
        return seconds / 60;
    }
    public static double convertMinutesToSeconds(double minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Minutes cannot be negative");
        }
        return minutes * 60;
    }
    public static double convertMinutesToHours(double minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Minutes cannot be negative");
        }
        return minutes / 60;
    }
    public static double convertHoursToMinutes(double hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("Hours cannot be negative");
        }
        return hours * 60;
    }
    public static double convertHoursToDays(double days) {
        if (days < 0) {
            throw new IllegalArgumentException("days cannot be negative");
        }
        return days / 24;
    }    public static double convertDaysToHours(double days) {
        if (days < 0) {
            throw new IllegalArgumentException("Hours cannot be negative");
        }
        return days * 24;
    }
}
