package com.thread.insatances;

public class PrintNumber implements Runnable {
    private int numberToPrint;

    public PrintNumber(int numberToPrint) {
        this.numberToPrint = numberToPrint;
    }

    @Override
    public void run() {
        System.out.println(numberToPrint + " print via Thread: [" + Thread.currentThread().getName() + "]");
    }
}
