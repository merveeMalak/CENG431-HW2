package sensorPackage;

import java.util.Random;

public class LightSensor implements ISensor {

    @Override
    public int sendValue() {
        Random rand = new Random();
        return rand.nextInt(2);
    }
}
