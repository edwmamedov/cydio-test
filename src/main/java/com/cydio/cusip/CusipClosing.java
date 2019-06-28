package com.cydio.cusip;

public class CusipClosing {

    private final String name;
    private final Double closingPrice;

    public CusipClosing(String name, Double closingPrice) {
        this.name = name;
        this.closingPrice = closingPrice;
    }

    public String getName() {
        return name;
    }

    public Double getClosingPrice() {
        return closingPrice;
    }


}
