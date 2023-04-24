package sensorPackage;

import java.util.Random;

public class MotionSensor implements ISensor {

    @Override
    public int sendValue() {
        Random rand = new Random();
        return rand.nextInt(2);
    }
}
