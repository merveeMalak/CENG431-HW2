package actuators;

import commands.Command;

public class Thermostat implements IActuator{
    private int currentTemperature;

    public Thermostat(){
        this(20);
    }
    public Thermostat(int currentTemperature){
        this.currentTemperature = currentTemperature;
    }
    @Override
    public void readCommandAndPerformAction(Command command) {
        switch (command){
            case DECREASE_TEMPERATURE -> currentTemperature -= 1;
            case INCREASE_TEMPERATURE -> currentTemperature += 1;
        }
        System.out.println("current temperature: " + currentTemperature);
    }
}
