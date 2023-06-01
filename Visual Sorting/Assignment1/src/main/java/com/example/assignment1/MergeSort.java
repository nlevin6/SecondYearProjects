package com.example.assignment1;

import javafx.application.Platform;

import java.util.Arrays;

public class MergeSort implements SortingStrategy {
    private SortingHubController controller;
    private int[] list;

    public MergeSort(SortingHubController controller) {
        this.controller = controller;
    }

    //this is actually in-place merge sort. But it's the same concept
    @Override
    public void sort(int[] numArray) {
        int i = 1;
        while (i <= numArray.length) {
            int j = 0;
            for (j = 0; j < numArray.length; j += 2 * i) {
                int left = j, right = Math.min(numArray.length, j + 2 * i);
                int mid = j + i;
                int p = left, q = mid;
                while (p < mid && q < right) {
                    if (numArray[p] < numArray[q]) { // if already sorted skip to next pair
                        p++;
                    } else { // else if I need to swap
                        int temp = numArray[q]; // store temp value
                        System.arraycopy(numArray, p, numArray, p + 1, q - p); // shift to the right
                        numArray[p] = temp; // update value
                        p++;
                        mid++;
                        q++; // go to next pair
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                    }
                    Platform.runLater(() -> {
                        controller.updateGraph(numArray);
                    });
                }
            }
            i *= 2;
        }
    }

    @Override
    public void run() {
    }
}
