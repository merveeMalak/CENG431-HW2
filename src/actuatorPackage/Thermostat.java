package actuatorPackage;

import commandPackage.ICommand;
import mediatorPackage.Mediator;

public class Thermostat implements IActuator {
    Mediator mediator;

    public Thermostat(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void perform(ICommand command) {
        this.mediator.setCurrentTemperature(command.getValue());
    }
}
