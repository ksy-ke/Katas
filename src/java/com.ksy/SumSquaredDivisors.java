package com.ksy;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/* https://www.codewars.com/kata/integers-recreation-one/java */

public class SumSquaredDivisors {
    static String listSquared(long m, long n) {
        StringJoiner result = new StringJoiner(", ", "[", "]");

        for (long operating = m; operating <= n; operating++) {
            double squared = poweredDivisors(operating);
            if (Math.sqrt(squared) % 1 == 0) { result.add("[" + operating + ", " + (int) squared + "]"); }
        }
        return result.toString();
    }

    private static double poweredDivisors(long operating) {
        double sum = 0;
        List<Long> divisors = new ArrayList<>();

        for (long i = 1; i <= operating; i++) {
            if (operating % i == 0) { divisors.add(i); }
        }

        for (long current : divisors) { sum += Math.pow(current, 2); }

        return sum;
    }
}
