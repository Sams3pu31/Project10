package org.example.threads;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("Поток 1 начал работу");

            Thread thread2 = getThread();

            try {
                thread2.join();
            } catch (InterruptedException e) {
                System.err.println("Произошло исключение: " + e.getMessage());
            }

            for (int i = 0; i < 10; i++) {
                System.out.println("Поток 1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.err.println("Произошло исключение: " + e.getMessage());
                }
            }

            System.out.println("Поток 1 завершил работу");
        });

        thread1.start();
    }

    private static Thread getThread() {
        Thread thread2 = new Thread(() -> {
            System.out.println("Поток 2 начал работу");

            for (int i = 0; i < 10; i++) {
                System.out.println("Поток 2");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.err.println("Произошло исключение: " + e.getMessage());
                }
            }

            System.out.println("Поток 2 завершил работу");
        });

        thread2.start();
        return thread2;
    }
}