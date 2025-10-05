package main.algorithms;

import main.metrics.PerformanceTracker;

public class BubbleSort {

    private final PerformanceTracker tracker;

    public BubbleSort(PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    public void sort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                tracker.incrementComparisons();
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    tracker.incrementSwaps();
                    swapped = true;
                }
            }

            // Early termination
            if (!swapped) break;
        }
    }
}

