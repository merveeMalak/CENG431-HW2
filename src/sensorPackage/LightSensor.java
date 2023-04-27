package sensorPackage;

import mediatorPackage.Mediator;


public class LightSensor implements ISensor {
    Mediator mediator;

    public LightSensor(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public int sendValue() {
        return this.mediator.getIsLightOn();
    }
}
