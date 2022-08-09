package com.thread.addersubtracter;


import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{
    private Count count;
    private Lock lockForCount;
    public Adder(Count count, Lock lockForCount){
        this.count = count;
        this.lockForCount = lockForCount;
    }

    public void add(){

    }

    @Override
    public void run() {
        lockForCount.lock();
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
        lockForCount.unlock();
    }
}
