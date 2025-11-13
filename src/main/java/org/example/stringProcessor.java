package org.example;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;
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
    public static int countWords(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        return input.trim().split("\\s+").length;
    }
    public static boolean isValidEmail(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
        return emailPattern.matcher(input).matches();
    }
    public static String capitalizeWords(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        String[] words = input.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if(!word.isEmpty()){
                sb.append(Character.toUpperCase(word.charAt(0)));
                if(word.length() > 1){
                    sb.append(word.substring(1).toLowerCase());
                }
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
    public static boolean containgSubstring(String input, String substring) {
        if (input == null || substring == null || input.isEmpty() || substring.isEmpty()) {
            return false;
        }
        return input.contains(substring);
    }

    public static String removeDupe(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        Set<Character> seen = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();
        for(char c : input.toCharArray()) {
            if(seen.add(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static boolean validatePhoneNum(String input){
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        Pattern phonePattern = Pattern.compile( "^(\\+\\d{1,3}[\\s-]?)?(0\\d{1,3}[\\s-]?)?(\\d{3,4}[\\s-]?\\d{3,4})$");
        return phonePattern.matcher(input.trim()).matches();
    }

    public static boolean validateURL(String input){
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        try {
            new URL(input.trim());
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }
}
