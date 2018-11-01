package com.ksy;

import java.util.Arrays;
import java.util.StringJoiner;

/* https://www.codewars.com/kata/5898b4b71d298e51b600014b */

public class SortWords {    // sortTheInnerContent

    public static String sortByJoinerAndNewBuilder(String words) {
        String[] wordsArray = words.split("\\s");

        StringJoiner result = new StringJoiner(" ");

        for (String word : wordsArray) {
            if (word.length() < 4) {
                result.add(word);
                continue;
            }

            StringBuilder sortedWordBuilder = new StringBuilder();
            char[] literals = word.toCharArray();
            Arrays.sort(literals, 1, literals.length - 1);
            sortedWordBuilder.append(literals[0]);
            for (int i = literals.length - 2; i >= 1; i--) {
                sortedWordBuilder
                        .append(literals[i]);
            }
            result.add(sortedWordBuilder
                    .append(literals[literals.length - 1]).toString());
        }
        return result.toString();
    }
}