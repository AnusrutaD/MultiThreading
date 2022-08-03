package com.thread.insatances;

public class PrintHelloWorld implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello World!!![Thread : " + Thread.currentThread().getName() + "]");
    }
}
