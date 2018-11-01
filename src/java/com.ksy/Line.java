package com.ksy;

import java.util.HashMap;
import java.util.Map;

/* https://www.codewars.com/kata/555615a77ebc7c2c8a0000b8 */

public class Line {
    public static String Tickets(int[] peopleInLine) {
        String result = null;

        Map<Integer, Integer> cash = new HashMap<>();
        cash.put(25, 0);
        cash.put(50, 0);

        for (int current : peopleInLine) {
            if (current == 25) {
                cash.put(current, cash.get(current) + 1);
                result = "YES";
            } else {
                if (current == 50) {
                    if (cash.get(25) >= 1) {
                        cash.put(25, cash.get(25) - 1);
                        cash.put(current, cash.get(current) + 1);
                        result = "YES";
                    } else {
                        result = "NO";
                    }
                } else {
                    if (current == 100) {
                        if (cash.get(50) >= 1) {
                            if (cash.get(25) >= 1) {
                                cash.put(25, cash.get(25) - 1);
                                cash.put(50, cash.get(50) - 1);
                                result = "YES";
                            } else {
                                result = "NO";
                            }
                        } else {
                            if (cash.get(25) >= 3) {
                                cash.put(25, cash.get(25) - 3);
                                result = "YES";
                            } else result = "NO";
                        }
                    } else result = "NO";
                }
            }
        }
        return result;
    }
}