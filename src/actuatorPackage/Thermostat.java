package actuatorPackage;

import commandPackage.TemperatureCommand;
import roomPackage.Room;

public class Thermostat implements IActuator<TemperatureCommand> {
    Room room;

    public Thermostat(Room room) {
        this.room = room;
    }

    @Override
    public void perform(TemperatureCommand command) {
        this.room.setCurrentTemperature(command.getValue());
    }
}
