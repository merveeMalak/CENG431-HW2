package sensorPackage;

import mediatorPackage.Mediator;

public class MotionSensor implements ISensor {
    Mediator mediator;

    public MotionSensor(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public int sendValue() {
        return this.mediator.getIsDoorOpen();
    }
}
