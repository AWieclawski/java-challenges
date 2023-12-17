package edu.awieclawski.extremeword;

import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

/**
 * Service to find and compare only alphanumerical words
 */
@NoArgsConstructor
public class WordsService {

    public String findLongestWord(String sentence) {
        String longest = "";
        int length = Integer.MIN_VALUE;
        String regex = "^[a-zA-Z0-9]+$";
        String[] splited = splitSentenceToArray(sentence);
        for (String word : splited) {
            word = removeExtremesNonAlphanumeric(word);
            if (Pattern.matches(regex, word) && length < word.length()) {
                length = word.length();
                longest = word;
            }
        }
        return longest;
    }

    public String findShortestWord(String sentence) {
        String shortest = "";
        int length = Integer.MAX_VALUE;
        String regex = "^[a-zA-Z0-9]+$";
        String[] splited = splitSentenceToArray(sentence);
        for (String word : splited) {
            word = removeExtremesNonAlphanumeric(word);
            if (Pattern.matches(regex, word) && (length > word.length())) {
                length = word.length();
                shortest = word;
            }
        }
        return shortest;
    }

    private String removeExtremesNonAlphanumeric(String str) {
        str = str.replaceAll("^[^a-zA-Z0-9\\s]+|[^a-zA-Z0-9\\s]+$", "");
        return str;
    }

    private String[] splitSentenceToArray(String sentence) {
        return sentence != null ? sentence.split("\\s+") : new String[0];
    }

}
