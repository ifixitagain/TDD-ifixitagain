package org.example;

public class stringProcessor {
    public String reverse(String input){
        if(input == null){
            return null;
        }
        return new StringBuilder(input).reverse().toString();
    }
    public boolean isPalindrome(String input){
        if(input == null){
            return false;
        }
        String reversed = reverse(input);
        return input.equals(reversed);
    }
    public boolean isInsensitivePalindrome(String input){
        if(input == null){
            return false;
        }
        String normalizeed = input.toLowerCase();
        String reversed = reverse(normalizeed);
        return normalizeed.equals(reversed);
    }
    public boolean isSpacesPalindrome(String input){
        if(input == null){
            return false;
        }
        String normalizeed = input.replaceAll("\\s+", "");
        String reversed = reverse(normalizeed);
        return normalizeed.equals(reversed);
    }
}
