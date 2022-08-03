package com.thread.mergesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> arrayToSort = new ArrayList<>(Arrays.asList(12,6,24,63,42,15,87,20));
        Sorter sorter = new Sorter(arrayToSort);
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<List<Integer>> futureSortedArray = executor.submit(sorter);
        List<Integer> sortedArray = null;
        try {
            sortedArray = futureSortedArray.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println(sortedArray);
        }

    }
}
