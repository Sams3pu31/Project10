package org.example.carracing;

import java.util.Random;

public class Racing {

    public static void main(String[] args) {
        int distance = 100;

        Random random = new Random();
        SpeedInterface speedInterface = () -> random.nextInt(5) + 1;

        Car car1 = new Car(1, speedInterface);
        Car car2 = new Car(2, speedInterface);

        car1.startRace();
        car2.startRace();

        while (!(car1.isRaceOver(distance) || car2.isRaceOver(distance))) {
            car1.move();
            car2.move();
        }

        if (car1.isRaceOver(distance) && car2.isRaceOver(distance)) {
            System.out.println("Гонка завершилась вничью!");
        } else if (car1.isRaceOver(distance)) {
            System.out.println("Машина 1 победила!");
        } else {
            System.out.println("Машина 2 победила!");
        }
    }
}



