package matrikelnummer_2227314.s49.command;

public class _CommandApplet {
    public static void main(String... args) {
        RemoteControl control = new RemoteControl();

        Light light = new Light();

        ICommand lightsOn = new LightsOnCommand(light);
        ICommand lightsOff = new LightsOffCommand(light);

        control.setCommand(lightsOn);
        control.pressButton();
        System.out.println(light);

        System.out.println();

        control.setCommand(lightsOff);
        control.pressButton();
        System.out.println(light);
    }
}
