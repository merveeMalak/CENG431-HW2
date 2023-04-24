import java.util.Random;

public class Simulate {
    public static void main(String[] args) {
        int DURATION = 20;
        ControlPanel controlPanel = new ControlPanel();
        Random rand = new Random();

        for (int i = 0; i < DURATION; i++) {
            controlPanel.mediator.getValuesFromSensors();
            controlPanel.mediator.printStatus();
            int lockCommand = rand.nextInt(2);
            switch (lockCommand) {
                case 0 -> controlPanel.unlockDoor();
                case 1 -> controlPanel.lockDoor();
            }

            int lightCommand = rand.nextInt(2);
            switch (lightCommand) {
                case 0 -> controlPanel.turnOffLights();
                case 1 -> controlPanel.turnOnLights();
            }
            controlPanel.mediator.getValuesFromSensors();
            controlPanel.mediator.holdTemperatureInRange();
            controlPanel.mediator.printStatus();
            System.out.println("--------------------------------------");
        }
    }
}
