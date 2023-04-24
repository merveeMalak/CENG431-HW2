package actuatorPackage;

import commandPackage.ICommand;

public interface IActuator {
    void perform(ICommand command);
}
