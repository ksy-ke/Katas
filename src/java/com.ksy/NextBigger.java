package com.ksy;

/* https://www.codewars.com/kata/55983863da40caa2c900004e */

import java.util.Arrays;

import static java.lang.Character.getNumericValue;

public class NextBigger {
    private char[] numeral;

    long nextBiggerNumber(long passedNumber) {

        numeral = Long.toString(passedNumber).toCharArray();

        for (int current = numeral.length - 1; current > 0; current--) {
            if (getNumericValue(numeral[current]) > getNumericValue(numeral[current - 1])) {
                swapNextWithMin(current);
                Arrays.sort(numeral, current, numeral.length);
                return Long.parseLong(new String(numeral));
            }
        }

        return -1;
    }

    private void swapNextWithMin(int current) {
        for (int early = numeral.length - 1; early >= current; early--) {
            if (getNumericValue(numeral[current - 1]) < getNumericValue(numeral[early])) {
                swap(current - 1, early);
                break;
            }
        }
    }

    private void swap(int current, int early) {
        char temp = numeral[current];
        numeral[current] = numeral[early];
        numeral[early] = temp;
    }
}
