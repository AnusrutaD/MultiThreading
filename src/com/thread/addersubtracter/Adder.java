package com.thread.addersubtracter;


import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{
    private Count count;
    public Adder(Count count){
        this.count = count;
    }

    public void add(){

    }

    @Override
    public void run() {
            for (int i = 0; i < 100; i++) {
                synchronized (count) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count.incrementValue(i);
                    System.out.println("Add to: " + count.getValue());
                }
            }
    }
}
