package com.thread.insatances;

public class PrintName extends Thread{
    @Override
    public void run(){
        System.out.println("Anusruta Dutta[Thread : " + Thread.currentThread().getName() + "]");
    }
}
