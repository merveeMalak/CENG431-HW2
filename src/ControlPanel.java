import commandPackage.*;
import mediatorPackage.Mediator;

public class ControlPanel {
    Mediator mediator;

    public ControlPanel() {
        this.mediator = new Mediator();
    }

    public void turnOffLights() {
        LightCommand lightCommand = new LightCommand(false);
        mediator.handleCommand(lightCommand);
    }

    public void turnOnLights() {
        LightCommand lightCommand = new LightCommand(true);
        mediator.handleCommand(lightCommand);
    }

    public void lockDoor() {
        DoorCommand doorCommand = new DoorCommand(false);
        mediator.handleCommand(doorCommand);
    }

    public void unlockDoor() {
        DoorCommand doorCommand = new DoorCommand(true);
        mediator.handleCommand(doorCommand);
    }

    public void holdTemperature() {
        int desiredTemperature = 0;
        int currentTemperature = this.mediator.transferValueFromTemperatureSensor();
        if (currentTemperature > 25) {
            desiredTemperature = 25;
        } else if (currentTemperature < 20) {
            desiredTemperature = 20;
        }
        if (desiredTemperature != 0) {
            TemperatureCommand temperatureCommand = new TemperatureCommand(desiredTemperature);
            System.out.printf("Control Panel set temperature: %s°C\n", desiredTemperature);
            this.mediator.handleCommand(temperatureCommand);
        }
    }

    public void printStatus() {
        System.out.printf("Light: %s | Door: %s | Temperature: %s°C\n", this.mediator.transferValueFromLightSensor() ? "On" : "Off", this.mediator.transferValueFromMotionSensor() ? "Unlocked" : "Locked", this.mediator.transferValueFromTemperatureSensor());
    }

}
