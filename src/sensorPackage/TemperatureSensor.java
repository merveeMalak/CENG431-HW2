package sensorPackage;

import java.util.Random;

public class TemperatureSensor implements ISensor {
    int MAX = 30;
    int MIN = 10;

    @Override
    public int sendValue() {
        Random rand = new Random();
        return rand.nextInt((MAX - MIN) + 1) + MIN;
    }
}
