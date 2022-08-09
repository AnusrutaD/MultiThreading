package com.thread.addersubtracter;

public class Client {
    public static void main(String[] args) {
        Count count = new Count();
        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);
        adder.add();
        subtractor.substract();
        System.out.println(count.getValue());
    }
}
