package main.metrics;

public class PerformanceTracker {
    private long comparisons;
    private long swaps;

    public void incrementComparisons() {
        comparisons++;
    }

    public void incrementSwaps() {
        swaps++;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public void reset() {
        comparisons = 0;
        swaps = 0;
    }

    @Override
    public String toString() {
        return "Comparisons: " + comparisons + ", Swaps: " + swaps;
    }
}
