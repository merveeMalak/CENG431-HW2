package sensors;

import java.util.Random;

public class TemperatureSensor implements ISensor{
    public TemperatureSensor(){}

    @Override
    public String send() {
        Random random = new Random();
        int randomValue = random.nextInt(10,30);
        System.out.println("temperature in sensor: " + randomValue);
        return String.valueOf(randomValue);
    }
}
