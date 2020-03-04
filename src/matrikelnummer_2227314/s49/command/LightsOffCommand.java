package matrikelnummer_2227314.s49.command;

public class LightsOffCommand implements ICommand {
    private Light light;

    public LightsOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.switchOff();
    }
}
