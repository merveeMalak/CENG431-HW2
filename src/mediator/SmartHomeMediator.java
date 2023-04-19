package mediator;

import actuators.IActuator;
import actuators.LightBulb;
import actuators.LockDoor;
import actuators.Thermostat;
import commands.Command;
import sensors.ISensor;
import sensors.LightSensor;
import sensors.MotionSensor;
import sensors.TemperatureSensor;

import java.util.ArrayList;
import java.util.List;

public class SmartHomeMediator {
    private List<IActuator> actuators;
    private IActuator lightBulb;
    private IActuator lockDoor;
    private IActuator thermostat;
    private ISensor lightSensor;
    private ISensor motionSensor;
    private ISensor temperatureSensor;

    private List<ISensor> sensors;
    private String readingLightSensor;
    private String readingMotionSensor;
    private String readingTemperatureSensor;

    public SmartHomeMediator(){

        this.lightBulb = new LightBulb();
        this.lockDoor = new LockDoor();
        this.thermostat = new Thermostat();
        this.lightSensor = new LightSensor();
        this.motionSensor = new MotionSensor();
        this.temperatureSensor = new TemperatureSensor();
        this.sensors = new ArrayList<>();
        this.sensors.add(lightSensor);
        this.sensors.add(motionSensor);
        this.sensors.add(temperatureSensor);
    }

    public void processSensorReading(){
        for (int i = 0; i < 4; i++){
            for (ISensor sensor : sensors){
                sendCommand(sensor.send());
            }
        }

    }
    public void sendCommand(String reading){
        if (reading.equals("opened")) lightBulb.readCommandAndPerformAction(Command.TURN_OFF);
        else if (reading.equals("closed")) lightBulb.readCommandAndPerformAction(Command.TURN_ON);
        else if (reading.equals("locked")) lockDoor.readCommandAndPerformAction(Command.UNLOCK_DOOR);
        else if (reading.equals("unlocked")) lockDoor.readCommandAndPerformAction(Command.LOCK_DOOR);
        else if (Integer.parseInt(reading) < 20) thermostat.readCommandAndPerformAction(Command.INCREASE_TEMPERATURE);
        else if (Integer.parseInt(reading) > 25) thermostat.readCommandAndPerformAction(Command.DECREASE_TEMPERATURE);
    }


}
