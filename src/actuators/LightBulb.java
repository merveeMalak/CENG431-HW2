package actuators;

import commands.Command;

public class LightBulb implements IActuator{
    private boolean isLightOn;

    public LightBulb(){
        this(false);

    }

    public LightBulb(boolean isLightOn){
        this.isLightOn = isLightOn;
    }

    @Override
    public void readCommandAndPerformAction(Command command) {
        switch (command){
            case TURN_ON -> isLightOn = true;
            case TURN_OFF -> isLightOn = false;
        }
        System.out.println("light bulb state: " + isLightOn);
    }


}
