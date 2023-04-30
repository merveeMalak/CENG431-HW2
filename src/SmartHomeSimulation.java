import controlPanelPackage.ControlPanel;
import controlPanelPackage.IControlPanel;

import java.util.Random;

public class SmartHomeSimulation {
    public void start() {
        final int DURATION = 20;

        IControlPanel controlPanel = new ControlPanel();
        Random rand = new Random();

        for (int i = 0; i < DURATION; i++) {
            // Setting temperature of the room randomly.
            controlPanel.getMediator().getRoom().setRandomTemperature();
            System.out.printf("START ON THE %s. STATE => ", i + 1);

            // Printing start on the state, it will change.
            controlPanel.printStatus();

            // Control Panel inner temperature check.
            controlPanel.holdTemperature();

            // In this simulation, the user will send always 2 commands (1 door command and 1 light command).
            // Choosing random door command.
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

            // End of the state, this mean is changes are effected.
            System.out.printf("END ON THE %s. STATE => ", i + 1);
            controlPanel.printStatus();
            System.out.println("\n\n");
        }
    }
}
