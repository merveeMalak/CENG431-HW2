package actuatorPackage;

import commandPackage.ICommand;

public interface IActuator<T> {
    void perform(T command);
}
