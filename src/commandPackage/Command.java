package commandPackage;

public class Command implements ICommand {
    int value;
    Types type;

    public Command(int value, Types type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public Types getType() {
        return this.type;
    }

    @Override
    public void setValue(int newValue) {
        this.value = newValue;
    }
}
