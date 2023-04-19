import mediator.SmartHomeMediator;

public class SmartHomeApp {
    public static void main(String[] args) {
        SmartHomeMediator smartHomeMediator = new SmartHomeMediator();
        smartHomeMediator.processSensorReading();
    }
}