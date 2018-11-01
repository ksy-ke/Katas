package com.ksy;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/* https://www.codewars.com/kata/5547cc7dcad755e480000004 */

public class RemovedNumbers {
    public static List<long[]> removNb(long n) {
        double sum = n * (n + 1) / 2;

        List<long[]> res = new ArrayList<>();
        for (long i = 1; i <= n; i++) {
            double required = (sum - i) / (i + 1);
            if (required % 1 == 0 && required <= n) {
                res.add(new long[]{i, (long) required});
            }
        }

        System.out.println("Incoming value: " + n);
        showResult(res);

        return res;
    }

    private static void showResult(List<long[]> result) {
        if (result == null) {
            System.out.println("Null result");
            return;
        }

        List<String> evaluated = new ArrayList<>();
        for (long[] pair : result) {
            StringJoiner pairBuilder = new StringJoiner(", ", "[", "]");
            for (long value : pair) { pairBuilder.add(String.valueOf(value)); }
            evaluated.add(pairBuilder.toString());
        }

        System.out.println("Result pairs are: " + evaluated);
    }
}
