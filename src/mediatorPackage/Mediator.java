package mediatorPackage;

import actuatorPackage.DoorLock;
import actuatorPackage.LightBulb;
import actuatorPackage.Thermostat;
import commandPackage.Command;
import commandPackage.ICommand;
import commandPackage.Types;
import sensorPackage.LightSensor;
import sensorPackage.MotionSensor;
import sensorPackage.TemperatureSensor;


public class Mediator {
    private int isDoorOpen;
    private int isLightOn;
    private int currentTemperature;

    LightSensor lightSensor;
    TemperatureSensor temperatureSensor;
    MotionSensor motionSensor;

    DoorLock doorLock;
    LightBulb lightBulb;
    Thermostat thermostat;

    public Mediator() {
        this.isDoorOpen = 0;
        this.isLightOn = 0;
        this.currentTemperature = 20;

        this.lightSensor = new LightSensor(this);
        this.temperatureSensor = new TemperatureSensor(this);
        this.motionSensor = new MotionSensor(this);

        this.doorLock = new DoorLock(this);
        this.lightBulb = new LightBulb(this);
        this.thermostat = new Thermostat(this);
    }

    public void handleCommand(ICommand command) {
        switch (command.getType()) {
            case Door -> doorLock.perform(command);
            case Light -> lightBulb.perform(command);
            case Temperature -> thermostat.perform(command);
        }
    }

    public void getValuesFromSensors() {
        isLightOn = lightSensor.sendValue();
        isDoorOpen = motionSensor.sendValue();
        currentTemperature = temperatureSensor.sendValue();
    }

    public boolean isInTemperatureRange() {
        int desiredTemperature = 0;
        if (this.currentTemperature > 25) {
            desiredTemperature = 25;
        } else if (this.currentTemperature < 20) {
            desiredTemperature = 20;
        }
        if (desiredTemperature != 0) {
            Command holdCommand = new Command(desiredTemperature, Types.Temperature);
            System.out.printf("Mediator set temperature: %s°C\n", desiredTemperature);
            handleCommand(holdCommand);
        }
        return desiredTemperature == 0;
    }

    public void printStatus() {
        System.out.printf("Light: %s | Door: %s | Temperature: %s°C\n", this.isLightOn == 0 ? "Off" : "On", this.isDoorOpen == 0 ? "Locked" : "Unlocked", this.currentTemperature);
    }

    public void setCurrentTemperature(int currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public void setIsDoorOpen(int isDoorOpen) {
        this.isDoorOpen = isDoorOpen;
    }

    public void setIsLightOn(int isLightOn) {
        this.isLightOn = isLightOn;
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public int getIsDoorOpen() {
        return isDoorOpen;
    }

    public int getIsLightOn() {
        return isLightOn;
    }
}
