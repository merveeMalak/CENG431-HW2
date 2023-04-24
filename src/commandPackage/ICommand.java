package commandPackage;

public interface ICommand {
    int getValue();

    Types getType();

    void setValue(int newValue);
}
