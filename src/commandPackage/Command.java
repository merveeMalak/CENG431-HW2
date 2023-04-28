package commandPackage;

public abstract class Command<T> implements ICommand<T> {
    private final T value;
    private final Types type;

    public Command(T value, Types type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public Types getType() {
        return this.type;
    }
}
