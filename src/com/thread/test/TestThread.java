package com.thread.test;

import com.thread.insatances.PrintHelloWorld;
import com.thread.insatances.PrintName;

public class TestThread {
    public static void main(String[] args) {
        PrintHelloWorld printHelloWorld = new PrintHelloWorld();
        Thread t1 = new Thread(printHelloWorld);
        System.out.println("Hello World!![Thread : " + Thread.currentThread().getName() + "]");
        t1.start();
        PrintName printName = new PrintName();
        printName.start();
    }
}
