package com.thread.addersubtracter;

public class Adder {
    private Count count;
    public Adder(Count count){
        this.count = count;
    }

    public void add(){
        for (int i = 0; i < 100; i++){
            int currentValue = count.getValue();
            int nextValue = currentValue + i;
            count.setValue(nextValue);
        }
    }
}
