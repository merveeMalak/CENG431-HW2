package actuatorPackage;

import commandPackage.LightCommand;
import roomPackage.Room;

public class LightBulb implements IActuator<LightCommand> {
    Room room;

    public LightBulb(Room room) {
        this.room = room;
    }

    @Override
    public void perform(LightCommand command) {
        this.room.setIsLightOn(command.getValue());
    }
}
