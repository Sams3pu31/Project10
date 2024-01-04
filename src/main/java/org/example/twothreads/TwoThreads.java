package org.example.twothreads;

public class TwoThreads {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> printNumbers(1));
        Thread thread2 = new Thread(() -> printNumbers(2));

        thread1.start();
        thread2.start();
    }

    private static void printNumbers(int threadNumber) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Поток " + threadNumber + ": число " + i);
        }
    }
}
