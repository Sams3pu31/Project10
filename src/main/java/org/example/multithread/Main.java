package org.example.multithread;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(55) + 1; // нет в условиях четкого числа, поэтому будет рандомно, до 55 или любого,
        // которое хочется
        int numOfThreads = 4;

        SumCalculator sumCalculator = (count) -> {
            long sum = 0;
            for (int i = 1; i <= count; i++) {
                sum += (long) i * i;
            }
            return sum;
        };

        MultiThread calculator = new MultiThread();
        long totalSum = calculator.calculateSumWithThreads(n, numOfThreads, sumCalculator);

        System.out.println("Сумма квадратов первых " + n + " натуральных чисел: " + totalSum);
    }
}



