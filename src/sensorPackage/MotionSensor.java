package sensorPackage;

import roomPackage.Room;

public class MotionSensor implements ISensor<Boolean> {
    private final Room room;

    public MotionSensor(Room room) {
        this.room = room;
    }

    @Override
    public Boolean sendValue() {
        return this.room.getIsDoorOpen();
    }
}
