package com.ksy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

import static java.lang.Integer.parseInt;
import static java.util.Objects.requireNonNull;

/* https://www.codewars.com/kata/55c6126177c9441a570000cc */

public class WeightSort {
    static String orderWeight(String string) {
        List<WeightUnit> units = new ArrayList<>();
        for (String source : string.split("\\s")) { units.add(new WeightUnit(source)); }

        Collections.sort(units);

        StringJoiner joiner = new StringJoiner(" ");
        for (WeightUnit unit : units) { joiner.add(unit.sourceWeight); }

        return joiner.toString();
    }


    private static class WeightUnit implements Comparable<WeightUnit> {
        private final String sourceWeight;
        private final int evaluated;

        private WeightUnit(String sourceWeight) {
            this.sourceWeight = requireNonNull(sourceWeight);

            int weight = 0;

            for (char numeric : sourceWeight.toCharArray()) {
                weight += parseInt(String.valueOf(numeric));
            }

            evaluated = weight;
        }

        @Override
        public int compareTo(WeightUnit o) {
            int compare = Integer.compare(evaluated, o.evaluated);
            return compare == 0 ? sourceWeight.compareTo(o.sourceWeight) : compare;
        }
    }
}
