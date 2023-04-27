package actuatorPackage;

import commandPackage.ICommand;
import mediatorPackage.Mediator;

public class DoorLock implements IActuator {
    Mediator mediator;

    public DoorLock(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void perform(ICommand command) {
        this.mediator.setIsDoorOpen(command.getValue());
    }
}
