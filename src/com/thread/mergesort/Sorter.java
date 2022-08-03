package com.thread.mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Sorter implements Callable<List<Integer>> {
    private List<Integer> arrayToSort;

    public Sorter(List<Integer> arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    @Override
    public List<Integer> call() throws Exception {
        int size = this.arrayToSort.size();
        if(size <= 1){
            return this.arrayToSort;
        }
        int mid = size / 2;
        List<Integer> leftArray = new ArrayList<Integer>();
        List<Integer> rightArray = new ArrayList<Integer>();
        for(int i = 0; i < mid; i++){
            leftArray.add(this.arrayToSort.get(i));
        }
        for (int i = mid; i < size; i++){
            rightArray.add(this.arrayToSort.get(i));
        }
        Sorter leftSorter = new Sorter(leftArray);
        Sorter rightSorter = new Sorter(rightArray);

        ExecutorService executor = Executors.newCachedThreadPool();

        Future<List<Integer>> leftSortedFuture = executor.submit(leftSorter);
        Future<List<Integer>> rightSortedFuture = executor.submit(rightSorter);

        List<Integer> leftSorted = leftSortedFuture.get();
        List<Integer> rightSorted = rightSortedFuture.get();

        List<Integer> answare = new ArrayList<Integer>();

        int leftIdx = 0, rightIdx = 0;
        while (leftIdx < leftSorted.size() && rightIdx < rightSorted.size()){
            if(leftSorted.get(leftIdx) < rightSorted.get(rightIdx)){
                answare.add(leftSorted.get(leftIdx++));
            }
            else {
                answare.add(rightSorted.get(rightIdx++));
            }
        }

        while (leftIdx < leftSorted.size()){
            answare.add(leftSorted.get(leftIdx++));
        }

        while (rightIdx < rightSorted.size()){
            answare.add(rightSorted.get(rightIdx++));
        }
        return answare;
    }
}
