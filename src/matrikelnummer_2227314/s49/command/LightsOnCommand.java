package matrikelnummer_2227314.s49.command;

public class LightsOnCommand implements ICommand {
    private Light light;

    public LightsOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.switchOn();
    }
}
