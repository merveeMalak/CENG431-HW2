package actuatorPackage;

import commandPackage.DoorCommand;
import roomPackage.Room;

public class DoorLock implements IActuator<DoorCommand> {
    Room room;

    public DoorLock(Room room) {
        this.room = room;
    }

    @Override
    public void perform(DoorCommand command) {
        this.room.setIsDoorOpen(command.getValue());
    }
}
