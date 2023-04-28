package sensorPackage;

import roomPackage.Room;

public class TemperatureSensor implements ISensor<Integer> {
    private final Room room;

    public TemperatureSensor(Room room) {
        this.room = room;
    }

    @Override
    public Integer sendValue() {
        return this.room.getCurrentTemperature();
    }

}
