package com.thread.addersubtracter;


public class Adder implements Runnable{
    private Count count;
    public Adder(Count count){
        this.count = count;
    }

    public void add(){

    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            int currentValue = count.getValue();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int nextValue = currentValue + i;
            count.setValue(nextValue);
        }
    }
}
