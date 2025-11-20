package org.example;

public class ReadabilityAnalyzer {
    public static ReadabilityResult analyzerReadability(String input) {
        int sentenceCount = countSentences(input);
        int wordCount = countWords(input);
        int syllableCount = countSyllables(input);

        double averageWordsPerSentence = (double) wordCount / (double) sentenceCount;
        double averageSyllablePerWord = (double) syllableCount / (double) wordCount;
        double fleshScore = 206.835 - (1.015 * averageWordsPerSentence) - (84.6 * averageSyllablePerWord);
        ReadingLevel level = determineReadingLevel(fleshScore);

        return new ReadabilityResult(fleshScore, level, sentenceCount, wordCount, syllableCount,
                averageWordsPerSentence, averageSyllablePerWord);
    }
    public static int countSentences(String input) {
        return input.split("[.!?]").length;
    }

    public static int countWords(String input) {
        return input.split("\\s+").length;
    }
    public static int countSyllables(String input) {
        String[] words = input.split("\\s+");
        int total = 0;
        for (String word : words) {
            total += countSyllablesInWord(word);
        }
        return total;
    }

    public static int countSyllablesInWord(String input) {
        input = input.toLowerCase().replaceAll("[^a-zA-Z]", "");
        String vowels = "aeiouAEIOU";
        boolean preVowel = false;
        int count = 0;

        for (char c : input.toCharArray()) {
            boolean isVowel = vowels.indexOf(c) >= 0;
            if (isVowel && !preVowel) {
                count++;
            }
            preVowel = isVowel;
        }
        if (input.endsWith("e") && count > 1) count--;
        return Math.max(count, 1);
    }

    public static ReadingLevel determineReadingLevel(double score) {
        if(score >= 90) return ReadingLevel.VERY_EASY;
        else if (score >= 80) return ReadingLevel.EASY;
        else if (score >= 70) return ReadingLevel.FAIRLY_EASY;
        else if (score >= 60) return ReadingLevel.STANDARD;
        else if (score >= 50) return ReadingLevel.FAIRLY_DIFFICULT;
        else if (score >= 30) return ReadingLevel.DIFFICULT;
        else return ReadingLevel.VERY_DIFFICULT;
    }
}
