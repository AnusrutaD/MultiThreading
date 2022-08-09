package com.thread.addersubtracter;

public class Count {
    private int value;

    public Count() {
        this.value = 0;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void incrementValue(int offset){
        this.value += offset;
    }
}
