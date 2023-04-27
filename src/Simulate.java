import java.util.Random;

public class Simulate {
    public static void main(String[] args) {

        final int DURATION = 20;

        final int SELECTABLE_MAX_TEMPERATURE = 100;
        final int SELECTABLE_MIN_TEMPERATURE = 0;

        ControlPanel controlPanel = new ControlPanel();
        Random rand = new Random();

        for (int i = 0; i < DURATION; i++) {
            controlPanel.mediator.getValuesFromSensors();
            controlPanel.mediator.printStatus();
            if (controlPanel.mediator.isInTemperatureRange()){
                int command = rand.nextInt(5);
                switch (command) {
                    case 0 -> {
                        controlPanel.unlockDoor();
                        System.out.println("Door Unlocked");
                    }
                    case 1 -> {
                        controlPanel.lockDoor();
                        System.out.println("Door Locked");
                    }
                    case 2 -> {
                        controlPanel.turnOffLights();
                        System.out.println("Lights Off");
                    }
                    case 3 -> {
                        controlPanel.turnOnLights();
                        System.out.println("Lights On");
                    }
                    case 4 -> {
                        int desiredTemperature = rand.nextInt((SELECTABLE_MAX_TEMPERATURE - SELECTABLE_MIN_TEMPERATURE) + 1) + SELECTABLE_MIN_TEMPERATURE;
                        controlPanel.setTemperature(desiredTemperature);
                        System.out.printf("User Set Temperature: %s°C\n", desiredTemperature);
                    }
                }
            }
            controlPanel.mediator.printStatus();
            System.out.println("--------------------------------------");
        }
    }
}
