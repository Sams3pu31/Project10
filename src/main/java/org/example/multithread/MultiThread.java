package org.example.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultiThread {

    private static final Logger LOGGER = Logger.getLogger(MultiThread.class.getName());

    public long calculateSumWithThreads(int n, int numOfThreads, SumCalculator sumCalculator) {
        long totalSum = 0;
        ExecutorService executor = Executors.newFixedThreadPool(numOfThreads);

        try {
            List<Future<Long>> results = new ArrayList<>();

            int pieceSize = n / numOfThreads;
            int remaining = n % numOfThreads;

            for (int i = 0; i < numOfThreads; i++) {
                final int start = i * pieceSize + 1;
                final int end = (i == numOfThreads - 1) ? start + pieceSize + remaining - 1 : start + pieceSize - 1;

                results.add(executor.submit(() -> sumCalculator.calculateSum(end) - sumCalculator.calculateSum(start - 1)));
            }

            for (Future<Long> future : results) {
                totalSum += future.get();
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Произошла ошибка: " + e.getMessage(), e);
        } finally {
            executor.shutdown();
        }

        return totalSum;
    }
}
