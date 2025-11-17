package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class textAnalyzer {
    private final Calculator calculator;
    private final stringProcessor stringProcessor;

    private static final Set<String> POSITIVE_WORDS = new HashSet<>(Arrays.asList(
            "good", "great", "wonderful", "amazing", "fantastic", "happy", "positive"
    ));
    private static final Set<String> NEGATIVE_WORDS = new HashSet<>(Arrays.asList(
            "bad", "terrible", "awful", "horrible", "sad", "negative"
    ));
    public textAnalyzer(Calculator calculator, stringProcessor stringProcessor) {
        this.calculator = calculator;
        this.stringProcessor = stringProcessor;
    }

    public SentimentResult analyzeSentiment(String text) {
        String[] words = text.toLowerCase().split("\\s+");

        int positiveCount = 0;
        int negativeCount = 0;

        for(String word : words) {
            if(POSITIVE_WORDS.contains(word)) {
                positiveCount++;
            }
            else if(NEGATIVE_WORDS.contains(word)) {
                negativeCount++;
            }
        }

        double score = positiveCount -  negativeCount;
        SentimentResult.SentimentCategory category;
        if(score > 0) {
            category = SentimentResult.SentimentCategory.POSITIVE;
        } else if(score < 0) {
            category = SentimentResult.SentimentCategory.NEGATIVE;
        } else  {
            category = SentimentResult.SentimentCategory.NEUTRAL;
        }

        return new SentimentResult(score, category, positiveCount, negativeCount);
    }
}
