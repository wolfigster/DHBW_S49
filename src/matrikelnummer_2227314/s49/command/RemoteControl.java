package matrikelnummer_2227314.s49.command;

public class RemoteControl {
    private ICommand command;

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void pressButton() {
        System.out.println("--- pressButton");
        command.execute();
    }
}
