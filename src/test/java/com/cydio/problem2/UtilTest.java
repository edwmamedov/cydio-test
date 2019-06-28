package com.cydio.problem2;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class UtilTest {

    @Test
    public void testFindDistinctPairsEqualsTo() {

        List<Pair<Integer, Integer>> result = Util.findDistinctPairsEqualsTo(new int[]{1,2,3,4,5,6}, 7);

        System.out.println("Pairs found: " + result.stream().map(Pair::toString).collect(Collectors.joining(",")));


        assertThat(result.size(), equalTo(3));

        result.forEach(pair -> {
            assertThat(pair.getLeft() + pair.getRight(), equalTo(7));
        });



        result = Util.findDistinctPairsEqualsTo(new int[]{2,4,3,7,1,6}, 8);

        assertThat(result.size(), equalTo(2));

        result.forEach(pair -> {
            assertThat(pair.getLeft() + pair.getRight(), equalTo(8));
        });

        System.out.println("Pairs found: " + result.stream().map(Pair::toString).collect(Collectors.joining(",")));

    }
}