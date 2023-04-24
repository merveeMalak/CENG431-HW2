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
    int isDoorOpen;
    int isLightOn;
    int currentTemperature;
    LightSensor lightSensor;
    TemperatureSensor temperatureSensor;
    MotionSensor motionSensor;

    DoorLock doorLock;
    LightBulb lightBulb;
    Thermostat thermostat;

    public Mediator() {
        this.lightSensor = new LightSensor();
        this.temperatureSensor = new TemperatureSensor();
        this.motionSensor = new MotionSensor();

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

    public void holdTemperatureInRange() {
        int desiredTemperature = 0;
        if (this.currentTemperature > 25) {
            desiredTemperature = 25; // TODO MAYBE RANDOM
        } else if (this.currentTemperature < 20) {
            desiredTemperature = 20; // TODO MAYBE RANDOM
        }
        if (desiredTemperature != 0) {
            Command command = new Command(desiredTemperature, Types.Temperature);
            handleCommand(command);
        }
    }

    public void printStatus() {
        System.out.printf("Light:%s | Door:%s | Temperature:%s\n", this.isLightOn == 0 ? "Off" : "On", this.isDoorOpen == 0 ? "Off" : "On", this.currentTemperature);
    }

    public void setCurrentTemperature(int currentTemperature) {
        this.currentTemperature = currentTemperature;
    }
}
