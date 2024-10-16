package com.example.mitp2_wordcounter;

public class WordCounter {

    public static int getWordsCount(String text) {
        String[] words = text.trim().split("\\s+|,|\\.|;|!|\\?");
        return words.length;
    }

    public static int getPunctuationCount(String text) {
        int punctuationCount = 0;

        String punctuation = ".,;:!?()[]{}'\"-=`~|_/><@#$%^&*";

        for (char c : text.toCharArray()) {
            if (punctuation.indexOf(c) >= 0) {
                punctuationCount++;
            }
        }
        return punctuationCount;
    }
}
