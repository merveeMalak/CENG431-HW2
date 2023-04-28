package mediatorPackage;

import actuatorPackage.DoorLock;
import actuatorPackage.LightBulb;
import actuatorPackage.Thermostat;
import commandPackage.*;
import roomPackage.Room;
import sensorPackage.LightSensor;
import sensorPackage.MotionSensor;
import sensorPackage.TemperatureSensor;


public class Mediator {
    private final LightSensor lightSensor;
    private final TemperatureSensor temperatureSensor;
    private final MotionSensor motionSensor;

    private final DoorLock doorLock;
    private final LightBulb lightBulb;
    private final Thermostat thermostat;

    private final Room room;

    public Mediator() {
        this.room = new Room(this);
        this.lightSensor = new LightSensor(this.room);
        this.temperatureSensor = new TemperatureSensor(this.room);
        this.motionSensor = new MotionSensor(this.room);

        this.doorLock = new DoorLock(this.room);
        this.lightBulb = new LightBulb(this.room);
        this.thermostat = new Thermostat(this.room);
    }

    public void handleCommand(ICommand command) {
        switch (command.getType()) {
            case Door -> doorLock.perform((DoorCommand) command);
            case Light -> lightBulb.perform((LightCommand) command);
            case Temperature -> thermostat.perform((TemperatureCommand) command);
        }
    }

    public boolean transferValueFromLightSensor() {
        return lightSensor.sendValue();
    }

    public boolean transferValueFromMotionSensor() {
        return motionSensor.sendValue();
    }

    public int transferValueFromTemperatureSensor() {
        return temperatureSensor.sendValue();
    }

    public Room getRoom() {
        return this.room;
    }

}
