package sensors;

import java.util.Random;

public class LightSensor implements ISensor{

    public LightSensor(){}

    @Override
    public String send() {
        Random random = new Random();
        String reading = "closed";
        int randomValue = random.nextInt(0,2);
        switch (randomValue){
            case 0 :
                reading = "closed";
                break;
            case 1 :
                reading = "opened";
                break;
        }
        System.out.println("light status in sensor: " + reading);
        return reading;
    }
}
