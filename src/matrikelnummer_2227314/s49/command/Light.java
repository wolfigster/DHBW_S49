package matrikelnummer_2227314.s49.command;

public class Light {
    private boolean isOn;

    public void switchOn() {
        isOn = true;
    }

    public void switchOff() {
        isOn = false;
    }

    public String toString() {
        return "light " + hashCode() + " : " + isOn;
    }
}
