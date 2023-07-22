package com.cancodelah.microservices.limitsservice.bean;

public class Limits {
    int minimum;
    int maximum;

    public int getMinimum() {
        return minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public Limits(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

//    @Override
//    public String toString() {
//        return "Limits{" +
//                "minimum=" + minimum +
//                ", maximum=" + maximum +
//                '}';
//    }
}
