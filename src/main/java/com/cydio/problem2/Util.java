package com.cydio.problem2;

import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedList;
import java.util.List;

public class Util {

    private Util() {}

    public static List<Pair<Integer, Integer>> findDistinctPairsEqualsTo(int[] numbers, int equalTo) {
        List<Pair<Integer, Integer>> result = new LinkedList<>();
        for (int left = 0; left < numbers.length + 1; left++) {
            for (int right = 0; right < numbers.length + 1; right++) {
                if (left + right == equalTo) {
                    Pair<Integer, Integer> pair = Pair.of(left, right);

                    if (!result.contains(pair) && !result.contains(reverse(pair))) {
                        result.add(pair);
                    }
                }
            }
        }
        return result;
    }

    private static Pair<?, ?> reverse(Pair<?, ?> p) {
        return Pair.of(p.getRight(), p.getLeft());
    }
}
