package com.ksy;

/* http://www.codewars.com/kata/5279f6fe5ab7f447890006a7/train/java */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PickPeaks {

    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        Map<String, List<Integer>> peaks = new HashMap<>();
        List<Integer> peaksPosition = new ArrayList<>();
        List<Integer> valueOfPeaks = new ArrayList<>();

        for (int current = 1; current < arr.length - 1; current++) {

            if (arr[current] > arr[current - 1] && arr[current] >= arr[current + 1]) {
                if (arr[current] > arr[current + 1]) {
                    peaksPosition.add(current);
                    valueOfPeaks.add(arr[current]);
                } else {
                    for (int i = current; i < arr.length - 1; i++) {
                        if (arr[i] < arr[i + 1]) break;
                        if (arr[i] > arr[i + 1]) {
                            peaksPosition.add(current);
                            valueOfPeaks.add(arr[current]);
                            break;
                        }
                    }
                }
            }
        }

        peaks.put("pos", peaksPosition);
        peaks.put("peaks", valueOfPeaks);

        return peaks;
    }
}