import commandPackage.Command;
import commandPackage.Types;
import mediatorPackage.Mediator;

public class ControlPanel {
    Mediator mediator;

    public ControlPanel() {
        this.mediator = new Mediator();
    }

    void turnOffLights() {
        Command command = new Command(0, Types.Light);
        mediator.handleCommand(command);
    }

    void turnOnLights() {
        Command command = new Command(1, Types.Light);
        mediator.handleCommand(command);
    }

    void lockDoor() {
        Command command = new Command(0, Types.Door);
        mediator.handleCommand(command);
    }

    void unlockDoor() {
        Command command = new Command(1, Types.Door);
        mediator.handleCommand(command);
    }

    void setTemperature(int desiredTemperature) {
        Command command = new Command(desiredTemperature, Types.Temperature);
        mediator.handleCommand(command);
    }
}
