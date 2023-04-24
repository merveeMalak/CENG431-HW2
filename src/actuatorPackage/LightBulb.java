package actuatorPackage;

import commandPackage.ICommand;
import mediatorPackage.Mediator;

public class LightBulb implements IActuator {
    Mediator mediator;

    public LightBulb(Mediator mediator){
        this.mediator = mediator;
    }

    @Override
    public void perform(ICommand command) {

    }
}
