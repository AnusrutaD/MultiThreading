package com.thread.test;

import com.thread.insatances.PrintNumber;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TestExecutor {
    public static void main(String[] args) {
        Executor executor = Executors.newCachedThreadPool();
        for (int i = 1; i < 100; i++){
            PrintNumber printNumber = new PrintNumber(i);
            executor.execute(printNumber);
        }
    }
}
