package com.example.assignment1;

import javafx.application.Platform;

public class SelectionSort implements SortingStrategy {
    private SortingHubController controller;
    private int[] list;

    public SelectionSort(SortingHubController controller) {
        this.controller = controller;
    }

    @Override
    public void sort(int[] numArray) {

        int n = numArray.length;//store array length in a variable to make it easier to visualize (im just following Quazi's pseudo code honestly)
        //move boundary of the unsorted sub-array one by one
        for (int i = 0; i < n - 1; i++) {
            int smallestIndex = i;
            //find min element in the unsorted array
            for (int j = i + 1; j <= n - 1; j++) {
                if (numArray[j] < numArray[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            //switch the min element with the first element. has to be generic type T
            int temp = numArray[i];
            numArray[i] = numArray[smallestIndex];
            numArray[smallestIndex] = temp;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
            Platform.runLater(() -> {
                controller.updateGraph(numArray);
            });
        }

    }

    @Override
    public void run() {

    }
}
