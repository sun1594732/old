package com.test.testdemo.Bean;

/**
 * Created by wubin on 2017/3/1.
 */

public class CompanyBean {
    private String name;
    private String count;
    private String rate;
    private String type;

    public CompanyBean(String name, String count, String rate,String type) {
        this.name = name;
        this.count = count;
        this.rate = rate;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
