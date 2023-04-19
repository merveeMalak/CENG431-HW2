package actuators;

import commands.Command;

public class LockDoor implements IActuator{
    private boolean isLockedDoor;

    public LockDoor(){
        this(false);
    }
    public  LockDoor(boolean isLockedDoor){
        this.isLockedDoor = isLockedDoor;
    }


    @Override
    public void readCommandAndPerformAction(Command command) {
        switch (command){
            case LOCK_DOOR -> isLockedDoor = true;
            case UNLOCK_DOOR -> isLockedDoor = false;
        }
        System.out.println("lock door state: " + isLockedDoor);
    }
}
