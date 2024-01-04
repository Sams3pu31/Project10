package org.example.evenandodd;

public class EvenAndOdd {
    public static void main(String[] args) {
        Thread evenThread = new Thread(() -> printNumbers(true));

        Thread oddThread = new Thread(() -> printNumbers(false));

        evenThread.start();
        oddThread.start();
    }

    public static void printNumbers(boolean isEven) {
        for (int i = 1; i <= 10; i++) {
            if ((i % 2 == 0 && isEven) || (i % 2 != 0 && !isEven)) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
