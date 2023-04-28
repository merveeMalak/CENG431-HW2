package commandPackage;

public interface ICommand<T> {
    T getValue();

    Types getType();
}
