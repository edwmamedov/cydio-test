package com.cydio.problem2;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class UtilTest {

    @Test
    public void findDistinctPairsEqualsTo() {

        List<Pair<Integer, Integer>> result = Util.findDistinctPairsEqualsTo(new int[]{1,2,3,4,5,6}, 7);

        assertThat(result.size(), equalTo(3));

        result.forEach(pair -> {
            assertThat(pair.getLeft() + pair.getRight(), equalTo(7));
        });
    }
}