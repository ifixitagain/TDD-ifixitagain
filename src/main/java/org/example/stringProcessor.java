package org.example;

public class stringProcessor {
    public String reverse(String input) {
        if (input == null) {
            return null;
        }
        return new StringBuilder(input).reverse().toString();
    }

    public boolean isPalindrome(String input) {
        if (input == null) {
            return true;
        }
        String reversed = reverse(input);
        return input.equals(reversed);
    }

    public boolean isInsensitivePalindrome(String input) {
        if (input == null) {
            return false;
        }
        String normalizeed = input.toLowerCase();
        String reversed = reverse(normalizeed);
        return normalizeed.equals(reversed);
    }

    public boolean isSpacesPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String normalizeed = input.replaceAll("\\s+", "");
        String reversed = reverse(normalizeed);
        return normalizeed.equals(reversed);
    }

    public static String compress(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(input.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        compressed.append(input.charAt(input.length() - 1)).append(count);
        //return compressed.length() < input.length() ? compressed.toString() : input;
        return compressed.toString();
    }
}
