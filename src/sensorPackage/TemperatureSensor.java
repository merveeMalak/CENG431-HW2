package sensorPackage;

import mediatorPackage.Mediator;

import java.util.Random;

public class TemperatureSensor implements ISensor {
    Mediator mediator;

    public TemperatureSensor(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public int sendValue() {
        return this.mediator.getCurrentTemperature();
    }

}
