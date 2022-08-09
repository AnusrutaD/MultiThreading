package com.thread.addersubtracter;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) {
        Count count = new Count();
        Lock lockForcount = new ReentrantLock();
        Adder adder = new Adder(count, lockForcount);
        Subtractor subtractor = new Subtractor(count, lockForcount);
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(adder);
        executor.execute(subtractor);
        try {
            executor.awaitTermination(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.println(count.getValue());
    }
}
