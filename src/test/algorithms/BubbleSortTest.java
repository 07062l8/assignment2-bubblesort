package test.algorithms;

import main.algorithms.BubbleSort;
import main.metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortTest {

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        PerformanceTracker tracker = new PerformanceTracker();
        BubbleSort sorter = new BubbleSort(tracker);
        sorter.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testSingleElement() {
        int[] arr = {42};
        PerformanceTracker tracker = new PerformanceTracker();
        BubbleSort sorter = new BubbleSort(tracker);
        sorter.sort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    public void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        PerformanceTracker tracker = new PerformanceTracker();
        BubbleSort sorter = new BubbleSort(tracker);
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testReverseArray() {
        int[] arr = {5, 4, 3, 2, 1};
        PerformanceTracker tracker = new PerformanceTracker();
        BubbleSort sorter = new BubbleSort(tracker);
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testDuplicates() {
        int[] arr = {3, 1, 2, 3, 1};
        PerformanceTracker tracker = new PerformanceTracker();
        BubbleSort sorter = new BubbleSort(tracker);
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, arr);
    }
}

