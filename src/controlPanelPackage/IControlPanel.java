package controlPanelPackage;

import mediatorPackage.Mediator;

public interface IControlPanel {
    void turnOffLights();

    void turnOnLights();

    void lockDoor();

    void unlockDoor();

    void holdTemperature();

    void printStatus();

    Mediator getMediator();
}
