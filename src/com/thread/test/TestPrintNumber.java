package com.thread.test;

import com.thread.insatances.PrintNumber;

public class TestPrintNumber {
    public static void main(String[] args) {
        for(int i = 1; i < 100; i++){
            PrintNumber printNumber = new PrintNumber(i);
            Thread t1 = new Thread(printNumber);
            t1.start();
        }
    }
}
