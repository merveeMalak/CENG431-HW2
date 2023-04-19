package mediator;

import commands.Command;

public interface ISmartHomeMediator {

    void processSensorReading();
    Command sendCommandToActuator();
}
