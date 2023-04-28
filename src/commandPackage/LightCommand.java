package commandPackage;

public class LightCommand extends Command<Boolean> {
    public LightCommand(Boolean value) {
        super(value, Types.Light);
    }
}
