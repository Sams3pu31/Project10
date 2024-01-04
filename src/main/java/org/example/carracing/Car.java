package org.example.carracing;

public class Car {
    private int distanceTraveled = 0;
    private final SpeedInterface speedInterface;
    private final int carNumber;

    Car(int carNumber, SpeedInterface speedInterface) {
        this.carNumber = carNumber;
        this.speedInterface = speedInterface;
    }

    void startRace() {
        System.out.println("Машина " + carNumber + " начала гонку!");
    }

    void move() {
        int speed = speedInterface.getSpeed();
        distanceTraveled += speed;
    }

    boolean isRaceOver(int distance) {
        return distanceTraveled >= distance;
    }
}



