package sensorPackage;

import roomPackage.Room;

public class LightSensor implements ISensor<Boolean> {
    private final Room room;

    public LightSensor(Room room) {
        this.room = room;
    }

    @Override
    public Boolean sendValue() {
        return this.room.getIsLightOn();
    }
}
