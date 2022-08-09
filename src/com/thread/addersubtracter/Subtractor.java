package com.thread.addersubtracter;

public class Subtractor {
    private Count count;
    public Subtractor(Count count){
        this.count = count;
    }

    public void substract(){
        for (int i = 0; i < 100; i++){
            int currentValue = count.getValue();
            int nextValue = currentValue - i;
            count.setValue(nextValue);
        }
    }
}
