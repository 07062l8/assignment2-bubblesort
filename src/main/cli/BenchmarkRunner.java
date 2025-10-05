package main.cli;

import main.algorithms.BubbleSort;
import main.metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000};
        Random random = new Random();

        try (FileWriter writer = new FileWriter("results.csv")) {
            writer.write("InputSize;Comparisons;Swaps;Time(ms);IsSorted\n");

            for (int n : sizes) {
                int[] arr = random.ints(n, 0, 100000).toArray();
                PerformanceTracker tracker = new PerformanceTracker();
                BubbleSort sorter = new BubbleSort(tracker);

                long start = System.nanoTime();
                sorter.sort(arr);
                long end = System.nanoTime();

                double timeMs = (end - start) / 1_000_000.0;
                boolean sorted = isSorted(arr);

                // Запись строки в CSV
                writer.write(n + ";" +
                        tracker.getComparisons() + ";" +
                        tracker.getSwaps() + ";" +
                        String.format("%.4f", timeMs) + ";" +
                        sorted + "\n");

                // Дополнительно выводим в консоль
                System.out.println("Input size: " + n);
                System.out.println(tracker);
                System.out.println("Time (ms): " + timeMs);
                System.out.println("Is sorted: " + sorted);
                System.out.println("---------------------------");
            }

            System.out.println("Results saved to results.csv");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) return false;
        }
        return true;
    }
}
