package org.example;

public class ReadabilityResult {
    private final double fleshScore;
    private final ReadingLevel readingLevel;
    private final int sentenceCount;
    private final int wordCount;
    private final int syllableCount;

    private final double averageWordPerSentence;
    private final double averageSyllablePerWord;

    public ReadabilityResult(double fleshScore, ReadingLevel readingLevel, int sentenceCount,
                             int wordCount, int syllableCount, double averageSyllablePerWord,
                             double averageWordPerSentence){
        this.fleshScore = fleshScore;
        this.readingLevel = readingLevel;
        this.sentenceCount = sentenceCount;
        this.wordCount = wordCount;
        this.syllableCount = syllableCount;
        this.averageWordPerSentence = averageWordPerSentence;
        this.averageSyllablePerWord = averageSyllablePerWord;
        }

        public double getFleshScore() {
        return fleshScore;
        }
        public ReadingLevel getReadingLevel() {
        return readingLevel;
        }
        public int getSenteceCount() {
        return sentenceCount;
        }
        public int getWordCount() {
        return wordCount;
        }
        public int getSyllableCount() {
        return syllableCount;
        }
        public double getAverageWordPerSentence() {
        return averageWordPerSentence;
        }
        public double getAverageSyllablePerWord() {
        return averageSyllablePerWord;
        }

        @Override
        public String toString() {
        return "ReadabilityResult{" + "fleshScore=" + fleshScore + ", readingLevel=" + readingLevel
                + ", senteceCount=" + sentenceCount + ", wordCount=" + wordCount
                + ", syllableCount=" + syllableCount + ", averageWordPerSentence="
                + averageWordPerSentence + ", averageSyllablePerWord="
                + averageSyllablePerWord + '}';
        }
}
