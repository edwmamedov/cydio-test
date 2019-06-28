package com.cydio.problem2;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Util {

    private Util() {}

    public static List<Pair<Integer, Integer>> findDistinctPairsEqualsTo(int[] numbers, int equalTo) {
        List<Pair<Integer, Integer>> result = new LinkedList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == equalTo) {
                    Pair<Integer, Integer> pair = Pair.of(numbers[i], numbers[j]);

                    if (!result.contains(pair) && !result.contains(reverse(pair)) && !pair.getLeft().equals(pair.getRight())) {
                        result.add(pair);
                    }
                }
            }
        }

        System.out.println("Pairs found: " + result.stream().map(Pair::toString).collect(joining(",")) +
                " for array " + Arrays.toString(numbers) + "; the sum of any pair is " + equalTo);

        return result;
    }

    private static Pair<?, ?> reverse(Pair<?, ?> p) {
        return Pair.of(p.getRight(), p.getLeft());
    }
}
