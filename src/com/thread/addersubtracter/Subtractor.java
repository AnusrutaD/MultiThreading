package com.thread.addersubtracter;

import java.util.concurrent.locks.Lock;

public class Subtractor  implements Runnable{
    private Count count;
    public Subtractor(Count count){
        this.count = count;
    }

    public void substract(){

    }

    @Override
    public void run() {
        synchronized (count) {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count.incrementValue(-i);
                System.out.println("Substaract to: " + count.getValue());
            }
        }
    }
}
