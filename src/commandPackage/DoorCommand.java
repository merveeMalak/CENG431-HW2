package commandPackage;

public class DoorCommand extends Command<Boolean> {
    public DoorCommand(Boolean value) {
        super(value, Types.Door);
    }
}
