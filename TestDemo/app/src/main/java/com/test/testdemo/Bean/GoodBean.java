package com.test.testdemo.Bean;

/**
 * Created by wubin on 2017/3/1.
 */

public class GoodBean {
    private String GoodName;
    private String GoodPrice;

    public GoodBean(String goodName, String goodCount) {
        GoodName = goodName;
        GoodPrice = goodCount;
    }

    public String getGoodName() {
        return GoodName;
    }

    public void setGoodName(String goodName) {
        GoodName = goodName;
    }

    public String getGoodPrice() {
        return GoodPrice;
    }

    public void setGoodPrice(String goodPrice) {
        GoodPrice = goodPrice;
    }
}
