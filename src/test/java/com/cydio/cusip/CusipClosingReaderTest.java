package com.cydio.cusip;

import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class CusipClosingReaderTest {

    @Test
    public void testRead() throws Exception {

        CusipClosingReader cusipReader = new CusipClosingReader();

        Map<String, BigDecimal> result = cusipReader.read(new File(getClass().getClassLoader().getResource("cusip-test.txt").getFile()));

        assertThat(result.size(), equalTo(5));

        assertThat(result.get("WG0DSTQG"), equalTo(new BigDecimal("5675.94")));
        assertThat(result.get("2RJKCZ1Q"), equalTo(new BigDecimal("7791.49")));
        assertThat(result.get("WCLTP7GE"), equalTo(new BigDecimal("4138.04")));
        assertThat(result.get("KN6X44OU"), equalTo(new BigDecimal("3298.56")));
        assertThat(result.get("YJ0ZJNT9"), equalTo(new BigDecimal("542.85")));

    }
}
