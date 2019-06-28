package com.cydio.cusip;

import java.math.BigDecimal;

public class CusipClosing {

    private final String name;
    private final BigDecimal closingPrice;

    public CusipClosing(String name, BigDecimal closingPrice) {
        this.name = name;
        this.closingPrice = closingPrice;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getClosingPrice() {
        return closingPrice;
    }


}
