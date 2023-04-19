package sensors;

import java.util.Random;

public class MotionSensor implements ISensor{
    public MotionSensor(){}

    @Override
    public String send() {
        Random random = new Random();
        String reading = "unlocked";
        int randomValue = random.nextInt(0,2);
        switch (randomValue){
            case 0 :
                reading = "unlocked";
                break;
            case 1 :
                reading = "locked";
                break;
        }
        System.out.println("locked status in sensor: " + reading);
        return reading;

    }
}
