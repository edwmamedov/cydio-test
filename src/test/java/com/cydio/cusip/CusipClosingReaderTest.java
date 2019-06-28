package com.cydio.cusip;

import org.junit.Test;

import java.io.File;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class CusipClosingReaderTest {

    @Test
    public void testRead() throws Exception {

        CusipClosingReader cusipReader = new CusipClosingReader();

        Map<String, Double> result = cusipReader.read(new File(getClass().getClassLoader().getResource("cusip-test.txt").getFile()));

        assertThat(result.size(), equalTo(5));

        assertThat(result.get("WG0DSTQG"), equalTo(5675.94));
        assertThat(result.get("2RJKCZ1Q"), equalTo(7791.49));
        assertThat(result.get("WCLTP7GE"), equalTo(4138.04));
        assertThat(result.get("KN6X44OU"), equalTo(3298.56));
        assertThat(result.get("YJ0ZJNT9"), equalTo(542.85));

    }
}
