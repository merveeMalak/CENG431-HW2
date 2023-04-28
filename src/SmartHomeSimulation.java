import java.util.Random;

public class SmartHomeSimulation {
    public void start() {
        final int DURATION = 20;

        ControlPanel controlPanel = new ControlPanel();
        Random rand = new Random();

        for (int i = 0; i < DURATION; i++) {
            controlPanel.mediator.getRoom().setRandomTemperature();
            System.out.printf("START ON THE %s. STATE => ", i + 1);
            controlPanel.printStatus();
            controlPanel.holdTemperature();
            int doorCommand = rand.nextInt(2);
            switch (doorCommand) {
                case 0 -> {
                    controlPanel.unlockDoor();
                    System.out.print("Door Unlocked");
                }
                case 1 -> {
                    controlPanel.lockDoor();
                    System.out.print("Door Locked");
                }
            }
            System.out.println(" Command Has Been Sent");

            int lightCommand = rand.nextInt(2);
            switch (lightCommand) {
                case 0 -> {
                    controlPanel.turnOffLights();
                    System.out.print("Lights Off");
                }
                case 1 -> {
                    controlPanel.turnOnLights();
                    System.out.print("Lights On");
                }
            }
            System.out.println(" Command Has Been Sent");

            System.out.printf("END ON THE %s. STATE => ", i + 1);
            controlPanel.printStatus();
            System.out.println("\n\n");
        }
    }
}
