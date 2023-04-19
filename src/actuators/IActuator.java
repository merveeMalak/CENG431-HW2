package actuators;

import commands.Command;

public interface IActuator {

    void readCommandAndPerformAction(Command command);


}
