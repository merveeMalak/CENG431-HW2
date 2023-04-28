package commandPackage;

public class TemperatureCommand extends Command<Integer> {
    public TemperatureCommand(Integer value) {
        super(value, Types.Temperature);
    }
}
