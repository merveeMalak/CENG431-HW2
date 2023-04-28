package roomPackage;

public interface IRoom {
    boolean getIsDoorOpen();

    boolean getIsLightOn();

    int getCurrentTemperature();

    void setIsDoorOpen(boolean newValue);

    void setIsLightOn(boolean newValue);

    void setCurrentTemperature(int newValue);

    void setRandomTemperature();
}
