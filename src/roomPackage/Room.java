package roomPackage;

import mediatorPackage.Mediator;

import java.util.Random;


public class Room implements IRoom {
    // Setting limits the capability of the temperature change
    private final int POSSIBLE_MAX_TEMPERATURE = 30;
    private final int POSSIBLE_MIN_TEMPERATURE = 15;

    private boolean isDoorOpen;
    private boolean isLightOn;
    private int currentTemperature;

    private final Mediator mediator;

    public Room(Mediator mediator) {
        this.mediator = mediator;

        // Initial Room Values
        this.isDoorOpen = false;
        this.isLightOn = false;
        this.currentTemperature = 0;
    }

    @Override
    public boolean getIsDoorOpen() {
        return this.isDoorOpen;
    }

    @Override
    public boolean getIsLightOn() {
        return this.isLightOn;
    }

    @Override
    public int getCurrentTemperature() {
        return this.currentTemperature;
    }

    @Override
    public void setIsDoorOpen(boolean newValue) {
        this.isDoorOpen = newValue;
    }

    @Override
    public void setIsLightOn(boolean newValue) {
        this.isLightOn = newValue;
    }

    @Override
    public void setCurrentTemperature(int newValue) {
        this.currentTemperature = newValue;
    }

    @Override
    public void setRandomTemperature() {
        Random rand = new Random();
        this.currentTemperature = rand.nextInt((POSSIBLE_MAX_TEMPERATURE - POSSIBLE_MIN_TEMPERATURE) + 1) + POSSIBLE_MIN_TEMPERATURE;
    }
}
